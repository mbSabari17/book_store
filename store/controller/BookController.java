package book.store.controller;

import book.store.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    // Get all books
    @GetMapping
    public List<Book> getBooks() {
        return bookList;
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        Optional<Book> book = bookList.stream().filter(b -> b.getId().equals(id)).findFirst();
        return book.orElse(null);  // Return null if book not found
    }

    // Create a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId(bookList.size() + 1); // Simple ID generation strategy
        bookList.add(book);
        return book;
    }

    // Update a book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book updatedBook) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setGenre(updatedBook.getGenre());
                book.setPublishedDate(updatedBook.getPublishedDate());
                return book;
            }
        }
        return null;  // Return null if book not found
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookList.removeIf(book -> book.getId().equals(id));
    }
}
