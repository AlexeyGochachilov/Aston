package SecondHomeWork.Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CityLibrary extends Library {

    public CityLibrary(List<Book> allBooks) {
        super(allBooks);
    }

    @Override
    public void takeBooksFromLibrary(Student student) {
        student.addAllBooks(super.books);
    }

    @Override
    public void takeBookFromLibrary(Student student, int index) {
        student.addBook(super.books.get(index));
    }

    @Override
    public void returnBooksFromLibrary(Student student) {
        student.removeAllBooks();
    }

    @Override
    public void returnBookFromLibrary(Student student, int index) {
        student.removeBook(index);
    }

    @Override
    public void assignRandomBooks(Student student, int minBooks, int maxBooks) {
        if (books.size() < minBooks) {
            System.out.println("Do not have enough books");
            return;
        }
        List<Book> shuffledBooks = new ArrayList<>(books);
        Collections.shuffle(shuffledBooks);
        Random random = new Random();
        int booksCount = random.nextInt(Math.min(maxBooks, shuffledBooks.size()) - minBooks + 1) + minBooks;
        for (int i = 0; i < booksCount; i++) {
            student.addBook(shuffledBooks.get(i));
        }
    }

}
