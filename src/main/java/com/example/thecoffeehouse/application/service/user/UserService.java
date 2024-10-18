package com.example.thecoffeehouse.application.service.user;

import com.example.thecoffeehouse.data.interfacerepository.user.RankMembershipDataRepositoryInterface;
import com.example.thecoffeehouse.data.interfacerepository.user.UserDataRepositoryInterface;
import com.example.thecoffeehouse.data.repository.user.RankMembershipRepository;
import com.example.thecoffeehouse.data.repository.user.UserRepository;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.domainservice.UserServiceDomain;
import com.example.thecoffeehouse.domain.user.domainservice.UserServiceDomainInterface;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembership;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;
import com.example.thecoffeehouse.mapper.user.RankMembershipMapper;
import com.example.thecoffeehouse.util.ReadFileResourceInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserDataRepositoryInterface userDataRepository;

    @Autowired
    private RankMembershipDataRepositoryInterface rankMembershipDataRepository;

    @Autowired
    private UserServiceDomainInterface userServiceDomain ;


    public void addUser(String firstName, String lastName, String email, String password, String phone, Date birthDate, String urlAvatar) {
        try {

            userServiceDomain.createUser(firstName, lastName, email, password, phone, birthDate, urlAvatar);

        } catch (ConflictException e) {
            throw new RuntimeException(e);
        }
    }

    public void addRankMembership() {
        userServiceDomain.addRankMembership();
        //ObjectMapper mapper = new ObjectMapper();
        //mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//
        //String jsonStr = ReadFileResourceInterface.getInstance().getFileUseResourceLoader("/rank_membership.json");
        //RankMembership[] readValue = {};
        //try {
        //    rankMembershipDataRepository.removeAllRankMembership();
        //    readValue = mapper.readValue(jsonStr, RankMembership[].class);
//
        //    rankMembershipDataRepository.addListRankMembership(Arrays.asList(readValue));
        //    System.out.println("Users Saved!");
        //} catch (Exception e) {
//
        //    System.out.println("Unable to save users: " + e.getMessage());
        //}
    }


}
