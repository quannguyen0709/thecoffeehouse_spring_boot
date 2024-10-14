package com.example.thecoffeehouse.domain.user.domainservice;

import com.example.thecoffeehouse.data.interfacerepository.user.RankMembershipDataRepositoryInterface;
import com.example.thecoffeehouse.data.interfacerepository.user.UserDataRepositoryInterface;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.UserInerface;
import com.example.thecoffeehouse.domain.user.valueobject.UserId;

import java.sql.Date;
import java.util.UUID;

public class UserService implements UserServiceInterface {
    UserInerface userInerface;
    UserDataRepositoryInterface userDataRepositoryInterface;
    RankMembershipDataRepositoryInterface rankMembershipDataInterface;

    public UserService(UserDataRepositoryInterface userDataRepositoryInterface, RankMembershipDataRepositoryInterface rankMembershipDataInterface) {
        this.userDataRepositoryInterface = userDataRepositoryInterface;
        this.rankMembershipDataInterface = rankMembershipDataInterface;
    }

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
                rankMembershipDataInterface.getRankMembership(1)
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
