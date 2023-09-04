package lesson_1;

import java.util.ArrayList;
import java.util.List;

public class Seminar {
    public static void main(String[] args) {
        // #0
        List<Integer> arr1 = new ArrayList<>(10);
        arr1.add(1);arr1.add(1);
        arr1.add(1);arr1.add(1);arr1.add(99);arr1.add(1);arr1.add(1);arr1.add(1);arr1.add(1);arr1.add(1);
        System.out.println(arr1);

        System.out.println("Проверка на минимальную длинну");
        System.out.println(runArray(arr1, 3));

        System.out.println("Поиск числа");
        System.out.println(findArray(arr1, 3, 99));
    }

    // #0
    public static int runArray(List<Integer> arr, int min) {
        if (arr.size() < min) {
            return -1;
        }
        return arr.size();
    }

    // #2
    public static int findArray(List<Integer> arr, int min, int find) {
        runArray(arr, min);
        for (int i=0; i < arr.size(); i++) {
            if (arr.get(i) == find) {
                return i;
            }
        }
        return -2;
    }
}
