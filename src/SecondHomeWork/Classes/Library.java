package SecondHomeWork.Classes;

import java.util.LinkedList;
import java.util.List;

public abstract class Library {

    protected final List<Book> books;

    public Library(List<Book> books) {
        this.books = new LinkedList<Book>(books);
    }

    public abstract void takeBooksFromLibrary(Student student);

    public abstract void takeBookFromLibrary(Student student, int index);

    public abstract void returnBooksFromLibrary(Student student);

    public abstract void returnBookFromLibrary(Student student,  int index);

    public abstract void assignRandomBooks(Student student, int minBooks, int maxBooks);
}
