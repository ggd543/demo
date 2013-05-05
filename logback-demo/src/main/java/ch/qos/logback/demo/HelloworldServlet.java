package ch.qos.logback.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloworldServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(HelloworldServlet.class);
    private String msg;

    @Override
    public void init() throws ServletException {
        msg = getServletConfig().getInitParameter("MSG");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("before write to output stream ... ");
        PrintWriter pw = resp.getWriter();
        pw.println(msg);
        logger.info("after write to output stream ... ");
        pw.flush();
    }

}