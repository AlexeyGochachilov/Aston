package SecondHomeWork.Classes;

import java.util.*;
import java.util.stream.Collectors;

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

    public void assignRandomBooks(List<Book> allBooks, int minBooks, int maxBooks) {
        if (allBooks == null || allBooks.size() < minBooks) {
            System.out.println("Do not have enough books");
            return;
        }
        this.removeAllBooks();
        List<Book> shuffledBooks = new ArrayList<>(allBooks);
        Collections.shuffle(shuffledBooks);
        Random random = new Random();
        int booksCount = random.nextInt(Math.min(maxBooks, shuffledBooks.size()) - minBooks + 1) + minBooks;
        for (int i = 0; i < booksCount; i++) {
            this.addBook(shuffledBooks.get(i));
        }
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
