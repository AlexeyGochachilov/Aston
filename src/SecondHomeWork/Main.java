package SecondHomeWork;

import SecondHomeWork.Classes.Book;
import SecondHomeWork.Classes.Student;
import SecondHomeWork.Utils.CreatorFactory;
import SecondHomeWork.Utils.WorkWithFile;

import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path pathin = Path.of("src/SecondHomeWork/resourse/dataFile.txt");
        WorkWithFile<Student> studentParser = new WorkWithFile<>(CreatorFactory.getStudentCreator());
        WorkWithFile<Book> bookParser = new WorkWithFile<>(CreatorFactory.getBookCreator());
        List<Student> studentList = studentParser.creatingListFromFile(pathin.toString(), " ");
        List<Book> bookList = bookParser.creatingListFromFile(pathin.toString(), "; ");
        System.out.println(studentList);
        System.out.println(bookList);
    }
}
