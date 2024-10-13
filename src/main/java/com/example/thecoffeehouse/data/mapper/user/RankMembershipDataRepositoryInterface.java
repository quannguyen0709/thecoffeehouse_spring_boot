package com.example.thecoffeehouse.data.mapper.user;

import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.LevelRankMembership;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;

public interface RankMembershipDataRepositoryInterface {
    public RankMembershipInterface getRankMembership(LevelRankMembership rankMembership);

}
