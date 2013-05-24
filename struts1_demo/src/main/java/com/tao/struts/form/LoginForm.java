package com.tao.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

@SuppressWarnings("serial")
public class LoginForm extends ActionForm {
    private String username;

    private String password;

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (!("admin".equals(username) && "123456".equals(password))) {
            ActionMessage am = new ActionMessage("error.message");
            errors.add("error.hint", am);
//            System.out.println("error ....");
        }
        return errors;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("set username : " + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("set password: " + password);
        this.password = password;
    }
}