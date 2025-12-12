package SecondHomeWork.Utils;

import SecondHomeWork.Exception.DataParseException;
import SecondHomeWork.Interfaces.CreatedClassFromStrings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static SecondHomeWork.Classes.Constants.EXPECTED_PARTS_COUNT;

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
                if (parts.length != EXPECTED_PARTS_COUNT) {
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
            throw new DataParseException("Failed to read file: " + filePath, e);
        }
        return resultList;
    }
}
