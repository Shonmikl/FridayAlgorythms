package _2023_03_10;

import java.util.ArrayList;

public class Dynamic {
    static long iterCounter = 0;
    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9, 3, 1, 9, 8, 7, 6, 7, 6, 4,};
        int[] prices =  {1, 6, 4, 7, 6, 4, 2, 8, 6, 1, 4, 4, 5, 8};

        int maxWeight = 29;
        int count = weights.length;

        int[][] A;

        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[maxWeight + 1];
        }

        for (int k = 0; k <= count; k++) {

            for (int s = 0; s <= maxWeight; s++) {
                iterCounter++;
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    if (s >= weights[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - weights[k - 1]] + prices[k - 1]);
                    } else {
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(A, weights, count, maxWeight, result);

        System.out.println("Оптимальное содержимое рюкзака: ");
        for (Integer integer : result) {
            System.out.println(integer);
        }

        System.out.println("[" + iterCounter + "]");
    }

    private static void traceResult(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        iterCounter++;
        if (A[k][s] == 0) {
            return;
        }

        if (A[k - 1][s] == A[k][s]) {
            traceResult(A, weight, k - 1, s, result);
        } else {
            traceResult(A, weight, k - 1, s - weight[k - 1], result);
            result.add(k);
        }
    }
}