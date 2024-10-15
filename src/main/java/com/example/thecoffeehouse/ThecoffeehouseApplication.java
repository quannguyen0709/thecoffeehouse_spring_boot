package com.example.thecoffeehouse;

import com.example.thecoffeehouse.application.service.user.UserService;
import com.example.thecoffeehouse.domain.user.User;
import com.example.thecoffeehouse.domain.user.UserInerface;
import com.example.thecoffeehouse.domain.user.valueobject.UserId;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;

@SpringBootApplication
public class ThecoffeehouseApplication {


	public static void main(String[] args) {
		SpringApplication.run(ThecoffeehouseApplication.class, args);

	}



}
