package com.tao.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tao.struts.form.LoginForm;

public class LoginAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		LoginForm loginForm = (LoginForm) form;
		String forward = null;
		System.out.println("===========");
		System.out.println(loginForm.getUsername());
		System.out.println(loginForm.getPassword());
		if ("Tao".toLowerCase().equals(loginForm.getUsername().toLowerCase())
				&& "123".equals(loginForm.getPassword())) {
			forward = "success";
		} else {
			forward = "failure";
		}
		return mapping.findForward(forward);
	}
}