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
        List<Book> copy = new LinkedList<>();
        if (!books.isEmpty()) {
            copy.addAll(books);
        }
        return copy;

    }

    public Book getBook(int id) {
        Book book = null;
        if (id < books.size()) {
            book = books.get(id);
        }
        return book;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addAllBooks(List<Book> books) {
        this.books.addAll(books);
    }
}
