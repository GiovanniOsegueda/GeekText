package com.group11.geektext.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {

    @GetMapping(value = "/")
    public String getPage(){
        return "Hello World From group 11!! WOOT WOOT";
    }

} // Ending BookRepo class
