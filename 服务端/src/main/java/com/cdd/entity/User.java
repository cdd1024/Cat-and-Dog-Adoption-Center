package com.cdd.entity;

public class User {
    private Integer userId;
    private String userA;
    private Integer userPwd;
    private String shenfen;
    private String phone;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userA='" + userA + '\'' +
                ", userPwd=" + userPwd +
                ", shenfen='" + shenfen + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserA() {
        return userA;
    }

    public void setUserA(String userA) {
        this.userA = userA;
    }

    public Integer getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(Integer userPwd) {
        this.userPwd = userPwd;
    }

    public String getShenfen() {
        return shenfen;
    }

    public void setShenfen(String shenfen) {
        this.shenfen = shenfen;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
