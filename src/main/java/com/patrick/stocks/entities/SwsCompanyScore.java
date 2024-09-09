package com.patrick.stocks.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "swsCompanyScore")
public class SwsCompanyScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "company_id")
    private SwsCompany swsCompany;
    @Column(name = "date_generated", nullable = false)
    private Date dateGenerated;
    @Column(name = "dividend", nullable = false)
    private int dividend;
    @Column(name = "future", nullable = false)
    private int future;
    @Column(name = "health", nullable = false)
    private int health;
    @Column(name = "management", nullable = false)
    private int management;
    @Column(name = "past", nullable = false)
    private int past;
    @Column(name = "value", nullable = false)
    private int value;
    @Column(name = "misc", nullable = false)
    private int misc;
    @Column(name = "total", nullable = false)
    private int total;
    @Column(name = "sentence")
    private String sentence;
}
