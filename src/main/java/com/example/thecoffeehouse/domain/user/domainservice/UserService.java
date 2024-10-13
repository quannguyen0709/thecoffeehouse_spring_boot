package com.example.thecoffeehouse.domain.user.domainservice;

import com.example.thecoffeehouse.data.mapper.user.RankMembershipDataRepositoryInterface;
import com.example.thecoffeehouse.data.mapper.user.UserDataRepositoryInterface;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.common.valueobject.Phone;
import com.example.thecoffeehouse.domain.user.UserInerface;
import com.example.thecoffeehouse.domain.user.valueobject.UserId;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.LevelRankMembership;

import java.sql.Date;
import java.util.UUID;

public class UserService implements UserServiceInterface {
    UserInerface userInerface;
    UserDataRepositoryInterface userDataRepositoryInterface;
    RankMembershipDataRepositoryInterface rankMembershipDataInterface;

    @Override
    public void createUser( String firstName, String lastName, String email, String password, String phone, Date birthDate ,String urlAvatar) throws ConflictException {
        userInerface.create(
                createId(),
                firstName,
                lastName,
                email,
                password,
                new Phone(phone),
                birthDate,
                urlAvatar,
                rankMembershipDataInterface.getRankMembership(LevelRankMembership.NEW)
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
