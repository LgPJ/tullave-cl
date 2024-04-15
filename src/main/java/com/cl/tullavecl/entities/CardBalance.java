package com.cl.tullavecl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards_balances")
public class CardBalance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String card;
    private BigDecimal balance;
    private String balanceDate;
    private BigDecimal virtualBalance;
    private String virtualBalanceDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

    public BigDecimal getVirtualBalance() {
        return virtualBalance;
    }

    public void setVirtualBalance(BigDecimal virtualBalance) {
        this.virtualBalance = virtualBalance;
    }

    public String getVirtualBalanceDate() {
        return virtualBalanceDate;
    }

    public void setVirtualBalanceDate(String virtualBalanceDate) {
        this.virtualBalanceDate = virtualBalanceDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
