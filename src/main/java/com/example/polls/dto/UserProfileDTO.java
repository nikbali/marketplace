package com.example.polls.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

public class UserProfileDTO {
    private Long id;
    private String login;
    private String name;
    private Long cardNumber;
    private BigDecimal balance;

    public UserProfileDTO(Long id,
                       String login,
                       String name,
                       Long cardNumber,
                       BigDecimal balance) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }
    public UserProfileDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
