package com.tao.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tao.struts.form.LoginForm;
import org.apache.struts.actions.DispatchAction;

public class LoginAction extends DispatchAction {

    public ActionForward submit(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getAttribute("loginForm"));
        System.out.println(request.getSession().getAttribute("loginForm"));

        LoginForm loginForm = (LoginForm) form;
        String forwardName = "next";
        System.out.println(loginForm.getUsername());
        System.out.println(loginForm.getPassword());
        return mapping.findForward(forwardName);
    }

    public ActionForward method1(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        System.out.println("method1");
        System.out.println("error.message: "+messages.getMessage("error.message"));
        ActionForward actionForward = mapping.findForward("fuxk");
        if (actionForward == null){
            actionForward = new ActionForward();
        }
        actionForward.setProperty("fuxk", "hello fuxk");
        actionForward.setRedirect(true);
        actionForward.setPath("/hello.html");
        return actionForward;
    }

    public ActionForward method2(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        System.out.println("method2");
        return mapping.findForward("next");
    }
}