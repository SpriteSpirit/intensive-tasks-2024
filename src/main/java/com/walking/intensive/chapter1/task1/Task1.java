package com.walking.intensive.chapter1.task1;

/**
 * Реализуйте метод getAgeString(), который будет принимать параметром целое число (возраст) и возвращать строку
 * вида: "Вам N лет". Программа должна учитывать правила русского языка.
 *
 * <p>Пример верного исполнения кода: "Вам 5 лет", "Вам 4 года".
 * Пример неверной работы программы: "Вам 14 года".
 *
 * <p>Также необходимо учесть негативные сценарии. Например, попытку передать в метод невалидное значение - например,
 * отрицательное число. В таких случаях ожидается, что метод вернет строку "Некорректный ввод".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task1 {
    public static void main(String[] args) {
        int age = 121;

        for (int i = 1; i <= age; i++) {
            System.out.println(getAgeString(i));
        }

    }

    static String getAgeString(int age) {
        int lastDigit = age % 10;
        int lastTwoDigits = age % 100;

        if (age < 0) {
            return "Некорректный ввод";
        }

        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return "Вам " + age + " лет";
        }

        return switch (lastDigit) {
            case 1 -> "Вам " + age + " год";
            case 2, 3, 4 -> "Вам " + age + " года";
            default -> "Вам " + age + " лет";
        };

    }
}
