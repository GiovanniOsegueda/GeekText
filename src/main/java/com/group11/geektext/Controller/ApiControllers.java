package com.group11.geektext.Controller;

import com.group11.geektext.Models.User;
import com.group11.geektext.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Hello From group 11!! WOOT WOOT";
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


}
