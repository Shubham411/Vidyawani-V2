package com.example.vidyawani2;

public class User {
    String name,mobile,mail,pass;

    public User() {
    }

    public User(String name, String mobile, String mail, String pass) {
        this.name = name;
        this.mobile = mobile;
        this.mail = mail;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
