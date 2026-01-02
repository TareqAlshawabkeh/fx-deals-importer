package com.example.fxdeals.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FxDealResponseDTO {

    private Long id;
    private String dealId;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal amount;
    private LocalDateTime dealTimestamp;

    public FxDealResponseDTO() {
    }

    ;
     
    public FxDealResponseDTO(
            Long id,
            String dealId,
            String fromCurrency,
            String toCurrency,
            BigDecimal amount,
            LocalDateTime dealTimestamp
    )
    {
        this.id = id;
        this.dealId = dealId;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.dealTimestamp = dealTimestamp;
    }

    // getters only (response is read-only)
    public Long getId() {
        return id;
    }

    public String getDealId() {
        return dealId;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDealTimestamp() {
        return dealTimestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDealTimestamp(LocalDateTime dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }
}
