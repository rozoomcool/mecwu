package ru.mecwu.core.model;

public class AuthenticateRequestDTO {
    private String emailOrNickName;
    private String password;

    public AuthenticateRequestDTO(String emailOrNickName, String password) {
        this.emailOrNickName = emailOrNickName;
        this.password = password;
    }

    public String getEmailOrNickName() {
        return emailOrNickName;
    }

    public void setEmailOrNickName(String emailOrNickName) {
        this.emailOrNickName = emailOrNickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
