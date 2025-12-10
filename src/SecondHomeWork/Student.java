package SecondHomeWork;

import java.util.LinkedList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private int course;
    private List<Book> books = new LinkedList<>();

    public Student(String firstName, String lastName, int age, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
    }

    public List<Book> getBooks() {
        if (!books.isEmpty()) {
            List<Book> copy = new LinkedList<>();
            copy.addAll(books);
            return copy;
        } else {
            return null;
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addAllBooks(List<Book> books) {
        this.books.addAll(books);
    }
}
