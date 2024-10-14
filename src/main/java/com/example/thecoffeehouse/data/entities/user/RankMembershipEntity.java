package com.example.thecoffeehouse.data.entities.user;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import javax.annotation.processing.Generated;
import java.util.ArrayList;

@Entity
@Table(name = "rank_membership")
public class RankMembershipEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String nameRank;


    private int startBeanPoint ;

    private int endBeanPoint ;

    private String includedRewardJsonString ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartBeanPoint() {
        return startBeanPoint;
    }

    public void setStartBeanPoint(int startBeanPoint) {
        this.startBeanPoint = startBeanPoint;
    }

    public int getEndBeanPoint() {
        return endBeanPoint;
    }

    public void setEndBeanPoint(int endBeanPoint) {
        this.endBeanPoint = endBeanPoint;
    }

    public String getIncludedRewardJsonString() {
        return includedRewardJsonString;
    }

    public void setIncludedRewardJsonString(String includedRewardJsonString) {
        this.includedRewardJsonString = includedRewardJsonString;
    }

    public String getNameRank() {
        return nameRank;
    }

    public void setNameRank(String nameRank) {
        this.nameRank = nameRank;
    }
}
