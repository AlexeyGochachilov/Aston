package SecondHomeWork.Classes;

import java.util.*;
import java.util.stream.Collectors;

public class Student {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final int course;
    private List<Book> books = new LinkedList<>();

    public Student(String firstName, String lastName, int age, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
    }

    public List<Book> getBooks() {
        List<Book> copy = new LinkedList<>();
        if (!books.isEmpty()) {
            copy.addAll(books);
        }
        return copy;
    }

    public Book getBook(int index) {
        Book book = null;
        if (index >= 0 && index < books.size()) {
            book = books.get(index);
        }
        return book;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addAllBooks(List<Book> books) {
        this.books.addAll(new LinkedList<>(books));
    }

    public void setBooks(List<Book> newBooks) {
        this.books = new LinkedList<>(newBooks);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public void removeAllBooks() {
        books.clear();
    }

    @Override
    public String toString() {
        if (!books.isEmpty()) {
            return toDetailedString();
        } else {
            return toFormattedString();
        }
    }

    private String toFormattedString() {
        return String.format("Student{firstName='%s', lastName='%s', age=%d, course=%d}",
                firstName, lastName, age, course);
    }

    private String toDetailedString() {
        return toFormattedString() + "\nBooks:\n" +
                books.stream()
                        .map(Book::toString)
                        .collect(Collectors.joining("\n"));
    }
}
