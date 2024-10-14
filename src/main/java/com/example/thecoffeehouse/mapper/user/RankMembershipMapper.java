package com.example.thecoffeehouse.mapper.user;

import com.example.thecoffeehouse.data.entities.user.RankMembershipEntity;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.LevelRankMembership;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembership;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class RankMembershipMapper {
    static final private ObjectMapper objectMapper  = new JsonMapper();
    public  static RankMembershipInterface toRankMembershipInterface(RankMembershipEntity entity) {
        RankMembershipInterface rankMembership;
        try {
            ArrayList<String> includedReward = objectMapper.readValue(entity.getIncludedRewardJsonString(), ArrayList.class);
             rankMembership = new RankMembership();
            rankMembership.create(
                    LevelRankMembership.getLevelRankMembership(entity.getId()),
                    includedReward,
                    entity.getStartBeanPoint(),
                    entity.getEndBeanPoint()
            );
            return rankMembership;
        } catch (JsonProcessingException e) {
            return null;
        }

    }

    public static  RankMembershipEntity toRankMembershipEntity(RankMembershipInterface rankMembershipInterface) {
        String jsonArray = null;
        try {
            jsonArray = objectMapper.writeValueAsString(rankMembershipInterface.getIncludedReward());
        } catch (JsonProcessingException e) {
            jsonArray = null;
        }
        RankMembershipEntity rankMembershipEntity = new RankMembershipEntity();
        rankMembershipEntity.setId(LevelRankMembership.getValue(rankMembershipInterface.getNameRank()));
        rankMembershipEntity.setNameRank(rankMembershipInterface.getNameRank().toString());
        rankMembershipEntity.setStartBeanPoint(rankMembershipInterface.getStartBeanPoint());
        rankMembershipEntity.setEndBeanPoint(rankMembershipInterface.getEndBeanPoint());
        rankMembershipEntity.setIncludedRewardJsonString(jsonArray);

        return rankMembershipEntity;
    }
}
