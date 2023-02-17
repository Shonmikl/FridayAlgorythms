package _10_02_2023.haff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Haffman {
    public static void main(String[] args) {
        String text = "Yahoo, which has been owned by " +
                "private equity firm Apollo Global Management " +
                "since a $5bn buyout in 2021, added that the move " +
                "would enable the company to narrow its focus and " +
                "investment on its flagship ad business called DSP, " +
                "or demand-side platform.";

        //Считаем символы
        TreeMap<Character, Integer> frequencies = countFrequency(text);

        //Генерируем список листов нашего дерева
        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : frequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, frequencies.get(c)));
        }

        //Строим дерево
        CodeTreeNode tree = huffman(codeTreeNodes);

        //Генерим коды
        TreeMap<Character, String> codes = new TreeMap<>();
        for (Character c : frequencies.keySet()) {
            //добавляем код для каждого символа из нашего дерева
            codes.put(c, tree.getCodeForCharacter(c, ""));
        }

        System.out.println("Таблица кодов: " + codes);

        //Кодируем текст
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            encoded.append(codes.get(text.charAt(i)));
        }

        System.out.println("Размер исходной строки: " + text.getBytes().length * 8 + " бит.");
        System.out.println("Размер сжатой строки: " + encoded.length() + " бит.");
        System.out.println("Биты сжатой строки: " + encoded);

        //Надо раскодировать
        String decoded = huffmanDecode(encoded.toString(), tree);

        System.out.println("Декодированный текст: " + decoded);
    }

    //1. Сколько каждый символ встречается в тексте
    private static TreeMap<Character, Integer> countFrequency(String text) {
        TreeMap<Character, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            Integer count = freqMap.get(c);
            freqMap.put(c, count != null ? count + 1 : 1);
        }
        return freqMap;
    }

    //2. Класс для предоставления кодового дерева
    private static class CodeTreeNode implements Comparable<CodeTreeNode> {

        //Хранимый символ
        Character content;

        //кол-во
        int weight;

        //левый и правый потомок
        CodeTreeNode left;
        CodeTreeNode right;

        public CodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        //o1.compareTo(o2) для сортировки дерева
        public int compareTo(CodeTreeNode o) {
            return o.weight - weight;
        }

        /**
         * функция, которая делает проход по кодовому дереву
         * от корня до конкретного символа и учитывает
         * 0 или 1 при совершении поворотов
         * <p>
         * в качестве параметров она будет принимать символ
         * который м ищем и путь в виде \0110111001110010101\
         */
        public String getCodeForCharacter(Character ch, String parentPath) {
            //мы ищем Character ch
            if (content == ch) {
                //то возвращаем путь
                return parentPath;
            } else {
                //если есть левый потомок
                if (left != null) {
                    //то тогда вызываем рекурсивно ту же функцию
                    //далее передаем символ, который ищем, и дописываем в путь нолик
                    String path = left.getCodeForCharacter(ch, parentPath + 0);
                    if (path != null) {
                        //то это значит что в нашей ветке нашелся нужный символ
                        //и это значит что надо вернуть путь который из себя
                        //представляет код
                        return path;
                    }
                }
                if (right != null) {
                    String path = right.getCodeForCharacter(ch, parentPath + 1);
                    if (path != null) {
                        return path;
                    }
                }
            }
            return null;
        }
    }


    //3. Напишем алгоритм, который возвращает дерево, и принимает
    //в качестве параметра список узлов
    private static CodeTreeNode huffman(ArrayList<CodeTreeNode> codeTreeNodes) {
        //пока список узлов больше чем 1
        while (codeTreeNodes.size() > 1) {
            //упорядочим узлы по весам
            Collections.sort(codeTreeNodes);

            //берем из листа два узла с самыми маленькими значениями
            //и сразу удаляем их из листа
            //далее эти два узла свяжем промежуточным узлом
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            //нам надо создать промежуточный узел
            //вес которого будет равен сумме весов двух минимальных узлов
            CodeTreeNode parent = new CodeTreeNode(null, right.weight + left.weight, left, right);

            //прокручиваем этот алгоритм до тех, пор пока у нас не останется один узел который и
            //будет корнем
            codeTreeNodes.add(parent);
        }
        return codeTreeNodes.get(0);
    }

    //4. Декодируем обратно в текст
    private static String huffmanDecode(String encoded, CodeTreeNode tree) {
        StringBuilder decoded = new StringBuilder();

        //переменная для хранения узла, который будем получать пока будем
        //идти по нашему кодовому дереву
        CodeTreeNode node = tree;

        //теперь идем по битам (зашифрованной строке)
        for (int i = 0; i < encoded.length(); i++) {
            //если текущий бит 0 -> идем налево
            node = encoded.charAt(i) == '0' ? node.left : node.right;

            //если мы дошли до какого-то листа и у него есть символ
            if (node.content != null) {
                //тогда добавляем этот символ в последовательность
                decoded.append(node.content);
                //далее возвращаем текущий узел
                node = tree;
            }
        }
        return decoded.toString();
    }
}