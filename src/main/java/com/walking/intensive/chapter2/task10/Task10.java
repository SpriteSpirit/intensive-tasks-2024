package com.walking.intensive.chapter2.task10;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
        System.out.println(isPalindrome("Удавы рвали лавры в аду"));
        System.out.println(isPalindrome("Мадам"));
        System.out.println(isPalindrome("No lemon, no melon"));
    }


    static boolean isPalindrome(String inputString) {
        String cleanedInputString = inputString.replaceAll("(?U)[\\pP\\s]", "").toLowerCase();
        String reverseInputString = new StringBuilder(cleanedInputString).reverse().toString();

        return reverseInputString.equals(cleanedInputString);
    }
}
