package com.example.thecoffeehouse.mapper.user;

import com.example.thecoffeehouse.data.entities.user.UserEntity;
import com.example.thecoffeehouse.domain.user.UserInerface;
import com.example.thecoffeehouse.domain.user.valueobject.UserId;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    //public Dto toDto(UserInerface user) {}
    //public Dto toDto(UserEntity user) {}
    public static UserInerface toUserInerface(UserEntity userEntity, RankMembershipInterface rankMembershipInterface) {
        UserInerface userInstance = UserInerface.createInstace(new UserId().create(userEntity.getUserId(), userEntity.getUserId()));
        userInstance.create(
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getPhoneNumber(),
                userEntity.getDateOfBirth(),
                userEntity.getPointBeanCurrent(),
                userEntity.getUrlAvatar(),
                rankMembershipInterface
        );
        return  userInstance;
    }
    public static UserEntity toUserEntity(UserInerface userInerface) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userInerface.getUserId().getValueUserId());
        userEntity.setFirstName(userInerface.getFirstName());
        userEntity.setLastName(userInerface.getLastName());
        userEntity.setEmail(userInerface.getEmail());
        userEntity.setPassword(userInerface.getPassword());
        userEntity.setDateOfBirth(userInerface.getBirthDate());
        userEntity.setPointBeanCurrent(userInerface.getPointBeanCurrent());
        userEntity.setUrlAvatar(userInerface.getUrlAvatar());
        return userEntity;
    }
}
