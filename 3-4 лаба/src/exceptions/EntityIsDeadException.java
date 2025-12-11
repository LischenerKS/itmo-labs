package exceptions;

public class EntityIsDeadException extends RuntimeException {
    public EntityIsDeadException(String message) {
        super(message);
    }
}
