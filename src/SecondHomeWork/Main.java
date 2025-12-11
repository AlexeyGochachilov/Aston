package SecondHomeWork;

import SecondHomeWork.Classes.Book;
import SecondHomeWork.Classes.Student;
import SecondHomeWork.Parsers.ParserFactory;
import SecondHomeWork.Utils.WorkWithFile;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

import static SecondHomeWork.Classes.Constants.*;

public class Main {

    public static void main(String[] args) {

        Path pathIn = Path.of("src/SecondHomeWork/resource/dataFile.txt");
        WorkWithFile<Student> studentParser = new WorkWithFile<>(ParserFactory.getStudentParser());
        WorkWithFile<Book> bookParser = new WorkWithFile<>(ParserFactory.getBookParser());
        List<Student> studentList = studentParser.createListFromFile(pathIn.toString(), " ");
        List<Book> bookList = bookParser.createListFromFile(pathIn.toString(), "; ");

        for (Student student : studentList) {
            student.assignRandomBooks(bookList, MIN_BOOKS_PER_STUDENT, bookList.size());
        }

        studentList.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getQuantityOfPages))
                .distinct()
                .filter(book -> book.getYearOfPublishing() > YEAR_THRESHOLD)
                .limit(STREAM_LIMIT)
                .map(Book::getYearOfPublishing)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("A book with a year of release " + year + " has been found."),
                        () -> System.out.println("The book was not found")
                );
    }
}
