package SecondHomeWork.Classes;

import java.util.Objects;

public class Book {

    private final String name;
    private final String author;
    private final int yearOfPublishing;
    private final int quantityOfPages;

    public Book(){
        name = "";
        author = "";
        yearOfPublishing = 0;
        quantityOfPages = 0;
    }

    public Book(String name, String author, int yearOfPublishing, int quantityOfPages) {
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.quantityOfPages = quantityOfPages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public int getQuantityOfPages() {
        return quantityOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublishing == book.yearOfPublishing && quantityOfPages == book.quantityOfPages && Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, yearOfPublishing, quantityOfPages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", quantityOfPages=" + quantityOfPages +
                '}';
    }
}
