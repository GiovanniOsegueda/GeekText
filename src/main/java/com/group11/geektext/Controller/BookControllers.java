package com.group11.geektext.Controller;

import com.group11.geektext.Models.Book;
import com.group11.geektext.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/books")
public class BookControllers {

    @Autowired
    private BookRepo bookRepo;

    /**
     * this method is for retrieving book detail by ISBN
     * @param bookISBN Book ISBN
     * @return returns the Book Object
     */
    @GetMapping(value = "/{isbn}")
    public Book getBookByBookISBN(@PathVariable(name = "isbn")String bookISBN) {
        Optional<Book> bookOptional =  bookRepo.findById(bookISBN);
        if(bookOptional.isPresent()) {
            return bookOptional.get();
        } else {
            return null;
        }
    }

    /**
     * This method is for returning all the Books and books based on some conditions
     * @param author
     * @param genre
     * @param rating
     * @param x
     * @return List of the Book
     */
    @GetMapping
    public List<Book> getAllBooks(@RequestParam(name = "author", required = false) String author, @RequestParam(name = "genre", required = false) String genre,
                                  @RequestParam(name = "rating", required = false)Integer rating, @RequestParam(name = "x", required = false) Integer x) {
        if(author!=null) {
            return bookRepo.fetchAllBooksByAuthor(author);
        }
        if(genre!=null) {
            return bookRepo.fetchAllBooksByGenre(genre);
        }
        if(rating!=null) {
            return bookRepo.fetchAllBooksByRating(rating);
        }
        if(x!=null) {
            List<Book> subList = bookRepo.findAll().subList(0,x);
            return subList;
        }
        return bookRepo.findAll();
    }

    /**
     * This will return the top seller starting from the highest number bookCopiesSold
     * @return List of books
     */
    @GetMapping("/topSellers")
    public List<Book> findTopSellers() {
        List<Book> dbList = bookRepo.fetchTopSoldBooks();
        if(dbList.size()<=10)
            return dbList;

        return dbList.subList(0,9);
    }

    /**
     * Method is used to create book.
     * @param book
     * @return message save successfully
     */
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        Optional<Book> bookOptional = bookRepo.findById(book.getBookISBN());
        if(!bookOptional.isPresent()) {
            bookRepo.save(book);
            return new ResponseEntity<>("Book details saved Successfully...!!!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book ISBN is already present.", HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * This method will delete book by typing the book ISBN in postman
     * @param bookISBN
     * @return message once book is deleted
     */
    @DeleteMapping(value = "/{bookISBN}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "bookISBN")String bookISBN) {
        Optional<Book> bookOptional = bookRepo.findById(bookISBN);
        if(bookOptional.isPresent()) {
            bookRepo.delete(bookOptional.get());
            return new ResponseEntity<>("Book deleted Successfully.!!!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book ISBN not found.", HttpStatus.BAD_REQUEST);
        }
    }

} // Ending BookController class
