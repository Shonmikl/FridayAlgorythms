public class DEL {
    public static void main(String[] args) {
        String str = new String();

        int[] counts = new int[26]; // создаем массив для подсчета букв, 26 - число букв в английском алфавите
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                counts[ch - 'A']++; // увеличиваем счетчик соответствующей буквы
            }
            System.out.println(str.charAt(i));
        }
        // выводим результаты
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                System.out.println((char) ('A' + i) + " - " + counts[i]);
            }
        }


    }
}
