package com.patrick.stocks.repositories;

import com.patrick.stocks.entities.SwsCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwsCompanyRepository extends JpaRepository<SwsCompany, String> {
}
