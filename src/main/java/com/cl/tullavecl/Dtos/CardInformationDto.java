package com.cl.tullavecl.Dtos;

public class CardInformationDto {

    private String cardNumber;
    private String profileCode;
    private String profile;
    private String profile_es;
    private String bankCode;
    private String bankName;
    private String userName;
    private String userLastName;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getProfileCode() {
        return profileCode;
    }

    public void setProfileCode(String profileCode) {
        this.profileCode = profileCode;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile_es() {
        return profile_es;
    }

    public void setProfile_es(String profile_es) {
        this.profile_es = profile_es;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

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
}
