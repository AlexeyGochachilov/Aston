package SecondHomeWork.Parsers;

import SecondHomeWork.Classes.Book;
import SecondHomeWork.Interfaces.CreatedClassFromStrings;

import static SecondHomeWork.Classes.Constants.EXPECTED_PARTS_COUNT;
import static SecondHomeWork.Parsers.TextParser.*;

public class BookParser implements CreatedClassFromStrings<Book> {

    @Override
    public Book createdClassFromString(String[] strings) {
        if (strings.length == EXPECTED_PARTS_COUNT) {
            return new Book(
                    cleanName(strings[0]),
                    cleanAuthor(strings[1]),
                    extractFirstInteger(strings[2]),
                    extractFirstInteger(strings[3])
            );
        }
        return null;
    }
}
