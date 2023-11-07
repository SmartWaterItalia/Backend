package it.smartwater.be.exceptions.globals;

public class NoContentException extends RuntimeException {

    public NoContentException() {
        super("No content");
    }

    public NoContentException(Long id) {
        super("No content for id " + id);
    }

    public NoContentException(String message) {
        super(message);
    }
}
