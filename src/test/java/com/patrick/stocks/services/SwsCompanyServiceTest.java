package com.patrick.stocks.services;


import com.patrick.stocks.repositories.SwsCompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static com.patrick.stocks.data.SwsCompanyData.createRandomCompany;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SwsCompanyService.class, SwsCompanyRepository.class})
public class SwsCompanyServiceTest {

    @MockBean
    private SwsCompanyRepository swsCompanyRepository;

    @Autowired
    private SwsCompanyService swsCompanyService;

    @Test
    public void testGetCompanies() {
        var company1 = createRandomCompany();
        var company2 = createRandomCompany();
        var expectedCompanies = List.of(company1, company2);

        when(swsCompanyRepository.findAll()).thenReturn(expectedCompanies);
        var companies = swsCompanyService.getCompanies();

        assertThat(companies).size().isEqualTo(expectedCompanies.size());
        assertThat(companies).usingRecursiveComparison().isEqualTo(expectedCompanies);
    }
}
