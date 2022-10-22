import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
// (ВАЖНО) Для вывода необходимо использовать логгер(Java.Util.Logging)

// 1.Реализовать алгоритм сортировки слиянием

// 2.Пусть дан произвольный список целых чисел, удалить из него четные числа

// 3.Задан целочисленный список ArrayList.
// Найти минимальное, максимальное и среднее из этого списка.
public class Task3 {

    public static void main(String[] args) throws IOException {
        int[] sortArr = { 12, 6, 3, 1, 13, 10 };
        int[] result = mergeSort(sortArr);
        // System.out.println(Arrays.toString(result));
        Logger logger = Logger.getAnonymousLogger();
        logger.info(Arrays.toString(result));
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(11);
        numbers.add(42);
        numbers.add(17);
        numbers.add(32);
        numbers.add(55);
        deleteEvenElement(numbers);
        String listString = numbers.toString();
        // System.out.println(listString);
        logger.info(listString);
    }

    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        return mergeSortInner(buffer1, buffer2, 0, sortArr.length);
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
 
    public static List<Integer> deleteEvenElement(List<Integer> sortArr) {
        for (Iterator<Integer> iterator = sortArr.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        
        }
        
        // System.out.println("Sorted List: " + sortArr);
        return sortArr;
    }
}
