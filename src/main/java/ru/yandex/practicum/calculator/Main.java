package ru.yandex.practicum.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // Проверка ввода числа друзей
        int friends = 0;
        while (true) {
            System.out.println("На сколько друзей надо поделить чек?");
            if (scanner.hasNextInt()) {
                friends = scanner.nextInt();
                if (friends < 1) {
                    System.out.println("(^_~) Количество друзей не может быть 0 и с минусом. Пожалуйста, введите корректное значение.");
                } else if (friends == 1) {
                    System.out.println("(^_~) Вы один?. Пожалуйста, введите корректное значение.");
                } else {
                    break;
                }
            } else {
                System.out.println("(^_~) Недопустимые символы. Пожалуйста, введите число.");
                scanner.next(); // Очистить буфер ввода
            }
        }
        scanner.nextLine(); // Строка для считывания символа новой строки
        System.out.println("Напишите название товара");


        while (true) {
            Item item = new Item();
            item.name = scanner.nextLine();
            while (true) {
                System.out.println("Введите цену");
                if (scanner.hasNextFloat()) {
                    float price = scanner.nextFloat();
                    if (price <= 0) {
                        System.out.println("(^_~) Цена не может быть равна 0 или меньше нуля. Пожалуйста, введите корректное значение.");
                    } else {
                        item.price = price;
                        scanner.nextLine(); // Очистить буфер ввода
                        break;
                    }
                } else {
                    System.out.println("(^_~) Недопустимые символы. Пожалуйста, введите число.");
                    scanner.next(); // Очистить буфер ввода
                }
            }

            calculator.itemsList.add(item);
            System.out.println("(◕‿◕) Товар успешно добавлен!");

            // Вывод списка товаров и итоговой стоимости после каждого добавления товара, для проверки
            calculator.showAll();
            calculator.calculateTotalPrice();

            System.out.println("Напишите слово Завершить, чтобы перейти к подсчету. Или введите название нового товара");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("Завершить")) {
                calculator.calculatePerFriendPrice(friends);
                break;
            }
        }
    }
    }