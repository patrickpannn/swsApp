package com.patrick.stocks.services;

import com.patrick.stocks.entities.SwsCompany;
import com.patrick.stocks.repositories.SwsCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwsCompanyService {
    @Autowired
    private SwsCompanyRepository swsCompanyRepository;

    public List<SwsCompany> getCompanies() {
        return swsCompanyRepository.findAll();
    }
}
