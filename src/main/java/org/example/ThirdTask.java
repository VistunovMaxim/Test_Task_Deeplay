package org.example;

public class ThirdTask {

    public static void playDiceGame(int firstPlayerSeq, int secondPlayerSeq, int countDiceRoll, int countOfGames) {
        int a;
        int b;
        int matchesFirstPlayer = 0;
        int matchesSecondPlayer = 0;
        int matchesDraw = 0;
        double probability;
        String sequence;

        System.out.println("Вероятность комбинации ПЕРВОГО игрока - " +
                probablyOfWinSeq(Integer.toString(firstPlayerSeq), countDiceRoll));
        System.out.println("Вероятность комбинации ВТОРОГО игрока - " +
                probablyOfWinSeq(Integer.toString(secondPlayerSeq), countDiceRoll));
        System.out.println("ИГРА НАЧАЛАСЬ!");

        for (int i = 0; i < countOfGames; i++) {

            sequence = diceRolls(countDiceRoll);

            a = hitCounting(sequence, Integer.toString(firstPlayerSeq));
            b = hitCounting(sequence, Integer.toString(secondPlayerSeq));

            if (a == b) {
                matchesDraw++;
            } else if (a > b) {
                matchesFirstPlayer++;
            } else {
                matchesSecondPlayer++;
            }
        }

        probability = (double) matchesFirstPlayer / (double) countOfGames * 100;
        System.out.println("Побед ПЕРВОГО (" + firstPlayerSeq + ") игрока - " + matchesFirstPlayer +
                " раз, в " + String.format("%.2f", probability) + "% случаев");

        probability = (double) matchesSecondPlayer / (double) countOfGames * 100;
        System.out.println("Побед ВТОРОГО (" + secondPlayerSeq + ") игрока - " + matchesSecondPlayer +
                " раз, в " + String.format("%.2f", probability) + "% случаев");

        probability = (double) matchesDraw / (double) countOfGames * 100;
        System.out.println("Ничьи - " + matchesDraw + " раз, в " +
                String.format("%.2f", probability) + "% случаев");

    }

    private static String diceRolls(int countDiceRoll) {
        StringBuilder sequence = new StringBuilder();
        for (int j = 0; j < countDiceRoll; j++) {
            sequence.append(1 + (int) (Math.random() * (6 - 1 + 1)));
        }
        return sequence.toString();
    }

    private static int hitCounting(String diceRollSeq, String seq) {
        return (diceRollSeq.length() - diceRollSeq.replace(seq, "").length()) / seq.length();
    }

    private static String probablyOfWinSeq(String playerSeq, int countDiceRoll) {
        int a;
        int b;
        int matches = 0;
        int matchesDraw = 0;

        String sequence;

        for (int i = 111; i < 667; i++) {
            for (int j = 0; j < 100; j++) {
                sequence = diceRolls(countDiceRoll);

                a = hitCounting(sequence, playerSeq);
                b = hitCounting(sequence, Integer.toString(i));

                if (a == b) {
                    matchesDraw++;
                }else if (a > b) {
                    matches++;
                }
            }
        }
        return String.format("%.2f%% на победу и %.2f%% на ничью", (double) matches / 55600 * 100, (double) matchesDraw / 55600 * 100);
    }
}