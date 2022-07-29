package com.group11.geektext.Controller;

import com.group11.geektext.Models.Book;
import com.group11.geektext.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/books")
public class BookControllers {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping(value = "/{isbn}")
    public Book getBookByBookISBN(@PathVariable(name = "isbn")String bookISBN) {
        Optional<Book> bookOptional =  bookRepo.findById(bookISBN);
        if(bookOptional.isPresent()) {
            return bookOptional.get();
        } else {
            return null;
        }
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(name = "author", required = false) String author, @RequestParam(name = "genre", required = false)String genre,
                                  @RequestParam(name = "rating", required = false)Integer rating, @RequestParam(name = "x") Integer x) {
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
            bookRepo.findAll().subList(0,x);
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

    @PostMapping
    public String createBook(@RequestBody Book book) {
        bookRepo.save(book);
        return "Book details saved Successfully...!!!";
    }

} // Ending BookController class
