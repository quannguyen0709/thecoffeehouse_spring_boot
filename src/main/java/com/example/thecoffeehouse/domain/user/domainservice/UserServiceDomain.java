package com.example.thecoffeehouse.domain.user.domainservice;

import com.example.thecoffeehouse.data.interfacerepository.user.RankMembershipDataRepositoryInterface;
import com.example.thecoffeehouse.data.interfacerepository.user.UserDataRepositoryInterface;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.UserInerface;
import com.example.thecoffeehouse.domain.user.valueobject.UserId;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.LevelRankMembership;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembership;
import com.example.thecoffeehouse.util.ReadFileResourceInterface;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Date;
import java.util.Arrays;
import java.util.UUID;

public class UserServiceDomain implements UserServiceDomainInterface {

    UserInerface userInerface;

    UserDataRepositoryInterface userDataRepositoryInterface;

    RankMembershipDataRepositoryInterface rankMembershipDataInterface;


    public UserServiceDomain(UserDataRepositoryInterface repositoryInterface, RankMembershipDataRepositoryInterface rankMembershipDataRepositoryInterface) {
        this.userDataRepositoryInterface = repositoryInterface;
        this.rankMembershipDataInterface = rankMembershipDataRepositoryInterface;

    }




    @Override
    public void createUser( String firstName, String lastName, String email, String password, String phone, Date birthDate ,String urlAvatar) throws ConflictException {
        userDataRepositoryInterface.deleteAllUsers();
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
                rankMembershipDataInterface.getRankMembership(LevelRankMembership.getValue(LevelRankMembership.SILVER.name()))
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

    public void addRankMembership() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String jsonStr = ReadFileResourceInterface.getInstance().getFileUseResourceLoader("/rank_membership.json");
        RankMembership[] readValue = {};
        try {
            this.rankMembershipDataInterface.removeAllRankMembership();
            readValue = mapper.readValue(jsonStr, RankMembership[].class);

            this.rankMembershipDataInterface.addListRankMembership(Arrays.asList(readValue));
            System.out.println("Users Saved!");
        } catch (Exception e) {

            System.out.println("Unable to save users: " + e.getMessage());
        }
    }



}
