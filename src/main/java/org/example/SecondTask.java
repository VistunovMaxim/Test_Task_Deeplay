package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondTask {

    public static void frequencyOfNum(int arrSize) {
        int minValue = 0;
        int maxValue = 100;
        int maxFrequency = 0;
        int frequency;
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Integer[] initialArr = new Integer[arrSize];

        System.out.print("Массив - ");
        for (int i = 0; i < initialArr.length; i++) {
            initialArr[i] = minValue + (int) (Math.random() * (maxValue - minValue + 1));
            System.out.print(initialArr[i] + " ");
        }

        Collections.addAll(list, initialArr);

        for (Integer num : list) {
            frequency = Collections.frequency(list, num);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        for (Integer num : list) {
            frequency = Collections.frequency(list, num);
            if (frequency == maxFrequency && !result.contains(num)) {
                result.add(num);
            }
        }

        System.out.print("\nВстречается(ются) " + maxFrequency + " раз(а): ");
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}
