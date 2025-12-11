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

        Path pathin = Path.of("src/SecondHomeWork/resource/dataFile.txt");
        WorkWithFile<Student> studentParser = new WorkWithFile<>(CreatorFactory.getStudentCreator());
        WorkWithFile<Book> bookParser = new WorkWithFile<>(CreatorFactory.getBookCreator());
        List<Student> studentList = studentParser.creatingListFromFile(pathin.toString(), " ");
        List<Book> bookList = bookParser.creatingListFromFile(pathin.toString(), "; ");
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
                .findAny()
                .ifPresentOrElse(
                        year -> System.out.println("Найден год: " + year),
                        () -> System.out.println("Книга не найдена")
                );
    }
}
