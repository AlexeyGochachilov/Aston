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

    public String getNAME() {
        return NAME;
    }

    public String getAUTHOR() {
        return AUTHOR;
    }

    public int getYEAR_OF_PUBLISHING() {
        return YEAR_OF_PUBLISHING;
    }

    public int getQUANTITU_OF_PAGES() {
        return QUANTITU_OF_PAGES;
    }

}
