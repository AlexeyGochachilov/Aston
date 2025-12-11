package SecondHomeWork.Utils;

import SecondHomeWork.Interfaces.CreatedClassFromStrings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WorkWithFile<T> {

    private final CreatedClassFromStrings<T> created;

    public WorkWithFile(CreatedClassFromStrings<T> created) {
        this.created = created;
    }

    public List<T> createListFromFile(String filePath, String delimiter) {
        List<T> resultList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(delimiter);
                if (parts.length != 4) {
                    continue;
                }
                try {
                    T t = created.createdClassFromString(parts);
                    if (t != null) {
                        resultList.add(t);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
}
