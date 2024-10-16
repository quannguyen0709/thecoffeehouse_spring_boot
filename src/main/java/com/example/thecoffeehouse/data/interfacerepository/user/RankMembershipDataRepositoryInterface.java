package com.example.thecoffeehouse.data.interfacerepository.user;

import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;

import java.util.List;

public interface RankMembershipDataRepositoryInterface {
    public RankMembershipInterface getRankMembership(int level);
    public void addRankMembership(RankMembershipInterface rankMembership);
    public void addListRankMembership(List<RankMembershipInterface> listRankMembership);
    public void removeAllRankMembership();
}
