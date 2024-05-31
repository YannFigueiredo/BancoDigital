package models.exceptions;

public class CpfInvalidException extends RuntimeException {
    public CpfInvalidException(String message) {
        super(message);
    }
}
