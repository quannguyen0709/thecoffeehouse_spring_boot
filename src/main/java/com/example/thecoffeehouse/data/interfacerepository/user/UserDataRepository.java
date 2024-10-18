package com.example.thecoffeehouse.data.interfacerepository.user;

import com.example.thecoffeehouse.data.entities.user.UserEntity;
import com.example.thecoffeehouse.data.repository.user.UserRepository;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.UserInerface;
import com.example.thecoffeehouse.mapper.user.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserDataRepository implements UserDataRepositoryInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserInerface user) throws ConflictException {
        try {
            UserEntity userEntity = UserMapper.toUserEntity(user);
            userRepository.save(userEntity);
        } catch (Exception e) {
            throw new ConflictException("Khong insert duoc User");
        }
    }

    @Override
    public boolean hasUserId(String id) {
        return userRepository.findById(id).isPresent();
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
