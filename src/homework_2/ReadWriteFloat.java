package homework_2;

import java.util.Scanner;

public class ReadWriteFloat {
    static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        writeNumber();
        scanner.close();
    }

    static private void writeNumber () {
        System.out.println("Введите дробное число:");
        try {
            float x = Float.parseFloat(scanner.nextLine());
            if (Float.isInfinite(x)) {
                System.err.println("Вы ввели слшком большое число.");
                writeNumber();
            } else {
                System.out.println("Вы ввели число: " + x);
            }
        } catch (NumberFormatException e) {
            System.err.println("Ваш ввод не корректен! Попробуйте еще раз.");
            writeNumber();
        }
    }
}
