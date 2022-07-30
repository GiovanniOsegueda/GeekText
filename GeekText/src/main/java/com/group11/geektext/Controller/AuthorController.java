 package com.group11.geektext.Controller;

import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     //curl localhost:8080/author/addAuthor -d first=first -d last=last
     //curl localhost:8080/author/addAuthor -d first=first -d last=last -d biography="this is the authors bio" -d publisher=testPublisher

     /**
      *
      * @param author
      * @return HttpStatus.OK or HttpStatus.Bad_REQUEST & String of success or failure
      * Author: Michelle Picciuto
      */

     @PostMapping
     public ResponseEntity<String> saveAuthor(@RequestBody Author author){
         List<Author> authors = authorRepo.findAuthorByAllDetails(author.getAuthorFirstName(),
                 author.getAuthorLastName(), author.getAuthorPublisher());
         if(authors==null || authors.size() == 0) {
             authorRepo.save(author);
             return new ResponseEntity<>("Author details saved successfully...!!!", HttpStatus.OK);
         } else {
             return new ResponseEntity<>("Author details are already present", HttpStatus.BAD_REQUEST);
         }
    }

     /**
      * Listing all the Authors
      * @return Author List
      * Author: Michelle Picciuto
      */
     @GetMapping
     public List<Author> getAllAuthors() {
         return authorRepo.findAll();
     }
 }