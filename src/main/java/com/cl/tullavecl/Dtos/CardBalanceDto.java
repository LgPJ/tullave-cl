package com.cl.tullavecl.Dtos;

import java.math.BigDecimal;

public class CardBalanceDto {

    private String card;
    private BigDecimal balance;
    private String balanceDate;
    private BigDecimal virtualBalance;
    private String virtualBalanceDate;

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
}
