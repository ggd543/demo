package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 2010-10-4
 * Time: 11:22:58
 * To change this template use File | Settings | File Templates.
 */
public class DemoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        ServletContext sc = this.getServletContext();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String url = req.getRequestURL().toString();
        String uri = req.getRequestURI();
        pw.println("contextPath: " + contextPath);
        pw.println("servletPath: " + servletPath);
        pw.println("uri: " + uri);
        pw.println("url: " + url);
        pw.println("The absolute path of sexy1.jpg: " + sc.getRealPath("/img/sexy1.jpg"));
        pw.println("The absolute path of " + servletPath + ": " + sc.getRealPath(servletPath));
        pw.flush();
        pw.close();
    }
}
