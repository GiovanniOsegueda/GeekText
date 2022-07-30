package com.group11.geektext.Repo;

import com.group11.geektext.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String> {

    @Query("from User where email = ?1")                    //SQL statement will perform this query
    public User getUserDetailsByEmail(String email);
}
