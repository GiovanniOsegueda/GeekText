package com.group11.geektext.Repo;

import com.group11.geektext.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, String> {

    @Query("from Author where authorFirstName = ?1 and authorLastName = ?2 and authorPublisher = ?3")
    List<Author> findAuthorByAllDetails(String firstName, String lastName, String publisher);

}

