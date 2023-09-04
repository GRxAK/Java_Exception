package lesson_1;

public class Answer {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] arr = {1, 2};
        System.out.println(arr[5]);
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int a = 10 / 0;
        System.out.println(a);
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        String str = "abc";
        int num = Integer.parseInt(str);
        System.out.println(num);
    }
}
