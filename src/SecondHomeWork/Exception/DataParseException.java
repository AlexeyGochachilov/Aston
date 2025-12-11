package SecondHomeWork.Exception;

public class DataParseException extends RuntimeException {
    public DataParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataParseException(String message) {
        super(message);
    }
}
