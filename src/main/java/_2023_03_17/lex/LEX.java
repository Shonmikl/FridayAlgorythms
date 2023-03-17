package _2023_03_17.lex;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class LEX {

    /**
     * expr
     * plus/minus
     * multiply/div
     * factor
     */
    public static void main(String[] args) {
        String expression = "100/2-2*(4*5/2+2/(10-8)/2)"; //52
        int a = 100/2-2*(4*5/2+2/(10-8)/2);
        //100 - 2 * (4 * 5 + 2 * (10 - 8))
        List<Token> tokens = lexAnalyzer(expression);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(tokens);
        System.out.println(expr(lexemeBuffer));
    }

    //1. Lexeme Type
    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
        NUMBER,
        END
    }

    //2. Utility Class
    @ToString
    @AllArgsConstructor
    public static class Token {
        LexemeType type;
        String value; // String eq

        public Token(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }
    }

    //Utility Class 2
    @ToString
    public static class LexemeBuffer {
        private int position;
        public List<Token> tokens;

        public LexemeBuffer(List<Token> tokens) {
            this.tokens = tokens;
        }

        //get Lexemes
        public Token next() {
            return tokens.get(position++);
        }
        //go back
        public void back() {
            position--;
        }
    }

    public static List<Token> lexAnalyzer(String expText) {
        ArrayList<Token> tokens = new ArrayList<>();
        int pos = 0;

        //Пока не дошли до конца текста
        //идем по String и генерируем лексемы
        while (pos < expText.length()) {
            //мы будем брать каждый символ из String и
            //смотреть что это за символ, и далее добавлять его
            //в наш массив лексем
            char c = expText.charAt(pos);
            switch (c) {
                case '(' -> {
                    tokens.add(new Token(LexemeType.LEFT_BRACKET, c));
                    pos++;
                }
                case ')' -> {
                    tokens.add(new Token(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                }
                case '+' -> {
                    tokens.add(new Token(LexemeType.OP_PLUS, c));
                    pos++;
                }
                case '-' -> {
                    tokens.add(new Token(LexemeType.OP_MINUS, c));
                    pos++;
                }
                case '*' -> {
                    tokens.add(new Token(LexemeType.OP_MUL, c));
                    pos++;
                }
                case '/' -> {
                    tokens.add(new Token(LexemeType.OP_DIV, c));
                    pos++;
                }
                default -> {
                    //тут будем проверять на цифры
                    if (c <= '9' && c >= '0') {
                        //то тогда просто создаем StringBuilder
                        //куда мы будем добавлять символы
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            //если мы вдруг достигли конца нашей строки,
                            //то тогда brake
                            if (pos >= expText.length()) {
                                break;
                            }
                            //далее просто достаем след символ из строки
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        tokens.add(new Token(LexemeType.NUMBER, sb.toString()));
                    } else {
                        //далее проверим что если наша лексема не число,
                        //а символ не пробел
                        if (c != ' ') {
                            //тогда в нашем выражении ошибка
                            throw new RuntimeException("Unexpected token: --> " + c);
                        }
                        //если пробел то просто пропускаем
                        pos++;
                    }
                }
            }
        }
        tokens.add(new Token(LexemeType.END, ""));
        return tokens;
    }

    public static int expr(LexemeBuffer lexemes) {
        Token token = lexemes.next();
        //сделаем проверку на пустое выражение
        if (token.type == LexemeType.END) {
            return 0;
        } else {
            //иначе вернемся назад и запустим
            //вычисления + и -
            lexemes.back();
            return plusMinus(lexemes);
        }
    }

    //100 - 2 * ( 4 * 5 + 2 * ( 16 / 4 + 8 ) )
    private static int plusMinus(LexemeBuffer lexemes) {
        int value = multDiv(lexemes);
        while (true) {
            Token token = lexemes.next();
            switch (token.type) {
                case OP_PLUS -> value += multDiv(lexemes);
                case OP_MINUS -> value -= multDiv(lexemes);
                case END, RIGHT_BRACKET -> {
                    lexemes.back();
                    return value;
                }
                default -> throw new RuntimeException("Unexpected token");
            }
        }
    }

    private static int multDiv(LexemeBuffer lexemes) {
        int value = factor(lexemes);
        while (true) {
            //достаем след лексему
            Token token = lexemes.next();
            switch (token.type) {
                case OP_MUL -> value *= factor(lexemes);
                case OP_DIV -> value /= factor(lexemes);
                case END, RIGHT_BRACKET, OP_PLUS, OP_MINUS -> {
                    //тут делаем шаг назад
                    lexemes.back();
                    return value;
                }
                default -> throw new RuntimeException("Unexpected token");
            }
        }
    }

    private static int factor(LexemeBuffer lexemes) {
        //читать лексему
        Token token = lexemes.next();
        //проверяем ее тип
        switch (token.type) {
            case NUMBER -> {
                return Integer.parseInt(token.value);
            }
            case LEFT_BRACKET -> {
                //если это левая скобка, то значит что там
                //выражение
                int value = expr(lexemes);
                token = lexemes.next();
                //если правой скобки нет, то
                //выражение написано не корректно
                if (token.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token");
                }
                return value;
            }
            default -> throw new RuntimeException("Unexpected token");
        }
    }
}