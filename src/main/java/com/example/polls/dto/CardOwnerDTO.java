package com.example.polls.dto;

import java.math.BigInteger;

public class CardOwnerDTO {

    private BigInteger cardNumber;
    private Integer cvc;
    private String mmyy;
    private String ownerName;
    private String phoneNumber;

    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    public String getMmyy() {
        return mmyy;
    }

    public void setMmyy(String mmyy) {
        this.mmyy = mmyy;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CardOwnerDTO(BigInteger cardNumber, Integer cvc, String mmyy, String ownerName, String phoneNumber) {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.mmyy = mmyy;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
    }
    public CardOwnerDTO(){}

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }
}
