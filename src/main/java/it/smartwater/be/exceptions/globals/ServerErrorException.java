package it.smartwater.be.exceptions.globals;

public class ServerErrorException extends RuntimeException {

    public ServerErrorException() {
        super("Server error");
    }

    public ServerErrorException(String message) {
        super(message);
    }
}
