package com.example.thecoffeehouse.domain.user.valueobject.rankmembership;

import com.example.thecoffeehouse.domain.common.model.ValueObject;

import java.util.ArrayList;

public class RankMembership extends ValueObject implements RankMembershipInterface {
    private String nameRank;
    private ArrayList<String> includedReward;
    private int startBeanPoint;
    private  int endBeanPoint;
    public RankMembership() {}
    private RankMembership(String nameRank, ArrayList<String> includedReward, int startBeanPoint, int endBeanPoint) {
        this.nameRank = nameRank;
        this.includedReward = includedReward;
        this.startBeanPoint = startBeanPoint;
        this.endBeanPoint = endBeanPoint;
    }


    public static boolean equal(RankMembershipInterface rankMembership1, RankMembershipInterface rankMembership2) {
        return  rankMembership1.getNameRank().equals(rankMembership2.getNameRank()) ;
    }

    @Override
    public RankMembershipInterface create(String nameRank, ArrayList<String> includedReward, int startBeanPoint, int endBeanPoint) {
        return  new RankMembership(nameRank, includedReward, startBeanPoint, endBeanPoint);
    }

    public String getNameRank() {
        return nameRank;
    }

    private void setNameRank(String nameRank) {
        this.nameRank = nameRank;
    }

    public ArrayList<String> getIncludedReward() {
        return includedReward;
    }

    private void setIncludedReward(ArrayList<String> includedReward) {
        this.includedReward = includedReward;
    }

    public int getStartBeanPoint() {
        return startBeanPoint;
    }

    private void setStartBeanPoint(int startBeanPoint) {
        this.startBeanPoint = startBeanPoint;
    }

    @Override
    public int getEndBeanPoint() {
        return endBeanPoint;
    }

    public void setEndBeanPoint(int endBeanPoint) {
        this.endBeanPoint = endBeanPoint;
    }
}
