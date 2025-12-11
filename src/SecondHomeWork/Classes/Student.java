package SecondHomeWork.Classes;

import java.util.*;

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
        if (id >= 0 && id < books.size()) {
            book = books.get(id);
        }
        return book;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addAllBooks(List<Book> books) {
        this.books.addAll(new LinkedList<>(books));
    }

    public void showAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
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

    public void receiveRandomBooks(List<Book> allBooks, int minBooks, int maxBooks) {
        if (allBooks == null || allBooks.size() < minBooks) {
            System.out.println("Недостаточно книг для распределения");
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
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", course=" + course +
                '}';
    }

}
