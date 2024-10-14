package com.example.thecoffeehouse.data.repository.user;

import com.example.thecoffeehouse.data.entities.user.RankMembershipEntity;
import com.example.thecoffeehouse.data.repository.CurdRepositoryJPA;
import com.example.thecoffeehouse.domain.user.valueobject.rankmembership.RankMembership;

public interface RankMembershipRepository extends CurdRepositoryJPA<RankMembershipEntity, Integer> {
}
