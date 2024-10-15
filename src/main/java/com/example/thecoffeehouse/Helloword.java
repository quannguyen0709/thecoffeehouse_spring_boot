package com.example.thecoffeehouse;

import com.example.thecoffeehouse.application.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class Helloword {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public void index() {
       userService.createRankInfor();
       // userService.create();
       // userService.addUser("Nguyễn ", "Quân ","quangquan21102002@gmail.com", "quan123", "0769147688",new Date(2024,10,10), "");
    }
}
