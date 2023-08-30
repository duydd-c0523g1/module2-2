package extra.custom_mvc.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Stream {
    public static void write(String filePath, List<String> stringList) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filePath)))) {
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<String> read(String filePath) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {
            List<String> stringList = new ArrayList<>();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            return stringList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
