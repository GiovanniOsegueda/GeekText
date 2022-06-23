package com.group11.geektext.Repo;

import com.group11.geektext.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, String> {
}
