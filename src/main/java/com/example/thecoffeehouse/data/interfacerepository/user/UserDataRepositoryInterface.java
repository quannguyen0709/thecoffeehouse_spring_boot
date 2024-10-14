package com.example.thecoffeehouse.data.interfacerepository.user;

import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.UserInerface;

public interface UserDataRepositoryInterface {
    public void save(UserInerface user) throws ConflictException;
    public boolean hasUserId(String id);
}
