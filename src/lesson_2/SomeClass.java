package lesson_2;

import java.io.*;

public class SomeClass {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            String[] strings = {"asdf", "asdf"};
            String string1 = strings[2];
            test();
            int a = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Ошибка в арифметическом выражении");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Выход за границу массива");

        } catch (Exception e) {
            System.out.println("Неопознаная ошибка");
            e.printStackTrace();
        } finally {
            System.out.println("Я все равно выполнися!");
        }
        System.out.println("Я жив!");
    }

    public static void  test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
        test();
    }
}
