//1.Вычислить n-ое треугольного число(сумма чисел от 1 до n),     T(n) = n * (n + 1) / 2;
// n!(произведение чисел от 1 до n)                               n! = 1 * 2 * ... n;
//2.Вывести все простые числа от 1 до 1000                        n != 1 && n == n / n && n == n / 1;
//3.Реализовать простой калькулятор
//4.*+Задано уравнение вида q + w = e, q, w, e >= 0.
//Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
//Требуется восстановить выражение до верного равенства.
//Предложить хотя бы одно решение или сообщить, что его нет.

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(getTriangularNumber(10));
        System.out.println(getFactorial(5));
        primeNumber();
        calculator();
    }

    public static int getTriangularNumber(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n + getTriangularNumber(n - 1);
        }
    }

    public static int getFactorial(int f) {
        if (f == 1) {
            return 1;
        } else {
            return f * getFactorial(f - 1);
        }
    }

    public static void primeNumber() {
        int n = 1000;
        System.out.print("2 3 5 7 11 13 17 19 23 29 31 ");
        for (int i = 2; i <= n; i++) {
            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0
                    && i % 7 != 0 && i % 11 != 0 && i % 13 != 0
                    && i % 17 != 0 && i % 19 != 0 && i % 23 != 0
                    && i % 29 != 0 && i % 31 != 0)
                System.out.print(i + " ");
        }
        System.out.println();

    }

    public static void calculator() {
        System.out.println("Введите операцию: ");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        try (Scanner scanner = new Scanner(System.in)) {
            int operation = scanner.nextInt();
            System.out.println("Введите первое число");
            int a = scanner.nextInt();
            System.out.println("Введите второе число");
            int b = scanner.nextInt();
            int result;
            if (operation == 1) {
                result = a + b;
            } else if (operation == 2) {
                result = a - b;
            } else if (operation == 3) {
                result = a * b;
            } else {
                result = a / b;
            }
            System.out.println("Результат = " + result);
        }
    }

}
