package ru.yandex.practicum.calculator;

import java.util.ArrayList;

public class Calculator {
    // Список товаров
    ArrayList<Item> itemsList = new ArrayList<>();

    // Экземпляр класса Formatter
    Formatter formatter = new Formatter();

    // Метод для вывода всех товаров
    public void showAll() {
        System.out.println("Добавленные товары:");
        for (int i = 0; i < itemsList.size(); i++) {
            Item currentItem = itemsList.get(i);
            String rubleForm = formatter.formatRubles(currentItem.price); // Получаем форму слова "рубль"
            System.out.println("Название: " + currentItem.name + ", Цена: " + String.format("%.2f", currentItem.price) + " " + rubleForm);
    }

    }
    // Метод для подсчета итоговой стоимости товаров
    public float calculateTotalPrice() {
        float totalPrice = 0;
        for (Item item : itemsList) {
            totalPrice += item.price;
        }
        String rubleForm = formatter.formatRubles(totalPrice); // Получаем форму слова "рубль"
        System.out.println("ИТОГО: " + String.format("%.2f", totalPrice) + " " + rubleForm);
        return totalPrice;
    }


    // Метод для подсчета сколько надо заплатить каждому другу
    public float calculatePerFriendPrice(int friends) {
        float totalPrice = calculateTotalPrice();
        float perFriendPrice = totalPrice / friends;
        String rubleForm = formatter.formatRubles(perFriendPrice); // Получаем форму слова "рубль"
        System.out.println("С носа: " + String.format("%.2f", perFriendPrice) + " " + rubleForm);
        return perFriendPrice;
    }
}
