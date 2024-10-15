package com.example.thecoffeehouse.data.interfacerepository.user;

import com.example.thecoffeehouse.data.entities.user.RankMembershipEntity;
import com.example.thecoffeehouse.data.repository.user.RankMembershipRepository;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;
import com.example.thecoffeehouse.mapper.user.RankMembershipMapper;
import org.springframework.stereotype.Component;


@Component
public class RankMembershipDataRepository implements RankMembershipDataRepositoryInterface {
    private final RankMembershipRepository rankMembershipRepository;

    public RankMembershipDataRepository(RankMembershipRepository rankMembershipRepository) {
        this.rankMembershipRepository = rankMembershipRepository;
    }

    @Override
    public RankMembershipInterface getRankMembership(int level)  {
        return RankMembershipMapper.toRankMembershipInterface(rankMembershipRepository.findById(level).get());
    }
}
