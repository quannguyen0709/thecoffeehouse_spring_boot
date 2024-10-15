package com.example.thecoffeehouse.data.repository.user;

import com.example.thecoffeehouse.data.entities.user.UserEntity;
import com.example.thecoffeehouse.data.repository.CurdRepositoryJPA;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CurdRepositoryJPA<UserEntity, String> {
}
