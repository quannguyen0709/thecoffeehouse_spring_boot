package com.example.thecoffeehouse.domain.user.valueobject.rankmembership;

import com.example.thecoffeehouse.domain.common.model.ValueObject;

import java.util.ArrayList;

public class RankMembership extends ValueObject implements RankMembershipInterface {
    private String nameRank;
    private ArrayList<String> includedReward;
    private int beanPoint;
    private RankMembership(String nameRank, ArrayList<String> includedReward, int beanPoint) {
        this.nameRank = nameRank;
        this.includedReward = includedReward;
        this.beanPoint = beanPoint;
    }


    public static boolean equal(RankMembershipInterface rankMembership1, RankMembershipInterface rankMembership2) {
        return  rankMembership1.getNameRank().equals(rankMembership2.getNameRank()) && rankMembership1.getBeanPoint() == rankMembership2.getBeanPoint();
    }

    @Override
    public RankMembershipInterface create(String nameRank, ArrayList<String> includedReward, int beanPoint) {
        return  new RankMembership(nameRank, includedReward, beanPoint);
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

    public int getBeanPoint() {
        return beanPoint;
    }

    private void setBeanPoint(int beanPoint) {
        this.beanPoint = beanPoint;
    }

}
