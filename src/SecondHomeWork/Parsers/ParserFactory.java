package SecondHomeWork.Parsers;

import SecondHomeWork.Classes.Book;
import SecondHomeWork.Classes.Student;
import SecondHomeWork.Interfaces.CreatedClassFromStrings;

public class ParserFactory {

    private static final StudentParser STUDENT_PARSER = new StudentParser();
    private static final BookParser BOOK_PARSER = new BookParser();

    public static CreatedClassFromStrings<Student> getStudentParser() {
        return STUDENT_PARSER;
    }

    public static CreatedClassFromStrings<Book> getBookParser() {
        return BOOK_PARSER;
    }
}
