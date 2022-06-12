package com.group11.geektext.Repo;

import com.group11.geektext.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
