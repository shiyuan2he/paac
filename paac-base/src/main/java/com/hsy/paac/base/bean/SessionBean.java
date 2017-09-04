package com.hsy.paac.base.bean;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.bean
 * @date 01/09/2017 1:10 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class SessionBean {
    private String tel ;
    private String userName ;
    private String userPassword ;

    public SessionBean() {}

    public SessionBean(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserName() {
        return userName;
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
}
