package SecondHomeWork.InterfacesIMPL;

import SecondHomeWork.Interfaces.CreatedStringsFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreatedStringsFromFileIMPL implements CreatedStringsFromFile {

    public String[] createdStringsFromFile(String filePath, String delimiter) {
        String[] constr = new String[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                constr = reader.readLine().trim().split(delimiter);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return constr;
    }
}
