package com.example.thecoffeehouse.domain.user;

import com.example.thecoffeehouse.domain.common.valueobject.Phone;
import com.example.thecoffeehouse.domain.user.valueobject.UserId;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;

import java.sql.Date;


public interface UserInerface {
    public void create(UserId userId, String firstName, String lastName, String email, String password,Phone phone , Date birthDay, String urlAvatar, RankMembershipInterface rankMembershipInterface);
    public String getFirstName();
    public String getLastName();
    public String getEmail();
    public String getPassword();
    public Date getBirthDate();
    public Phone getPhone();
    public String getUrlAvatar();
    public RankMembershipInterface getRankMembership();
    public int getPointBeanCurrent();

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
