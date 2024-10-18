package com.example.thecoffeehouse.domain.user.domainservice.DomainserviceBeanDI;

import com.example.thecoffeehouse.application.service.user.UserService;
import com.example.thecoffeehouse.data.interfacerepository.user.RankMembershipDataRepositoryInterface;
import com.example.thecoffeehouse.data.interfacerepository.user.UserDataRepositoryInterface;
import com.example.thecoffeehouse.domain.user.domainservice.UserServiceDomain;
import com.example.thecoffeehouse.domain.user.domainservice.UserServiceDomainInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DomainService {
    @Bean
    UserServiceDomain userServiceDomain(@Autowired UserDataRepositoryInterface userDataRepository, @Autowired RankMembershipDataRepositoryInterface rankMembershipDataRepositoryInterface) {
        return new UserServiceDomain(userDataRepository, rankMembershipDataRepositoryInterface);
    }
}