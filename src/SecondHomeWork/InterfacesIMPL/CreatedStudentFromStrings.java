package SecondHomeWork.InterfacesIMPL;

import SecondHomeWork.Classes.Student;
import SecondHomeWork.Interfaces.CreatedClassFromStrings;

public class CreatedStudentFromStrings implements CreatedClassFromStrings<Student> {

    @Override
    public Student createdClassFromString(String[] stringsConstructor) {
        Student student = new Student(stringsConstructor[0], stringsConstructor[1],
                Integer.getInteger(stringsConstructor[2]), Integer.getInteger(stringsConstructor[3]));
        return student;
    }
}
