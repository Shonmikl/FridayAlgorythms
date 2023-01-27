import _20_01_2023.merge.Merge;
import _20_01_2023.quick.Quick;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class TestTime {
    private static int[] createArr(int n){
        int[] arr  = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(n);
        }
        return arr;
    }

    private static List<Integer> createList(int n){
        List<Integer> list  = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Random().nextInt(n));
        }
        return list;
    }

    private static void searchPereborArr(int[] arr, int a) {
        for (int j : arr) {
            if (j == a) {
                System.out.println("DONE!");
                break;
            }
        }
    }

    private static void searchPereborList(List<Integer> list, int a) {
        for (int j : list) {
            if (j == a) {
                System.out.println("DONE!");
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] testArr = createArr(50_000_000);
        List<Integer> list;
        list = createList(50_000_000);

        long pereborTime = System.currentTimeMillis();
        //searchPereborArr(testArr, testArr[testArr.length-1]);
        searchPereborList(list, list.size()-1);
        System.out.println("Perebor time: " + (System.currentTimeMillis() - pereborTime));

        long mergeSortTime = System.currentTimeMillis();
        Quick.quickSort1(testArr, 0, testArr.length-1);
        System.out.println("Quick: " + (System.currentTimeMillis() - mergeSortTime));

    }
}