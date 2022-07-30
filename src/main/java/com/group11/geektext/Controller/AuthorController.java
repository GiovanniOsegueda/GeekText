 package com.group11.geektext.Controller;

 import com.group11.geektext.Models.Author;
 import com.group11.geektext.Repo.AuthorRepo;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;

 @RestController
 @RequestMapping(path = "/authors")
 public class AuthorController
 {
     @Autowired
     public AuthorRepo authorRepo;

     //POST
     //curl localhost:8080/author/addAuthor -d first=first -d last=last
     //curl localhost:8080/author/addAuthor -d first=first -d last=last -d biography="this is the authors bio" -d publisher=testPublisher

     /**
      * this method is used for saving author information
      * @param author author information
      * @return success/error message
      */
     @PostMapping
     public ResponseEntity<String> saveAuthor(@RequestBody Author author){
         List<Author> authors = authorRepo.findAuthorByAllDetails(author.getAuthorFirstName(),
                 author.getAuthorLastName(), author.getAuthorPublisher());
         if(authors==null || authors.size() == 0) {
             authorRepo.save(author);
             return new ResponseEntity<>("Author details saved successfully!!", HttpStatus.OK);
         } else {
             return new ResponseEntity<>("Author details are already present", HttpStatus.BAD_REQUEST);             // Show error messages when author is already present
         }
    }

     /**
      * this method is for getting all the author information
      * @return list of authors
      */
     @GetMapping
     public List<Author> getAllAuthors() {
         return authorRepo.findAll();
     }
 }