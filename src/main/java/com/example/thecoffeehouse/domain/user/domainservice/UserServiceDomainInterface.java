package com.example.thecoffeehouse.domain.user.domainservice;

import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import org.springframework.stereotype.Component;

import java.sql.Date;

public interface UserServiceDomainInterface {
    public void createUser(
            String firstName,
            String lastName,
            String email,
            String password,
            String phone,
            Date birthDate,
            String urlAvatar) throws ConflictException;

}
