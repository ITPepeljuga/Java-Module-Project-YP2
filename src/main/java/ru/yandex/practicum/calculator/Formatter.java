package ru.yandex.practicum.calculator;

public class Formatter {
    public static String formatRubles(float price) {
        String rubleForm;
        int remainder = (int) price % 100;
        if (remainder >= 11 && remainder <= 14) {
            rubleForm = "рублей";
        } else {
            switch ((int) price % 10) {
                case 1:
                    rubleForm = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rubleForm = "рубля";
                    break;
                default:
                    rubleForm = "рублей";
            }
        }
        return rubleForm;
    }
}
