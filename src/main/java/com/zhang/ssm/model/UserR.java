package com.zhang.ssm.model;

/**
 * @ClassName UserR
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/17 10:51
 * @Version 1.0
 **/
public class UserR {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private Boolean isDeleted;
    private Integer userAge;

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        try{
            byte b[] = userName.getBytes("ISO-8859-1");
            userName = new String(b,"UTF-8");
            return userName;
        }
        catch(Exception e)
        {
            return userName;
        }

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
