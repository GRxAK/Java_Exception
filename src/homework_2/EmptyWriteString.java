package homework_2;

import java.util.Scanner;

public class EmptyWriteString {
    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = scanner.nextLine();
        try {
            checkForEmptyString(str);
            System.out.println("Все гуд)");
        } catch (IllegalArgumentException e) {
            System.err.println("Вы ввели путую сторку!");
        }
        System.out.println("Завершение программы.");
        scanner.close();
    }

    public static void checkForEmptyString(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Введена пустая строка");
        }
    }
}
