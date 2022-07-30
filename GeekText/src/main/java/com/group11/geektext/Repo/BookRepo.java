package com.group11.geektext.Repo;

import com.group11.geektext.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, String> {

    /**
     * Get request for books by specified Author
     * @param author
     * @return list of books from that specific Author
     * Author: Michelle Picciuto
     */
    @Query("FROM Book WHERE bookAuthor = ?1")
    List<Book> fetchAllBooksByAuthor(String author);

    @Query("FROM Book WHERE bookGenre = ?1")
    List<Book> fetchAllBooksByGenre(String genre);

    @Query("FROM Book order by bookCopiesSold desc")
    List<Book> fetchTopSoldBooks();

    @Query("FROM Book WHERE bookRating >= ?1")
    List<Book> fetchAllBooksByRating(int rating);
}
