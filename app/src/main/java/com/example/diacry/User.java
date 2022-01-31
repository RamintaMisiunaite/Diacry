package com.example.diacry;

public class User {
    private String username;
    private String email;
    private String psw;

    public User(){
        // required empty constructor
    }

    public User(String username, String email, String psw) {
        this.username = username;
        this.email = email;
        this.psw = psw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
