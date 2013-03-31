package com.tao.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

public class LoginResultAction extends LookupDispatchAction {

//    public ActionForward execute(ActionMapping mapping, ActionForm form,
//                                 HttpServletRequest request, HttpServletResponse response) throws IOException {
//        PrintWriter pw = response.getWriter();
//        request.setAttribute("info", "nice to meet you");
//        pw.append("good to see you again");
//        return null;
//    }

    public ActionForward success(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.print("success");
        return null;
    }

    public ActionForward failure(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        out.print("failure");
        return null;
    }

    @Override
    protected Map getKeyMethodMap() {
        System.out.println("getKeyMethodMap");
        Map map = new HashMap();
        map.put("button.failue","failure");
        map.put("button.success","success");
        return map;
    }
}