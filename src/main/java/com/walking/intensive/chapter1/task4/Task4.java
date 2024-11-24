package com.walking.intensive.chapter1.task4;

/**
 * Дано уравнение:
 *
 * <p>ax² + bx + c = 0
 *
 * <p>Реализуйте метод solveEquation(), который параметрами принимает
 * коэффициенты - вещественные числа a, b и c.
 *
 * <p>Метод должен возвращать в виде строки количество решений, а также сами решения в указанном ниже формате:
 * <ul>
 * <li> "Количество решений: 2. Корни: -4;4"
 * <li> "Количество решений: 1. Корень: 0"
 * <li> "Количество решений: 0."
 * <li> "Бесконечное множество решений."
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>P.S. Квадратные уравнения решаются либо через теорему Виета, либо через дискриминант.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        double a = 0;
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));

    }

    static String solveEquation(double a, double b, double c) {
        String result;

        if (a == 0) {
            // Линейное уравнение bx + c = 0
            if (b != 0) {
                double x = -c / b;
                result = "Количество решений: 1. Корень: " + (x != 0 ? x : Math.abs(x));
            } else if (c == 0) {
                result = "Бесконечное множество решений.";
            } else {
                result = "Количество решений: 0.";
            }
        } else {
            // Квадратное уравнение ax^2 + bx + c = 0
            double d = Math.pow(b, 2) - 4 * a * c;

            if (d < 0) {
                result = "Количество решений: 0.";
            } else if (d == 0) {
                double x = -b / (2 * a);
                result = "Количество решений: 1. Корень: " + (x != 0 ? x : Math.abs(x));
            } else {
                double sqrtD = Math.sqrt(d);
                double x1 = (-b + sqrtD) / (2 * a);
                double x2 = (-b - sqrtD) / (2 * a);
                result = "Количество решений: 2. Корни: " + Math.min(x1, x2) + ";" + Math.max(x1, x2);
            }
        }

        return result;
    }
}
