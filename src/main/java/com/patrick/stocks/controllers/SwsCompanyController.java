package com.patrick.stocks.controllers;

import com.patrick.stocks.dto.SwsCompanyDto;
import com.patrick.stocks.dto.SwsCompanyDtoConverter;
import com.patrick.stocks.services.SwsCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SwsCompanyController {

    @Autowired
    private SwsCompanyService swsCompanyService;

    @GetMapping("/SwsCompanies")
    public List<SwsCompanyDto> getCompanies(@RequestParam("prices") Optional<Boolean> prices) {
        var includePrices = prices.orElse(false);
        return swsCompanyService
                .getCompanies()
                .stream()
                .map(company -> SwsCompanyDtoConverter.convertToDto(company, includePrices))
                .collect(Collectors.toList());
    }
}
