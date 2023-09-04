package homework_2;

public class Two {
    public static void main(String[] args) {

        // Задание 2
        // В коде несуществует перменной intArray, создаю ее (либо она дожна приходить из вне этого участа кода),
        // что бы проверить выпадет ли исклчение добвляю занчение по нужному индексу
        // создаю метод в котором будет создоватся исклчения деления на ноль и потом его вызываю в try
        try {
            int d = 0;
            int[] intArray = new int[9];
            intArray[8] = 10;
            double catchedRes1 = divide(intArray[8], d);
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    public static double divide(int x, int d) {
        if (d == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо.");
        }
        return (double) x / d;
    }
}
