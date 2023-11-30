package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int variable = 0;
        int firstPlayerSeq;
        int secondPlayerSeq;
        int countDiceRoll;
        int countOfGames;

        while (variable != 5) {

            System.out.println("""
                    \n
                    Выберите номер задания:
                    1) Сортировка массива
                    2) Поиск самого повторяющегося числа в массиве
                    3) Игра в кости
                    4) Приведение набора чисел к последовательности
                    5) Выход
                    """);

            variable = scanner.nextInt();

            switch (variable) {
                case 1 -> {
                    System.out.println("Введите желаемый размер массива: ");
                    FirstTask.arraySort(scanner.nextInt());
                }

                case 2 -> {
                    System.out.println("Введите желаемый размер массива: ");
                    SecondTask.frequencyOfNum(scanner.nextInt());
                }

                case 3 -> {
                    System.out.println("Укажите последовательность ПЕРВОГО игрока:");
                    firstPlayerSeq = scanner.nextInt();
                    System.out.println("Укажите последовательность ВТОРОГО игрока:");
                    secondPlayerSeq = scanner.nextInt();
                    System.out.println("Укажите кол-во бросков кости:");
                    countDiceRoll = scanner.nextInt();
                    System.out.println("Сколько игр Вы бы хотели сыграть сразу:");
                    countOfGames = scanner.nextInt();
                    ThirdTask.playDiceGame(firstPlayerSeq, secondPlayerSeq, countDiceRoll, countOfGames);
                }

                case 4 -> {
                    System.out.println("Укажите набор чисел (по одному числу через ENTER). Закончить ввод - '0' ");
                    while (true) {
                        variable = scanner.nextInt();
                        if (variable == 0) {
                            break;
                        }
                        list.add(variable);
                    }
                    System.out.println("Укажите кол-во частей для разделения:");
                    variable = scanner.nextInt();
                    System.out.println(ForthTask.findRightWayToGroup(list, variable));
                    variable = 0;
                }

                case 5 -> System.out.println("Выход");

                default -> System.out.println("Введено неверное значение");
            }
        }
    }
}
