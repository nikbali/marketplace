package com.example.polls.dto;


/**
 * DTO объект для Запросов с клиента на авторизацию
 */
public class LoginRequestDTO {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
