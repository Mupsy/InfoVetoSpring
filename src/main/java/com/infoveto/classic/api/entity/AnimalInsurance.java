package com.infoveto.classic.api.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "animal_insurance", schema = "infoveto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    public String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonProperty("animal")
    private Animals animal;

    @Column(name = "insurer")
    @JsonProperty("insurer")
    private String insurer;

    @Column(name = "policy_number")
    @JsonProperty("policyNumber")
    private BigInteger policyNumber;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "phone")
    @JsonProperty("phoneNumber")
    private String phone;

    @Column(name="contract_start_date")
    @JsonProperty("contractStartDate")
    public Date contractStartDate;

    @Column(name = "renewal_date")
    @JsonProperty("renewalDate")
    public Date renewalDate;

    @Column(name = "coverage_type")
    @JsonProperty("coverageType")
    private String coverageType;

    @Column(name = "reimbursement_percentage", precision = 5, scale = 2)
    @JsonProperty("reimbursementPercentage")
    private BigDecimal reimbursementPercentage;

    @Column(name = "payment_frequency")
    @JsonProperty("paymentFrequency")
    private String paymentFrequency;

    @Column(name = "deductible", precision = 10, scale = 2)
    @JsonProperty("deductible")
    private BigDecimal deductible;

    @Column(name = "annual_limit", precision = 10, scale = 2)
    @JsonProperty("annualLimit")
    private BigDecimal annualLimit;

    @Column(name = "reimbursement_method")
    @JsonProperty("reimbursementMethod")
    private String reimbursementMethod;

    @Column(name = "important_exclusions")
    @JsonProperty("importantExclusions")
    private String importantExclusions;

    @Column(name = "coverage_notes")
    @JsonProperty("coverageNotes")
    private String coverageNotes;


}
