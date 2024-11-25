package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAngles(3, 4, 5)));
    }

    static boolean isValidTriangle(double a, double b, double c) {
        // Проверка на корректность входных данных (+ проверка на существование треугольника)
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
    }


    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        // Полупериметр треугольника
        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }

        // Площадь треугольника
        double s = getAreaByHeron(a, b, c);

        // Вычисление высоты
        double ha = 2 * s / a;
        double hb = 2 * s / b;
        double hc = 2 * s / c;

        // Массив высот
        double[] heights = new double[]{ha, hb, hc};
        Arrays.sort(heights);

        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }

        // Вычисление медианы
        double ma = Math.sqrt(2 * (Math.pow(b, 2) + Math.pow(c, 2)) - Math.pow(a, 2)) / 2;
        double mb = Math.sqrt(2 * (Math.pow(a, 2) + Math.pow(c, 2)) - Math.pow(b, 2)) / 2;
        double mc = Math.sqrt(2 * (Math.pow(a, 2) + Math.pow(b, 2)) - Math.pow(c, 2)) / 2;

        // Массив медиан
        double[] medians = new double[]{ma, mb, mc};
        Arrays.sort(medians);

        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }

        // Полупериметр треугольника
        double p = (a + b + c) / 2;

        // Формулы для вычисления биссектрис
        double la = (2 * Math.sqrt(b * c * p * (p - a))) / (b + c);
        double lb = (2 * Math.sqrt(a * c * p * (p - b))) / (a + c);
        double lc = (2 * Math.sqrt(a * b * p * (p - c))) / (a + b);

        // Массив биссектрис
        double[] bisectors = new double[]{la, lb, lc};
        Arrays.sort(bisectors);

        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return new double[0];
        }

        // Вычисление углов
        double angleA = Math.toDegrees(Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c)));
        double angleB = Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c)));
        double angleC = Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));

        // Массив с углами треугольника
        double[] angles = new double[]{angleA, angleB, angleC};
        Arrays.sort(angles);

        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        // Площадь треугольника
        double s = getAreaByHeron(a, b, c);

        return (2 * s) / (a + b + c);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        // Площадь треугольника с использованием метода Герона
        double s = getAreaByHeron(a, b, c);

        return (a * b * c) / (4 * s);
    }
    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return -1;
        }

        // Косинус угла напротив стороны a с использованием теоремы косинусов
        double cosAlpha = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);

        // Синус угла с использованием тригонометрического тождества
        double sinAlpha = Math.sqrt(1 - Math.pow(cosAlpha, 2));

        return 0.5 * b * c * sinAlpha;
    }
}
