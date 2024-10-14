package com.example.thecoffeehouse.data.entities.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;

@Entity
@Table(name = "user_account")
public class UserEntity {
    @NotNull
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateOfBirth;
    private String phoneNumber;
    private int pointBeanCurrent;
    private String urlAvatar;
    private String rankMembershipId;

    public @NotNull String getUserId() {
        return userId;
    }

    public void setUserId(@NotNull String userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPointBeanCurrent() {
        return pointBeanCurrent;
    }

    public void setPointBeanCurrent(int pointBeanCurrent) {
        this.pointBeanCurrent = pointBeanCurrent;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getRankMembershipId() {
        return rankMembershipId;
    }

    public void setRankMembershipId(String rankMembershipId) {
        this.rankMembershipId = rankMembershipId;
    }
}
