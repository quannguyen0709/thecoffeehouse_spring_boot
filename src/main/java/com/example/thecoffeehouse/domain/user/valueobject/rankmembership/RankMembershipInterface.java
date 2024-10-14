package com.example.thecoffeehouse.domain.user.valueobject.rankmembership;

import java.util.ArrayList;

public interface RankMembershipInterface {
    public RankMembershipInterface create(String nameRank, ArrayList<String> includedReward, int startBeanPoint, int endBeanPoint );
    public String getNameRank();
    public ArrayList<String> getIncludedReward();
    public int getStartBeanPoint();
    public  int getEndBeanPoint();
}
