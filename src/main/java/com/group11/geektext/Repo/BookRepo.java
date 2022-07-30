package com.group11.geektext.Repo;

import com.group11.geektext.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * List of information will pass through SQL
 */

public interface BookRepo extends JpaRepository<Book, String> {
    @Query("FROM Book WHERE bookAuthor = ?1")
    List<Book> fetchAllBooksByAuthor(String author);

    @Query("FROM Book WHERE bookGenre = ?1")
    List<Book> fetchAllBooksByGenre(String genre);

    @Query("FROM Book order by bookCopiesSold desc")
    List<Book> fetchTopSoldBooks();

    @Query("FROM Book WHERE bookRating >= ?1")
    List<Book> fetchAllBooksByRating(int rating);
}
