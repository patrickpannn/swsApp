package com.patrick.stocks.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "swsCompany")
public class SwsCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "ticker_symbol")
    private String tickerSymbol;
    @Column(name = "exchange_symbol")
    private String exchangeSymbol;
    @Column(name = "unique_symbol")
    private String uniqueSymbol;
    @Column(name = "date_generated")
    private Date dateGenerated;
    @Column(name = "security_name")
    private String securityName;
    @Column(name = "exchange_country_iso")
    private String exchangeCountryIso;
    @Column(name = "listing_currency_iso")
    private String listingCurrencyIso;
    @Column(name = "canonical_url")
    private String canonicalUrl;
    @Column(name = "unique_symbol_slug")
    private String uniqueSymbolSlug;
    @OneToOne(cascade = ALL)
    @JoinColumn(name = "score_id")
    private SwsCompanyScore swsCompanyScore;
    @OneToMany(cascade = ALL, mappedBy = "swsCompany", fetch = LAZY)
    private List<SwsCompanyPriceClose> swsCompanyPriceCloseList;
}
