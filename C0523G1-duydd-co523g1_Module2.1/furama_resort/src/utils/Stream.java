package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Stream {
    public static void write(String filePath, List<String> strings) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String string : strings) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> read(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            List<String> strings = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            return strings;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
