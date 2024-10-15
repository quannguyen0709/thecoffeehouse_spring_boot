package com.example.thecoffeehouse.domain.user;

import com.example.thecoffeehouse.domain.common.model.ValueObject;
import com.example.thecoffeehouse.domain.common.valueobject.Phone;
import com.example.thecoffeehouse.domain.user.valueobject.UserId;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;

import java.sql.Date;


public interface UserInerface {
    public static UserInerface createInstace(UserId userId) {
        return new User(userId);
    }

    public void create(String firstName, String lastName, String email, String password,String phone , Date birthDay,int pointBeanCurrent, String urlAvatar, RankMembershipInterface rankMembershipInterface);
    public String getFirstName();
    public String getLastName();
    public String getEmail();
    public String getPassword();
    public Date getBirthDate();
    public String getPhone();
    public String getUrlAvatar();
    public RankMembershipInterface getRankMembership();
    public int getPointBeanCurrent();
    public UserId getUserId();

    public void setFirstName(String firstName);
    public void setLastName(String lastName);
    public void setEmail(String email);
    public void setPassword(String password);
    public void setBirthDate(Date birthDate);
    public void setPhone(Phone phone);
    public void setUrlAvatar(String urlAvatar);
    public void setRankMembership(RankMembershipInterface rankMembership);
    public void setPointBeanCurrent(int pointBeanCurrent);
}
