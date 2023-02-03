package _03_02_2023;

public class Min {
    public static void getMin(int[] arr) {
        int minDigit = arr[0];
        int index = 0;
        // {12, 0, 6, 5, 47, 89, 65, 41, -3, 36, 54, 8, 52};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minDigit) {
                minDigit = arr[i];
                index = i;
            }
        }

        System.out.println("Min digit is: " + minDigit);
        System.out.println("Mindigit's index is: " + index);
    }

    public static void getSecondMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        // {-12, 0, 6, 5, 47, 89, 65, 41, -3, 36, 54, 8, 52};
        //{8 8 8 8 8 8 8 8 8 8 8 8 8}
        for (int j : arr) {
            if (j < min) {
                min2 = min;
                min = j;
            } else if (j < min2 && j != min) {
                min2 = j;
            }
        }

        if (min2 != Integer.MAX_VALUE) {
            System.out.println("MIN2: " + min2);

        } else {
            System.out.println("There isn't second min digit in the array");
        }

        System.out.println("MIN1: " + min);
    }

    public static void main(String[] args) {
        int[] arr = {12, 0, 6, 5, 47, 89, 65, 41, -3, 36, 54, 8, 52};
        //getMin(arr);
        getSecondMin(arr);
    }
}