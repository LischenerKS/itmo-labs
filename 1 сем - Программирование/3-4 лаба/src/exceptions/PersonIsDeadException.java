package exceptions;

public class PersonIsDeadException extends RuntimeException {
    public PersonIsDeadException(String message) {
        super(message);
    }
}
