package com.example.thecoffeehouse.domain.user;

import com.example.thecoffeehouse.domain.common.model.Aggregate;
import com.example.thecoffeehouse.domain.common.model.ValueObject;
import com.example.thecoffeehouse.domain.common.valueobject.Phone;
import com.example.thecoffeehouse.domain.user.valueobject.UserId;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembership;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;

import java.sql.Date;

public class User extends Aggregate<UserId> implements UserInerface {
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private Phone phone;
    private String urlAvatar;
    private RankMembershipInterface rankMembership;
    private int pointBeanCurrent;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public User(UserId objectId) {
        super(objectId);
    }

    @Override
    public void create(String firstName, String lastName, String email, String password, String phone,  Date birthDay, int pointBeanCurrent,String urlAvatar, RankMembershipInterface rankMembershipInterface) {
        UserInerface createUser = this;
        createUser.setFirstName(firstName);
        createUser.setLastName(lastName);
        createUser.setEmail(email);
        createUser.setPassword(password);
        createUser.setPhone(new Phone(phone));
        createUser.setUrlAvatar(urlAvatar);
        createUser.setBirthDate(birthDay);
        createUser.setPointBeanCurrent(0);
        createUser.setPointBeanCurrent(pointBeanCurrent);
        createUser.setRankMembership(rankMembershipInterface);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }


    public RankMembershipInterface getRankMembership() {
        return rankMembership;
    }

    public void setRankMembership(RankMembershipInterface rankMembership) {
        this.rankMembership = rankMembership;
    }

    public int getPointBeanCurrent() {
        return pointBeanCurrent;
    }

    @Override
    public UserId getUserId() {
        return  super.getId();
    }

    public void setPointBeanCurrent(int pointBeanCurrent) {
        this.pointBeanCurrent = pointBeanCurrent;
    }

}
