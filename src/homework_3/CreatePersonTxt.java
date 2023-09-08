package homework_3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CreatePersonTxt {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите данные в строку разделяя пробелом:");
        System.out.println("Фамилия Имя Отчество дата_рождения номер_телефона(дд.мм.гггг) пол(f или m)");
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        // обрабатываем код ошибки на количество данных
        if (lengthData(data) == -1) {
            System.err.println("Ошибка! Введено меньше данных чем требуется.");
        } else if (lengthData(data) == -2) {
            System.err.println("Ошибка! Введено больше данных чем требуется.");
        } else {
            runApp(data);
        }
    }

    static void runApp(String[] data) {
            String surname;
            String firstName;
            String patronymic;
            String birthdate;
            int phoneNumber;
            char gender = '0';
            try {
                validateName(data[0], "Фамилия");
                surname = data[0];

                validateName(data[1], "Имя");
                firstName = data[1];

                validateName(data[2], "Отчество");
                patronymic = data[2];

                processDate(data[3]);
                birthdate = data[3];

                phoneNumber = Integer.parseInt(data[4]);

                validateGender(data[5].toCharArray()[0]);
                gender = data[5].toCharArray()[0];

                try (FileWriter fileWriter = new FileWriter("src/homework_3/" + surname + ".txt", true)){
                    fileWriter.write("%s %s %s %s %d %s\n".formatted(surname, firstName, patronymic, birthdate, phoneNumber, gender));
                    fileWriter.close();
                    System.out.println("Данные успешно записаны в файл.");
                } catch (IOException e) {
                    System.err.println("Ошибка при записи данных в файл:");
                    e.printStackTrace();
                }

            } catch (NumberFormatException e) {
                System.err.println("Ошибка! Вы ввели некорректный номер телефон! Только цифры.");
            } catch (ParseException e) {
                System.err.println("Ошибка! Строка не соответствует формату даты (dd.mm.yyyy).");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }


    }

    static int lengthData(String[] data) {
        if (data.length < 6) {
            return -1;
        } else if (data.length > 6) {
            return -2;
        }
        return 1;
    }

    static void validateName(String name, String type) throws Exception {
        if (!name.matches("[A-ZА-Я][a-zA-ZА-Яа-я]*")) {
            throw new Exception("Ошибка!" + type + " неверного формата. Только буквы и первая заглавная.");
        }
    }

    static void validateGender(char gender) throws Exception {
        if (gender != 'f' && gender != 'm' && gender != 'F' && gender != 'M') {
            throw new Exception("Ошибка! Недопустимый символ пола. Допустимые значения: 'f' или 'm'.");
        }
    }

    public static void processDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false); // Запретить нестрогий парсинг
        dateFormat.parse(dateString); // Пытаемся распарсить строку как дату
    }
}
