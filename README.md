# Fawry-Quantam-2nd-task

## Overview
This Java project implements a simple Book Inventory Management System, supporting both physical (paper) and electronic (eBook) books. It allows adding, buying, and removing books from inventory, with custom exception handling and basic service stubs for shipping and mailing. The project is structured for clarity and extensibility, suitable for internship or educational purposes.

## Features
- Add books (with unique ISBN enforcement)
- Buy books (with stock management for paper books and email delivery for eBooks)
- Remove outdated books based on publication year
- Custom exceptions for error handling (duplicate ISBN, out-of-stock, book not found)

## Project Structure
```
Classes/
  Book.java           # Base class for all books
  PaperBook.java      # Represents a physical book with stock
  EBook.java          # Represents an electronic book with file type
  Inventory.java      # Manages the collection of books and operations
  DemoBook.java       # Example subclass for demonstration
Enums/
  FileType.java       # Enum for eBook file types (JPEG, PNG, PDF)
Exceptions/
  BookNotFoundException.java   # Thrown when a book is not found
  DuplicateIsbnException.java  # Thrown when adding a book with an existing ISBN
  OutOfStockException.java     # Thrown when requested quantity exceeds stock
services/
  MailingService.java  # Stub for handling eBook delivery
  ShippingService.java # Stub for handling paper book shipping
Main.java              # Entry point with test scenarios
```
## Output: 
```java
Testing addBook
Book added to Inventory
Testing buyBook
Book added to Inventory
Exceptions.DuplicateIsbnException: ISBN already exists: 123-321
	at Classes.Inventory.addBook(Inventory.java:24)
	at Main.testAddBook(Main.java:17)
	at Main.main(Main.java:74)
Paid amount: 59.849999999999994
Testing removeBook
Book added to Inventory
Book added to Inventory
Book added to Inventory
No books are older than 30 years
Removed books:
Example title
Example title
Example title
Exceptions.OutOfStockException: Book with isbn 123-321 is out of stock, requested amount: 1 available amount: 0
	at Classes.Inventory.buyBook(Inventory.java:60)
	at Main.testBuyBook(Main.java:35)
	at Main.main(Main.java:76)
Exceptions.BookNotFoundException: Book not found with ISBN: 999-999
	at Classes.Inventory.buyBook(Inventory.java:57)
	at Main.testBuyBook(Main.java:42)
	at Main.main(Main.java:76)
```
## Screenhots:
![image](https://github.com/user-attachments/assets/28043b56-f151-4d07-afcb-4f850e99ad9b)
![image](https://github.com/user-attachments/assets/29cc2ec6-ae31-4e84-884c-a8fc9285d673)


## How to Run
1. **Compile the project:**
   Ensure you are in the project root directory and run:
   ```sh
   javac Classes/*.java Enums/*.java Exceptions/*.java services/*.java Main.java
   ```
2. **Run the main class:**
   ```sh
   java Main
   ```
   This will execute test scenarios for adding, buying, and removing books, demonstrating exception handling and service calls.

## Exception Handling
- **DuplicateIsbnException:** Thrown when attempting to add a book with an ISBN that already exists in the inventory.
- **BookNotFoundException:** Thrown when trying to buy a book that does not exist in the inventory.
- **OutOfStockException:** Thrown when the requested quantity of a paper book exceeds available stock.
