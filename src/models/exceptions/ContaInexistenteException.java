package models.exceptions;

public class ContaInexistenteException extends RuntimeException {
    public ContaInexistenteException(String message) {
        super(message);
    }
}
