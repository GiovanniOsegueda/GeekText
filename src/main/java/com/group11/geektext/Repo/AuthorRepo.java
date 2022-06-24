package com.group11.geektext.Repo;

import com.group11.geektext.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, String> {
}

