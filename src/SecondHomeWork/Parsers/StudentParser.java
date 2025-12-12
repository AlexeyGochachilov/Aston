package SecondHomeWork.Parsers;

import SecondHomeWork.Classes.Student;
import SecondHomeWork.Interfaces.CreatedClassFromStrings;

import static SecondHomeWork.Classes.Constants.EXPECTED_PARTS_COUNT;
import static SecondHomeWork.Parsers.TextParser.*;

public class StudentParser implements CreatedClassFromStrings<Student> {

    @Override
    public Student createdClassFromString(String[] strings) {
        if (strings.length == EXPECTED_PARTS_COUNT) {
            return new Student(
                    strings[0],
                    strings[1],
                    extractFirstInteger(strings[2]),
                    extractFirstInteger(strings[3])
            );
        }
        return null;
    }
}
