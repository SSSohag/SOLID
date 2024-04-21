/*The Single Responsibility Principle (SRP) states that a class
should have only one reason to change, meaning that
it should have only one job or responsibility
*/


import java.util.ArrayList;
import java.util.List;

// The Book class represents a book with basic properties
class Book {
    private String title;
    private String author;
    private int pageCount;

    // Constructor
    public Book(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}

// The BookPrinter class is responsible for printing the details of a book
class BookPrinter {
    // Method to print the details of a book
    public void printBookDetails(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Page Count: " + book.getPageCount());
    }
}

// The BookManager class is responsible for managing a collection of books
class BookManager {
    private List<Book> books = new ArrayList<>();

    // Method to add a book to the collection
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the collection
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to get all the books in the collection
    public List<Book> getAllBooks() {
        return books;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a book
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180);

        // Printing book details
        BookPrinter printer = new BookPrinter();
        printer.printBookDetails(book);

        // Managing books
        BookManager manager = new BookManager();
        manager.addBook(book);
        manager.removeBook(book);
    }
}
