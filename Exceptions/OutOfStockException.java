package Exceptions;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String isbn, int requestedAmount, int availableAmount) {
        super("Book with isbn " + isbn + " is out of stock, requested amount: " + requestedAmount + " available amount: " + availableAmount);
    }
}
