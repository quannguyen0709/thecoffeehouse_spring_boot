package com.example.thecoffeehouse.mapper.user;

import com.example.thecoffeehouse.data.entities.user.RankMembershipEntity;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembership;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;
import netscape.javascript.JSObject;
import org.json.JSONArray;

public class RankMembershipMapper {
    public  static RankMembershipInterface toRankMembershipInterface(RankMembershipEntity entity) {
        JSONObject jo = new JSONObject();

        RankMembershipInterface rankMembershipInterface = new RankMembership().create(
                entity.getNameRank(),
                entity.getStartBeanPoint(),
                entity.getEndBeanPoint(),
        );
    }

    public static  RankMembershipEntity toRankMembershipEntity(RankMembershipInterface rankMembershipInterface) {
        JSONArray jsonArray = new JSONArray(rankMembershipInterface.getIncludedReward());
        RankMembershipEntity rankMembershipEntity = new RankMembershipEntity();
        rankMembershipEntity.setNameRank(rankMembershipInterface.getNameRank());
        rankMembershipEntity.setStartBeanPoint(rankMembershipInterface.getStartBeanPoint());
        rankMembershipEntity.setEndBeanPoint(rankMembershipInterface.getEndBeanPoint());
        rankMembershipEntity.setIncludedRewardJsonString(jsonArray.toString());
    }
}
