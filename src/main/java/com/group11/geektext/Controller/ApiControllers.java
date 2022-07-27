package com.group11.geektext.Controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group11.geektext.Models.Author;
import com.group11.geektext.Models.Book;
import com.group11.geektext.Models.User;
import com.group11.geektext.Models.WishList;
import com.group11.geektext.Repo.AuthorRepo;
import com.group11.geektext.Repo.BookRepo;
import com.group11.geektext.Repo.UserRepo;
import com.group11.geektext.Repo.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//
@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    WishListRepo wishListRepo;
    //Online testing message
    @GetMapping(value = "/")
    public String getPage(){
        return "Hello World From group 11!! WOOT WOOT";
    }
    //Get a list of user
    @GetMapping(value = "/users")
    public List<User> getUser(){
        List<User> userList = userRepo.findAll();
        if(!userList.isEmpty()) {
            for(User user : userList) {
                List<WishList> wishList = wishListRepo.fetchWishListForUserWithId(user.getId());
                user.setWishList(wishList);
            }
        }
        return userList;
    }

    @PostMapping(value = "/saveGeekText")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Congratulation it SAVED!!!!";
    }

    //This will update existing user in the database
    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable(name = "id") long id, @RequestBody User user) {
        Optional<User> updateUser = userRepo.findById(id);
        if(updateUser.isPresent()) {
            User existingUser = updateUser.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setUserPassword(user.getUserPassword());
            existingUser.setBillingAddress(user.getBillingAddress());
            existingUser.setBillingCity(user.getBillingCity());
            existingUser.setBillingState(user.getBillingState());
            //existingUser.setEmail(user.getEmail());                           Per feature checklist do not change emails
            existingUser.setBillingZipCode(user.getBillingZipCode());
            existingUser.setCreditCard(user.getCreditCard());
            existingUser.setCreditCardExpDateMonth(user.getCreditCardExpDateMonth());
            existingUser.setGetCreditCardExpDateYear(user.getGetCreditCardExpDateYear());
            existingUser.setShippingAddress(user.getShippingAddress());
            existingUser.setShippingCity(user.getShippingCity());
            existingUser.setShippingState(user.getShippingState());
            existingUser.setShippingZipCode(user.getShippingZipCode());

            List<WishList> wishList = user.getWishList();
            if(!wishList.isEmpty()) {
                for(WishList wish : wishList) {
                    wish.setId(id);
                    wishListRepo.save(wish);
                }
            }
            userRepo.save(existingUser);

            //message will print accordingly
            return "User details updated successfully...!!!";
        } else {
            return "No user found";
        }

        //old outdated code
        /*updateUser.setFirstName(user.setFirstName(user.firstName).set());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        updateUser.setCreditCard(user.getCreditCard());
        userRepo.save(updateUser);*/
    }

    //delete user by entering id
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with id: " + id;
    }


    //@GetMapping(value = "/books")
    public List<Book> getBook(){
        return bookRepo.findAll();
    }

    @PostMapping(value = "/saveBookGeekText")
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "Your book has been saved";
    }

    //List author recorded in the database
    @GetMapping(value = "/ListAuthor")
    public List<Author> getAuthor(){
        return authorRepo.findAll();
    }

    /*                                                                                  7/15 error deleting author in mySQL

    @DeleteMapping(value = "author/delete/{id}")
    public String deleteAuthor(@PathVariable long id){
        Author deleteAuthor = authorRepo.findById(id).get();
        authorRepo.delete(deleteAuthor);
        return "Deleted Author with id: " + id;
    }

    @RequestMapping(path = "/findAuthorByName")
    public @ResponseBody String findAuthorFullName(@RequestParam String fullname){
        var author = authorRepo.findAuthorByAuthorFullName(Long.valueOf((fullname)));
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(author);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return "failed to find author with full name " + fullname;
    }


*/

} // Ending BookRepo class
