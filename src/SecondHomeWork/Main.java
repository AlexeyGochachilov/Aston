package SecondHomeWork;

import SecondHomeWork.Classes.Book;
import SecondHomeWork.Classes.Student;
import SecondHomeWork.Utils.CreatorFactory;
import SecondHomeWork.Utils.WorkWithFile;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path pathIn = Path.of("src/SecondHomeWork/resource/dataFile.txt");
        WorkWithFile<Student> studentParser = new WorkWithFile<>(CreatorFactory.getStudentCreator());
        WorkWithFile<Book> bookParser = new WorkWithFile<>(CreatorFactory.getBookCreator());
        List<Student> studentList = studentParser.creatingListFromFile(pathIn.toString(), " ");
        List<Book> bookList = bookParser.creatingListFromFile(pathIn.toString(), "; ");

        for (Student student : studentList) {
            student.receiveRandomBooks(bookList, 5, bookList.size());
        }

        studentList.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getQuantityOfPages))
                .distinct()
                .filter(book -> book.getYearOfPublishing() > 2000)
                .limit(3)
                .map(Book::getYearOfPublishing)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("A book with a year of release " + year + " has been found."),
                        () -> System.out.println("The book was not found")
                );
    }
}
