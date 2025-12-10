package SecondHomeWork.InterfacesIMPL;

import SecondHomeWork.Interfaces.ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFileIMPL implements ReadFile {

    public String readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

        }
        return "";
    }
}
