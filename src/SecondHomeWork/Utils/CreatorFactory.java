package SecondHomeWork.Utils;

import SecondHomeWork.Classes.Book;
import SecondHomeWork.Classes.Student;
import SecondHomeWork.Interfaces.CreatedClassFromStrings;

public class CreatorFactory {

    public static CreatedClassFromStrings<Student> getStudentCreator() {
        return strings -> {
            if (strings.length == 4) {
                return new Student(
                        strings[0],
                        strings[1],
                        extractFirstInteger(strings[2]),
                        extractFirstInteger(strings[3])
                );
            }
            return null;
        };
    }

    public static CreatedClassFromStrings<Book> getBookCreator() {
        return strings -> {
            if (strings.length == 4) {
                return new Book(
                        cleanName(strings[0]),
                        cleanAuthor(strings[1]),
                        extractFirstInteger(strings[2]),
                        extractFirstInteger(strings[3])
                );
            }
            return null;
        };
    }

    private static int extractFirstInteger(String text) {
        String numbersOnly = text.replaceAll("\\D+", " ").trim();
        if (numbersOnly.isEmpty()) return 0;
        return Integer.parseInt(numbersOnly.split(" ")[0]);
    }

    private static String cleanName(String name) {
        return name.replaceAll("\"", "").trim();
    }

    private static String cleanAuthor(String author) {
        return author.replace("Автор:", "").trim();
    }
}
