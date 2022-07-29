 package com.group11.geektext.Controller;

import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group11.geektext.Models.Author;
import com.group11.geektext.Repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

 @RestController  //class is a controller (MVC)
 @RequestMapping(path = "/authors")
 public class AuthorController
 {
     @Autowired
     public AuthorRepo authorRepo;

     //POST
     @PostMapping
     public String saveAuthor(@RequestBody Author author){
         authorRepo.save(author);
         return "Author details saved successfully...!!!";
     }
    //Fetch request to all the authors
     @GetMapping
     public List<Author> getAllAuthors() {
         return authorRepo.findAll();
     }

     //GET
     //curl localhost:8080/author/findAuthorByName -d fullName="first last"
     @GetMapping (path = "/findAuthorByName")
     public List<Author> getAuthorFullName()
     {
         return authorRepo.findAll();
     }

     //GET
     //curl test //curl -X GET localhost:8080/author/allAuthors
     /*@GetMapping(path = "/allAuthors")
     public @ResponseBody Iterable<Author> getAllAuthors ()
     {
         //returns a JSON/XML with all books
         return authorRepo.findAll();
     }*/
 }