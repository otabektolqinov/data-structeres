package org.example.arrays;

import java.util.Arrays;

public class MultiDimensionalArray {
    public static void main(String[] args) {
        int[][] table = new int[3][6];

        /*for (int i = 0; i < 3; i++) {
            int[] row = table[i];
            for (int j = 0; j < 6; j++) {
                row[j] = (int) (Math.random() * 100);
            }
        }

        for (int i = 0; i < 3; i++) {
            int[] row = table[i];
            for (int j = 0; j < 6; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }*/

        int[] array = new int[3];

        array[0] = 1;
        array[1] = 2;
        array[2] = 3;

        int[] array2 = new int[10];

        System.arraycopy(array, 0, array2, 2, array.length - 1);

        System.out.println(Arrays.toString(array2));
    }
}
