package org.example;

import java.util.ArrayList;

public class ForthTask {

    public static String findRightWayToGroup(ArrayList<Integer> initialList, int k) {
        ArrayList<Integer> localList = initialList;
        StringBuilder result = new StringBuilder();

        ArrayList<Integer> correctSeq = findCorrectSeqFromSum(k, sum(initialList));

        if (correctSeq == null) {
            return "Невозможно";
        }

        for (Integer num : correctSeq) {
            ArrayList<Integer> resultPair = findNumFromList(localList, num);
            if (resultPair == null) {
                return "Невозможно";
            }
            result.append(num).append(" - [");
            for (Integer res : resultPair) {
                result.append("(").append(res).append(")");
            }
            result.append("]  ");

            removeUsedNumFromList(localList, resultPair);
        }
        return result.toString();
    }

    public static ArrayList<Integer> findNumFromList(ArrayList<Integer> list, int num) {
        int searchValue = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer integer : list) {
            if (integer == num) {
                result.add(integer);
                return result;
            }
        }

        for (int k = 0; k < list.size(); k++) {
            for (int i = k; i < list.size(); i++) {
                searchValue += list.get(i);
                result.add(list.get(i));
                for (int j = i + 1; j < list.size(); j++) {
                    if (searchValue + list.get(j) == num) {
                        result.add(list.get(j));
                        return result;
                    }
                }
            }
            searchValue = 0;
            result.clear();
        }
        return null;
    }


    private static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        return sum;
    }

    public static ArrayList<Integer> findCorrectSeqFromSum(int k, int resultSum) {
        int sum = 0;
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (sum <= resultSum) {
            list.clear();
            sum = 0;
            index++;
            for (int i = index; i < k + index; i++) {
                sum += i;
                list.add(i);
            }
            if (sum == resultSum) {
                return list;
            }
        }
        return null;
    }

    private static void removeUsedNumFromList(ArrayList<Integer> initialList, ArrayList<Integer> usedNum) {
        for (int i = 0; i < initialList.size(); i++) {
            for (int j = 0; j < usedNum.size(); j++) {
                if (initialList.get(i).equals(usedNum.get(j))) {
                    initialList.remove(i);
                    usedNum.remove(j);
                    i -= 1;
                    break;
                }
            }
        }
    }
}

