package Exceptions;

public final class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("Book not found with ISBN: " + isbn);
    }
}
