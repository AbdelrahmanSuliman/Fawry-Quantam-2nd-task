package Exceptions;

public final class DuplicateIsbnException extends RuntimeException{
    public DuplicateIsbnException(String isbn) {
        super("ISBN already exists: " + isbn);
    }
}
