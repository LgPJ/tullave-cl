package com.cl.tullavecl.Dtos;

import java.math.BigDecimal;

public class ResponseCardDto {

    private String userName;
    private String userLastName;
    private BigDecimal virtualBalance;
    private BigDecimal balance;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public BigDecimal getVirtualBalance() {
        return virtualBalance;
    }

    public void setVirtualBalance(BigDecimal virtualBalance) {
        this.virtualBalance = virtualBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
