package com.group11.geektext.Controller;

import com.group11.geektext.Models.Rating;
import com.group11.geektext.Repo.RatingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books/{bookISBN}/reviews")
public class RatingsController {

    @Autowired
    private RatingsRepo ratingsRepo;

    @GetMapping
    public List<Rating> getAllRatings(@PathVariable(value = "bookISBN")String bookISBN, @RequestBody Rating rating) {
        return ratingsRepo.findAll();
    }
}
