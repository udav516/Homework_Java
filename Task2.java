import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

// Задание 1 - Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// (Не sql запрос, я оговорился на вебинаре!)
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// Задание 2 - Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

// Задание 3 - Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg

// Задание 4 - К калькулятору из предыдущего дз добавить логирование.

public class Task2 {

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Russia");
        map.put("city", "Moscow");
        map.put("age", null);
        System.out.println(getQuery(map));

        int[] sortArr = { 11, 5, 3, 1, 15, 10, 17 };
        bubbleSort(sortArr);
        File extension = new File("C:/Users/Eldar/Desktop/Homework___Java");
        getExtension(extension);
        calculator();
    }

    public static String getQuery(Map<String, String> parameters) {
        StringBuilder result = new StringBuilder();
        if (parameters == null || parameters.isEmpty()) {
            return result.toString();
        }

        for (Map.Entry<String, String> pair : parameters.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null) {
                continue;
            }

            result.append(pair.getKey()).append(":'").append(pair.getValue()).append("', ");
        }

        if (result.length() > 5) {
            result.delete(result.length() - 2, result.length());
        }

        return result.toString();
    }

    public static void bubbleSort(int[] sortArr) throws IOException {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
        StringBuilder sort = new StringBuilder();
        for (int j : sortArr) {
            sort.append(" ").append(j);
        }
        try (FileWriter writer = new FileWriter("log.txt", false)) {
            writer.write(sort.toString());
            writer.flush();
        }
    }

    public static void getExtension(File extension) {
        String[] array = extension.list();
        String arrayString;
        assert array != null;
        for (String s : array) {
            arrayString = s.substring(s.lastIndexOf('.'));
            System.out.println(" Расширение файла: " + String.join(" ", arrayString));
        }
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
            // System.out.println("Результат = " + result);
            String log = Integer.toString(result);
            Logger logger = Logger.getAnonymousLogger();
            logger.info("Результат = " + log);
        }
    }
}
