package com.example.polls.dto;

import javax.validation.constraints.*;


/**
 * DTO с клиента для регистрации
 */
public class SignUpRequestDTO {

    @Size(min = 3, max = 15)
    private String login;

    @Size(min = 6, max = 20)
    private String password;

    @Size(min = 4, max = 40)
    private String name;

    private Long cardNumber;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
