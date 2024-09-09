package com.patrick.stocks.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrick.stocks.dto.SwsCompanyDto;
import com.patrick.stocks.dto.SwsCompanyDtoConverter;
import com.patrick.stocks.services.SwsCompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.patrick.stocks.data.SwsCompanyData.createRandomCompany;
import static com.patrick.stocks.data.SwsCompanyData.createRandomCompanyWithPrices;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SwsCompanyController.class)
@AutoConfigureMockMvc
public class SwsCompanyControllerTest {
    @MockBean
    private SwsCompanyService swsCompanyService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetCompaniesWithoutPrices() throws Exception {
        var company1 = createRandomCompany();
        var company2 = createRandomCompany();
        var expectedCompanies = List.of(company1, company2);
        var expectedCompanyDtos = List.of(
                SwsCompanyDtoConverter.convertToDto(company1, false),
                SwsCompanyDtoConverter.convertToDto(company2, false)
        );

        when(swsCompanyService.getCompanies()).thenReturn(expectedCompanies);

        var result = mockMvc.perform(get("/SwsCompanies")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var resultDtos = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<SwsCompanyDto>>() {});
        assertThat(resultDtos).size().isEqualTo(expectedCompanyDtos.size());
        assertThat(resultDtos).usingRecursiveComparison().isEqualTo(expectedCompanyDtos);
    }

    @Test
    public void testGetCompaniesWithPrices() throws Exception {
        var company1 = createRandomCompanyWithPrices();
        var company2 = createRandomCompanyWithPrices();
        var expectedCompanies = List.of(company1, company2);
        var expectedCompanyDtos = List.of(
                SwsCompanyDtoConverter.convertToDto(company1, true),
                SwsCompanyDtoConverter.convertToDto(company2, true)
        );

        when(swsCompanyService.getCompanies()).thenReturn(expectedCompanies);
        var response = mockMvc.perform(get("/SwsCompanies")
                        .param("prices", "true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var resultDtos = objectMapper.readValue(response.getResponse().getContentAsString(), new TypeReference<List<SwsCompanyDto>>() {});
        assertThat(resultDtos).size().isEqualTo(expectedCompanyDtos.size());
        assertThat(resultDtos).usingRecursiveComparison().isEqualTo(expectedCompanyDtos);
    }
}
