package com.example.fxdeals.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FxDealRequestDTO {

    @NotBlank(message = "dealId is required")
    private String dealId;

    @NotBlank(message = "fromCurrency is required")
    @Size(min = 3, max = 3, message = "fromCurrency must be 3 characters")
    private String fromCurrency;

    @NotBlank(message = "toCurrency is required")
    @Size(min = 3, max = 3, message = "toCurrency must be 3 characters")
    private String toCurrency;

    @NotNull(message = "amount is required")
    @Positive(message = "amount must be positive")
    private BigDecimal amount;

    @NotNull(message = "dealTimestamp is required")
    private LocalDateTime dealTimestamp;

    // -------- getters & setters --------

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(LocalDateTime dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }
}
