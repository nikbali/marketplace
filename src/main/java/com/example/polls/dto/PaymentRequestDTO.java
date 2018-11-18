package com.example.polls.dto;

import java.math.BigInteger;

public class PaymentRequestDTO {

    private String login;
    private ItemOrderDTO product;
    private CardOwnerDTO cardInfo;

    public PaymentRequestDTO(final String login) {
        this.login = login;
    }

    public PaymentRequestDTO(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public ItemOrderDTO getProduct() {
        return product;
    }

    public void setProduct(ItemOrderDTO product) {
        this.product = product;
    }

    public CardOwnerDTO getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardOwnerDTO cardInfo) {
        this.cardInfo = cardInfo;
    }
}
