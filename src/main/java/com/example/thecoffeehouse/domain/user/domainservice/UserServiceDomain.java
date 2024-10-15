package com.example.thecoffeehouse.domain.user.domainservice;

import com.example.thecoffeehouse.data.interfacerepository.user.RankMembershipDataRepositoryInterface;
import com.example.thecoffeehouse.data.interfacerepository.user.UserDataRepositoryInterface;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.UserInerface;
import com.example.thecoffeehouse.domain.user.valueobject.UserId;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.LevelRankMembership;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.UUID;

@Component
public class UserServiceDomain implements UserServiceDomainInterface {
    UserInerface userInerface;
    @Autowired
    UserDataRepositoryInterface userDataRepositoryInterface;
    @Autowired
    RankMembershipDataRepositoryInterface rankMembershipDataInterface;


    @Override
    public void createUser( String firstName, String lastName, String email, String password, String phone, Date birthDate ,String urlAvatar) throws ConflictException {
        userInerface = UserInerface.createInstace(createId());
        userInerface.create(
                firstName,
                lastName,
                email,
                password,
                phone,
                birthDate,
                0,
                urlAvatar,
                rankMembershipDataInterface.getRankMembership(LevelRankMembership.getValue(LevelRankMembership.NEW))
        );
        userDataRepositoryInterface.save(userInerface);
    }



    private UserId createId() {
        UUID uuid = UUID.randomUUID();
        do {
            if (!userDataRepositoryInterface.hasUserId(uuid.toString())) {
                return new UserId().create(uuid.toString(), uuid.toString());
            } else {
                uuid = UUID.randomUUID();
            }
        } while (true);
    }



}
