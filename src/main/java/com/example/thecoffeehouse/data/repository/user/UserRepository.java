package com.example.thecoffeehouse.data.repository.user;

import com.example.thecoffeehouse.data.entities.user.UserEntity;
import com.example.thecoffeehouse.data.repository.CurdRepositoryJPA;

public interface UserRepository extends CurdRepositoryJPA<UserEntity, String> {
}
