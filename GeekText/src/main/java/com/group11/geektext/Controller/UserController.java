package com.group11.geektext.Controller;

import com.group11.geektext.Models.User;
import com.group11.geektext.Repo.UserRepo;
import com.group11.geektext.Repo.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    WishListRepo wishListRepo;

    /**
     * This method is for getting all the user details from databse
     * @return list of all users
     */
    @GetMapping
    public List<User> getUsers() {
        List<User> userList = userRepo.findAll();
        return userList;
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<User> getUserByEmail(@PathVariable(name = "username")String email) {
        Optional<User> fetchedData = userRepo.findById(email);
        if(fetchedData.isPresent()) {
            return new ResponseEntity<>(fetchedData.get(), HttpStatus.OK);
        } else {
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {

        if(!isValidateUserInformation(user)) {
            return new ResponseEntity<>("Invalid user information, please check and try again.", HttpStatus.BAD_REQUEST);
        }
        if(userRepo.getUserDetailsByEmail(user.getEmail())!=null) {
            return new ResponseEntity<>("User with the same email already exist, please try different email", HttpStatus.BAD_REQUEST);
        }
        userRepo.save(user);
        return new ResponseEntity<>("User information created successfully", HttpStatus.OK);
    }

    private boolean isValidateUserInformation(User user) {
        if(user!=null) {
            if(user.getUserPassword()!=null
            && user.getBillingAddress()!=null
            && user.getBillingCity()!=null
            && user.getBillingState()!=null
            && user.getBillingZipCode()!=null
            && user.getCreditCard()!=null
            && user.getCreditCardExpDateMonth()!=null
            && user.getGetCreditCardExpDateYear()!=null
            && user.getEmail()!=null
            && user.getFirstName()!=null
            && user.getLastName()!=null
            && user.getShippingAddress()!=null
            && user.getShippingCity()!=null
            && user.getShippingState()!=null
            && user.getShippingZipCode()!=null) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is for updating existing user information with new details
     * @param username user email
     * @param user user information
     * @return status if it is success or failure
     */
    @PutMapping(value = "/{username}")
    public ResponseEntity<String> updateUser(@PathVariable(name = "username") String username, @RequestBody User user) {

        Optional<User> updateUser = userRepo.findById(username);
        if (updateUser.isPresent()) {
            User existingUser = updateUser.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setUserPassword(user.getUserPassword());
            existingUser.setBillingAddress(user.getBillingAddress());
            existingUser.setBillingCity(user.getBillingCity());
            existingUser.setBillingState(user.getBillingState());
            //existingUser.setEmail(user.getEmail());
            existingUser.setBillingZipCode(user.getBillingZipCode());
            existingUser.setCreditCard(user.getCreditCard());
            existingUser.setCreditCardExpDateMonth(user.getCreditCardExpDateMonth());
            existingUser.setGetCreditCardExpDateYear(user.getGetCreditCardExpDateYear());
            existingUser.setShippingAddress(user.getShippingAddress());
            existingUser.setShippingCity(user.getShippingCity());
            existingUser.setShippingState(user.getShippingState());
            existingUser.setShippingZipCode(user.getShippingZipCode());

            userRepo.save(existingUser);

            return new ResponseEntity<>("User details updated successfully...!!!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No user found", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username){
        Optional<User> deleteUser = userRepo.findById(username);
        if(deleteUser.isPresent()) {
            userRepo.delete(deleteUser.get());
            return new ResponseEntity<>("Deleted user with email id: " + username, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No user found with email id: "+ username, HttpStatus.BAD_REQUEST);
        }
    }
}
