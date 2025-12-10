package SecondHomeWork.InterfacesIMPL;

import SecondHomeWork.Interfaces.CreatedStrings;

public class CreatedStringsIMPL implements CreatedStrings {

    public String[] CreatedStringsFromFile(String line, String delimiter) {
        return line.trim().split(delimiter);
    }
}
