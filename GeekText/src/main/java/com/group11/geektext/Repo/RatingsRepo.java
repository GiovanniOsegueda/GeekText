package com.group11.geektext.Repo;


import com.group11.geektext.Models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepo extends JpaRepository<Rating, Integer> {

}
