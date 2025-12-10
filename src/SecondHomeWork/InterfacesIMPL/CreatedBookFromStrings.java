package SecondHomeWork.InterfacesIMPL;

import SecondHomeWork.Classes.Book;
import SecondHomeWork.Interfaces.CreatedClassFromStrings;

public class CreatedBookFromStrings implements CreatedClassFromStrings<Book> {

    @Override
    public Book createdClassFromString(String[] stringsConstructor) {
        Book book = new Book();
        if (stringsConstructor.length == 4 && stringsConstructor[0].charAt(0) == '"') {
            book = new Book(stringsConstructor[0], stringsConstructor[1],
                    Integer.getInteger(stringsConstructor[2]), Integer.getInteger(stringsConstructor[3]));
            return book;
        }
        return book;
    }
}
