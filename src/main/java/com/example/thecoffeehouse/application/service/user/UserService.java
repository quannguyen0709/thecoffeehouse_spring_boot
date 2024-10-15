package com.example.thecoffeehouse.application.service.user;

import com.example.thecoffeehouse.data.interfacerepository.user.RankMembershipDataRepositoryInterface;
import com.example.thecoffeehouse.data.interfacerepository.user.UserDataRepositoryInterface;
import com.example.thecoffeehouse.data.repository.user.RankMembershipRepository;
import com.example.thecoffeehouse.data.repository.user.UserRepository;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.domainservice.UserServiceDomain;
import com.example.thecoffeehouse.domain.user.domainservice.UserServiceDomainInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.sql.Date;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserDataRepositoryInterface userRepository;

    @Autowired
    private RankMembershipDataRepositoryInterface rankMembershipDataRepository;

    @Autowired
    UserServiceDomainInterface userServiceDomain;

    @Value("classpath:JsonTheCoffeeHouse/rank_membership.txt")
    Resource resourceFile;

    @Autowired
    ResourceLoader  resourceLoader;



    public void  addUser(String firstName, String lastName, String email, String password, String phone, Date birthDate , String urlAvatar) {

        try {
            userServiceDomain.createUser(firstName, lastName, email, password, phone, birthDate, urlAvatar);

        } catch (ConflictException e) {
            throw new RuntimeException(e);
        }
    }


    public void createRankInfor(){
        try {
            String readText = "";
            InputStream inputStream = resourceLoader.getResource("classpath:JsonTheCoffeeHouse/rank_membership.txt").getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            readText = bufferedReader.lines()
                    .collect(Collectors.joining("\n"));
            bufferedReader.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create (){

        try {
            File resource = new ClassPathResource(
                    "/rank_membership.txt").getFile();
            String employees = new String(
                    Files.readAllBytes(resource.toPath()));

            employees.trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
