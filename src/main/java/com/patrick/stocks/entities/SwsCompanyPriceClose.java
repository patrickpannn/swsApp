package com.patrick.stocks.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "swsCompanyPriceClose")
public class SwsCompanyPriceClose {
    @EmbeddedId
    private SwsCompanyPriceCloseId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private SwsCompany swsCompany;
    @Column(name = "price", nullable = false)
    private float price;
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();

    @Data
    @NoArgsConstructor
    @Embeddable
    @AllArgsConstructor
    public static class SwsCompanyPriceCloseId implements Serializable {
        @Column(name = "date")
        private String date;
        @Column(name = "company_id")
        private String companyId;
    }
}