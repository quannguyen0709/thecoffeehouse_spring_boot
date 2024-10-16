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


    private static UserServiceDomain instance = new UserServiceDomain();
    private    UserServiceDomain(){}

    public static UserServiceDomain getInstance(){return  instance;}

    public void setField(UserDataRepositoryInterface userDataRepositoryInterface, RankMembershipDataRepositoryInterface rankMembershipDataInterface) {
        instance.userDataRepositoryInterface = userDataRepositoryInterface;
        instance.rankMembershipDataInterface = rankMembershipDataInterface;
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
                rankMembershipDataInterface.getRankMembership(LevelRankMembership.getValue(LevelRankMembership.DIAMOND.name()))
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

        String jsonStr = ReadFileResourceInterface.getInstance().getFileUseResourceLoader("/rank_membership.txt");
        RankMembership[] readValue = {};
        try {
            instance.rankMembershipDataInterface.removeAllRankMembership();
            readValue = mapper.readValue(jsonStr, RankMembership[].class);

            instance.rankMembershipDataInterface.addListRankMembership(Arrays.asList(readValue));
            System.out.println("Users Saved!");
        } catch (Exception e) {

            System.out.println("Unable to save users: " + e.getMessage());
        }
    }



}
