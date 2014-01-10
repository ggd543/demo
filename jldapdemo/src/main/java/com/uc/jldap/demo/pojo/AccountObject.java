package com.uc.jldap.demo.pojo;

public class AccountObject {
    
    private Account account;
    /**
     * 密码
     */
    @Attribute("userPassword")
    private String password;



    public AccountObject() {
    }
    
    public AccountObject(Account account, String password) {
        this.account = account;
        this.password = password;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Account getAccount() {
        return account;
    }
}
