import java.io.*;
import java.util.ArrayList;
import java.util.List;
class files {
    public static List<Integer> readDataFromFile(String pathToFile) throws IOException {
                List<Integer> list = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(pathToFile);
        int number = inputStream.read();
        while (number != -1) {
            number = inputStream.read();
            list.add(number);
        }
        return list;
    }
}