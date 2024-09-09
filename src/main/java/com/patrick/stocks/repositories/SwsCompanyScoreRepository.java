package com.patrick.stocks.repositories;

import com.patrick.stocks.entities.SwsCompanyScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwsCompanyScoreRepository extends JpaRepository<SwsCompanyScore, Integer> {
}
