package com.example.thecoffeehouse.data.interfacerepository.user;

import com.example.thecoffeehouse.data.entities.user.RankMembershipEntity;
import com.example.thecoffeehouse.data.repository.user.RankMembershipRepository;
import com.example.thecoffeehouse.domain.common.exception.ConflictException;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembership;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembershipInterface;
import com.example.thecoffeehouse.mapper.user.RankMembershipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RankMembershipDataRepository implements RankMembershipDataRepositoryInterface {

    @Autowired
    private RankMembershipRepository rankMembershipRepository;


    @Override
    public RankMembershipInterface getRankMembership(int level) {
        RankMembershipEntity rankMembershipEntity = rankMembershipRepository.findById(level).get();
        RankMembershipInterface rankMembershipInterface =  RankMembershipMapper.toRankMembershipInterface(rankMembershipEntity);
        return rankMembershipInterface;
    }

    @Override
    public void addRankMembership(RankMembershipInterface rankMembership) {
        rankMembershipRepository.save(RankMembershipMapper.toRankMembershipEntity(rankMembership));
    }

    @Override
    public void addListRankMembership(List<RankMembershipInterface> listRankMembership) {
        for (RankMembershipInterface rankMembership : listRankMembership) {
            rankMembershipRepository.save(RankMembershipMapper.toRankMembershipEntity(rankMembership));
        }
    }

    @Override
    public void removeAllRankMembership() {
        rankMembershipRepository.deleteAll();
    }
}
