package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;

public class SaleRequest {
    private Long clientId;
    private Long sellerId;
    private BigDecimal total;
    private List<SalesTransactionRequest> transactions;

    // Getters and Setters
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<SalesTransactionRequest> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<SalesTransactionRequest> transactions) {
        this.transactions = transactions;
    }
}

