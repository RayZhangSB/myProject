package com.zhang.ssm.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userSalt;

    private String userHeadurl;

    private String userPosition;

    private String userWorkgroup;

    private Date userCreateddate;

    private Integer userAge;

    private String userEmail;

    private String userPhone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt == null ? null : userSalt.trim();
    }

    public String getUserHeadurl() {
        return userHeadurl;
    }

    public void setUserHeadurl(String userHeadurl) {
        this.userHeadurl = userHeadurl == null ? null : userHeadurl.trim();
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition == null ? null : userPosition.trim();
    }

    public String getUserWorkgroup() {
        return userWorkgroup;
    }

    public void setUserWorkgroup(String userWorkgroup) {
        this.userWorkgroup = userWorkgroup == null ? null : userWorkgroup.trim();
    }

    public Date getUserCreateddate() {
        return userCreateddate;
    }

    public void setUserCreateddate(Date userCreateddate) {
        this.userCreateddate = userCreateddate;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }
}