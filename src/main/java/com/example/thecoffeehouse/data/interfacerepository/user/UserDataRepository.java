package com.example.thecoffeehouse.data.interfacerepository.user;

import com.example.thecoffeehouse.data.entities.user.UserEntity;
import com.example.thecoffeehouse.data.repository.user.UserRepository;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.UserInerface;
import com.example.thecoffeehouse.mapper.user.UserMapper;

public class UserDataRepository implements UserDataRepositoryInterface{
    private final UserRepository userRepository;

    public UserDataRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserInerface user) throws ConflictException {
        try {
            UserEntity entity = UserMapper.toUserEntity(user);
            userRepository.save(entity);
        }catch (Exception e){
           throw new ConflictException("Khong insert duoc User");
        }
    }

    @Override
    public boolean hasUserId(String id) {
        try {
            userRepository.existsById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
