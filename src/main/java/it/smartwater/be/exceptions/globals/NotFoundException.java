package it.smartwater.be.exceptions.globals;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Not found");
    }

    public NotFoundException(Long id) {
        super("Not found for id " + id);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
