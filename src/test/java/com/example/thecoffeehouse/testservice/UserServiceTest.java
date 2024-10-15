package com.example.thecoffeehouse.testservice;


import com.example.thecoffeehouse.application.service.user.UserService;
import com.example.thecoffeehouse.data.interfacerepository.user.RankMembershipDataRepository;
import com.example.thecoffeehouse.data.interfacerepository.user.UserDataRepository;
import com.example.thecoffeehouse.data.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserService userService;

    @InjectMocks
    UserDataRepository userRepository;
    @InjectMocks
    RankMembershipDataRepository rankMembershipDataRepository;


    @Test
    void testCreateUser() {

    }
}
