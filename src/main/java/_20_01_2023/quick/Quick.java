package _20_01_2023.quick;

import java.util.Arrays;
import java.util.Random;

public class Quick {
    static int[] array = new int[100_000_000];

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100_000_000);
        }
        long time = System.currentTimeMillis();
//        System.out.println(Arrays.toString(array));
//        System.out.println("********************");
        quickSort1(array, 0, array.length-1);
//        System.out.println(Arrays.toString(array));
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void quickSort1(int[] array, int low, int high) {
        //завершаем работу если длина 0
        if (array.length == 0) {
            return;
        }

        //Если дальше некуда двигаться, то завершаем работу
        if (low >= high) {
            return;
        }

        //опорный элемент
        int middle = low + (high - low) / 2;
        int opo = array[middle];

        //разделение на подмассивы
        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < opo) {
                i++;
            }

            while (array[j] > opo) {
                j--;
            }

            //поменять местами
            if (i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }

        //вызов рекурсии для сортировки левой и правой части
        if (low < j) {
            quickSort(array, low, j);
        }

        if (high > i) {
            quickSort(array, i, high);
        }
    }

    public static int partition(int[] array, int begin, int end) {
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[end]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[end];
        array[end] = array[counter];
        array[counter] = temp;
        return counter;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if(end <= begin) {
            return;
        }
        // [- - - - - - - - - - - - ]
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot + 1, end);
    }
}