package com.ggd543.portlet;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * User: ¡ı”¿Ω°
 * Date: 12-1-12
 * Time: œ¬ŒÁ11:04
 * To change this template use File | Settings | File Templates.
 */
public class HelloworldPortlet extends GenericPortlet {
    @Override
    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("Hello Portlet");
    }
}
