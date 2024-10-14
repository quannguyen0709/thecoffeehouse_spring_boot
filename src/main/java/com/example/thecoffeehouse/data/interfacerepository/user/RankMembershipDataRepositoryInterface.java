package com.example.thecoffeehouse.data.interfacerepository.user;

import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;

public interface RankMembershipDataRepositoryInterface {
    public RankMembershipInterface getRankMembership(int level);

}
