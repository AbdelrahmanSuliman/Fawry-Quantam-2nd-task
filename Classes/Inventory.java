package Classes;


import Exceptions.BookNotFoundException;
import Exceptions.DuplicateIsbnException;
import Exceptions.OutOfStockException;
import services.MailingService;
import services.ShippingService;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    MailingService mailingService = new MailingService();
    ShippingService shippingService = new ShippingService();
    //each book is mapped to its isbn
    private final HashMap<String, Book> books = new HashMap<>();

    public void addBook(Book book){
        //isbns must be unique
        if(books.containsKey(book.getIsbn())){
            throw new DuplicateIsbnException(book.getIsbn());
        }
        books.put(book.getIsbn(), book);
        System.out.println("Book added to Inventory");
    }

    public void removeOutdatedBooks(int years){
        int currentYear = Year.now().getValue();
        ArrayList<Book> removedBooks = new ArrayList<>();
        Map<String, Book> copy = new HashMap<>(books);
        for(Map.Entry<String, Book> book : copy.entrySet()){
            if(currentYear - book.getValue().getYear() >= years){
                books.remove(book.getKey());
                removedBooks.add(book.getValue());
            }
        }

        if(removedBooks.isEmpty()){
            System.out.println("No books are older than " + years + " years");
            return;
        }
        System.out.println("Removed books:");
        for(Book book : removedBooks){
            System.out.println(book.getTitle());
        }
    }

    public void buyBook(String ISBN, int quantity, String email, String address){
        Book book = books.get(ISBN);
        switch (book) {
            case null -> throw new BookNotFoundException(ISBN);
            case PaperBook paperBook -> {
                if (quantity > paperBook.getStock()) {
                    throw new OutOfStockException(ISBN, quantity, paperBook.getStock());
                }
                shippingService.handleShipping(paperBook, address);
                int currentStock = paperBook.getStock();
                paperBook.setStock(currentStock - quantity);
            }
            case EBook eBook -> mailingService.handleMailing(eBook, email);
            default -> {
            }
        }
        System.out.println("Paid amount: " + book.getPrice() * quantity);
    }
}
