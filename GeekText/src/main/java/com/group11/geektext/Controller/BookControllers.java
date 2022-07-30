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
     * Author: Michelle Picciuto
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
     * Author: Michelle Picciuto
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

    @GetMapping("/topSellers")
    public List<Book> findTopSellers() {
        List<Book> dbList = bookRepo.fetchTopSoldBooks();
        if(dbList.size()<=10)
            return dbList;

        return dbList.subList(0,9);
    }

    /**
     * This is a method in which it'll verify if the book has been saved correctly or if it is pre-existing.
     * @param book
     * @return Response for Success or Failure
     * Author: Michelle Picciuto
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

} // Ending BookController class
