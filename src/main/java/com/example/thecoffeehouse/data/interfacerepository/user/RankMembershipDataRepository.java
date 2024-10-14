package com.example.thecoffeehouse.data.interfacerepository.user;

import com.example.thecoffeehouse.data.repository.user.RankMembershipRepository;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;

public class RankMembershipDataRepository implements RankMembershipDataRepositoryInterface {
    private final RankMembershipRepository rankMembershipRepository;

    public RankMembershipDataRepository(RankMembershipRepository rankMembershipRepository) {
        this.rankMembershipRepository = rankMembershipRepository;
    }

    @Override
    public RankMembershipInterface getRankMembership(int level)  {
        return rankMembershipRepository.findById(level).get();
    }
}
