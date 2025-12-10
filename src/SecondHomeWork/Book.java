package SecondHomeWork;

public class Book {

    private final String NAME;
    private final String AUTHOR;
    private final int YEAR_OF_PUBLISHING;
    private final int QUANTITU_OF_PAGES;

    public Book(String name, String author, int yearOfPublishing, int quantityOfPages) {
        this.NAME = name;
        this.AUTHOR = author;
        this.YEAR_OF_PUBLISHING = yearOfPublishing;
        this.QUANTITU_OF_PAGES = quantityOfPages;
    }
}
