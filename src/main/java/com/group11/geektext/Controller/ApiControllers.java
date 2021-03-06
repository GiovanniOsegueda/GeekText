package com.group11.geektext.Controller;

import com.group11.geektext.Models.Author;
import com.group11.geektext.Models.Book;
import com.group11.geektext.Models.User;
import com.group11.geektext.Repo.AuthorRepo;
import com.group11.geektext.Repo.BookRepo;
import com.group11.geektext.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Hello World From group 11!! WOOT WOOT";
    }

    @GetMapping(value = "/users")
    public List<User> getUser(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/saveGeekText")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Congratulation it SAVED!!!!";
    }

    /*                                                                     //error: cannot resolve method
    @PostMapping(value = "/update/{id}")
    public String updateUser(long id, @RequestBody User user) {
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        updateUser.setCreditCard(user.getCreditCard());
        userRepo.save(updateUser);
        return "Updated user!";
    }
     */

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with id: " + id;
    }

    @GetMapping(value = "/books")
    public List<Book> getBook(){
        return bookRepo.findAll();
    }

    @PostMapping(value = "/saveBookGeekText")
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "Your book has been saved";
    }

    @GetMapping(value = "/ListAuthor")
    public List<Author> getAuthor(){
        return authorRepo.findAll();
    }

    @PostMapping(value = "/saveAuthor")
    public String saveAuthor(@RequestBody Author author){
        authorRepo.save(author);
        return "Author is save!";
    }



}// Ending BookRepo class
