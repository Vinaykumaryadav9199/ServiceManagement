package com.Abc.ServiceManagement.Dto;
public class LoginRequestDto {

    private String emailOrUserId;
    private String password;

    public LoginRequestDto() {
    }

    public LoginRequestDto(String emailOrUserId, String password) {
        this.emailOrUserId = emailOrUserId;
        this.password = password;
    }

    public String getEmailOrUserId() {
        return emailOrUserId;
    }

    public void setEmailOrUserId(String emailOrUserId) {
        this.emailOrUserId = emailOrUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

