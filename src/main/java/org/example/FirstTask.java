package org.example;

import java.util.Arrays;
import java.util.Collections;

public class FirstTask {
    public static void arraySort(int arrSize) {
        int minValue = 0;
        int maxValue = 30;
        int lastIndex = 0;
        int[] resultArr = new int[arrSize];
        Integer[] initialArr = new Integer[arrSize];

        System.out.print("Изначальный массив - ");
        for (int i = 0; i < arrSize; i++) {
            initialArr[i] = minValue + (int) (Math.random() * (maxValue - minValue + 1));
            System.out.print(initialArr[i] + " ");
        }

        Arrays.sort(initialArr);
        for (Integer num : initialArr) {
            if (num % 2 != 0) {
                resultArr[lastIndex++] = num;
            }
        }

        for (Integer num : initialArr) {
            if (num == 0) {
                resultArr[lastIndex++] = num;
            }
        }

        Arrays.sort(initialArr, Collections.reverseOrder());
        for (Integer num : initialArr) {
            if (num % 2 == 0 && num != 0) {
                resultArr[lastIndex++] = num;
            }
        }

        System.out.print("\nПереупорядоченный массив - ");
        for (int num : resultArr) {
            System.out.print(num + " ");
        }
    }
}

