package com.group11.geektext.Repo;

import com.group11.geektext.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, String> {

    List<Author> findAuthorByAuthorFullName (String authorFullName);

}

