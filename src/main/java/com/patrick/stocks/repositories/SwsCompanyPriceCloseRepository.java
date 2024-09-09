package com.patrick.stocks.repositories;

import com.patrick.stocks.entities.SwsCompanyPriceClose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SwsCompanyPriceCloseRepository extends JpaRepository<SwsCompanyPriceClose, SwsCompanyPriceClose.SwsCompanyPriceCloseId> {
}
