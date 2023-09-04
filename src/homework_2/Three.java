package homework_2;


public class Three {
    // Задание 3

    // думаю стоит убрать из main переброску ошибок выше, ведь мы обрабатываем их тут сами
    // public static void main(String[] args) throws Exception {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        // Throwable имеет уровень выше и по этому будет перекрывать другие исключения,
        // по этому перенес его в низ
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    // нужно вынести за метот main.
    // этот метод не работает с файлами ни как, по этому если
    // будет где-то проиходить записть то исключение дожно быть там
    // public static void printSum(Integer a, Integer b) throws FileNotFoundException {
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
