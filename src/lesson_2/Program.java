package lesson_2;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Program {
    static String fileName = "src/lesson_2/list.txt";
    static String fileName2 = "src/lesson_2/list2.txt";
    static HashMap<String, Integer> hashMap;

    public static void main(String[] args) {

        hashMap = new LinkedHashMap<>();
        readFile();
        saveFile(hashMap);
    }

    static private void readFile() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            while ((line = br.readLine()) != null) {
                String[] temp = line.split("=");
                checkLength(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Фаил не найден!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static private void checkLength(String[] str) {
        try {
            if (str[1].equals("?")) {
                hashMap.put(str[0], str[0].length());
            } else {
                hashMap.put(str[0], Integer.parseInt(str[1]));
            }
        } catch (NumberFormatException e) {
            System.err.printf("Неверный формат значений: %s", str[1]);
        }
    }
    static private void saveFile(HashMap<String, Integer> data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName2)))) {
            for (String key : data.keySet()) {
                bufferedWriter.write(String.format("%s = %s \n", key, data.get(key)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
