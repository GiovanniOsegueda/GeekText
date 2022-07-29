package com.group11.geektext.Repo;

import com.group11.geektext.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, String> {
    @Query("SELECT b FROM Book b WHERE b.bookAuthor = ?1")
    List<Book> fetchAllBooksByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE b.bookGenre = ?1")
    List<Book> fetchAllBooksByGenre(String genre);

    @Query("SELECT b FROM Book b order by b.bookCopiesSold desc")
    List<Book> fetchTopSoldBooks();

    @Query("SELECT b FROM Book b WHERE b.bookRating >= ?1")
    List<Book> fetchAllBooksByRating(int rating);
}
