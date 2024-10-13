package com.example.thecoffeehouse.domain.user.domainservice;

import com.example.thecoffeehouse.domain.common.exception.ConflictException;

import java.sql.Date;

interface UserServiceInterface {
    public void createUser(
            String firstName,
            String lastName,
            String email,
            String password,
            String phone,
            Date birthDate,
            String urlAvatar) throws ConflictException;
}
