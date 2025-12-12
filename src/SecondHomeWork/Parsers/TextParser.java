package SecondHomeWork.Parsers;

public class TextParser {

    private TextParser() {}

    public static int extractFirstInteger(String text) {
        String numbersOnly = text.replaceAll("\\D+", " ").trim();
        if (numbersOnly.isEmpty()) {
            throw new IllegalArgumentException("No numbers found in text: " + text);
        }
        return Integer.parseInt(numbersOnly.split(" ")[0]);
    }

    public static String cleanName(String name) {
        return name.replaceAll("\"", "").trim();
    }

    public static String cleanAuthor(String author) {
        return author.replace("Автор:", "").trim();
    }
}
