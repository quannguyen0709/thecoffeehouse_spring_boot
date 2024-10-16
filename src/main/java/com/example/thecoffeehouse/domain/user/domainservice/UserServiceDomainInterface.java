package com.example.thecoffeehouse.domain.user.domainservice;

import com.example.thecoffeehouse.data.interfacerepository.user.RankMembershipDataRepositoryInterface;
import com.example.thecoffeehouse.data.interfacerepository.user.UserDataRepositoryInterface;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import org.springframework.stereotype.Component;

import java.sql.Date;

public interface UserServiceDomainInterface {

    public static UserServiceDomainInterface  getInstance(){
        return  UserServiceDomain.getInstance();
    }

    public void setField(UserDataRepositoryInterface userDataRepository, RankMembershipDataRepositoryInterface rankMembershipDataRepository);

    public void createUser(
            String firstName,
            String lastName,
            String email,
            String password,
            String phone,
            Date birthDate,
            String urlAvatar) throws ConflictException;

    public void addRankMembership();
}
