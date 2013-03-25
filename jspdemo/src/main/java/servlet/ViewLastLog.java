package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.html.HTMLLayout;
import ch.qos.logback.classic.html.UrlCssBuilder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.read.CyclicBufferAppender;
import utils.Constants;


public class ViewLastLog extends HttpServlet {


    private Logger logger = LoggerFactory.getLogger(ViewLastLog.class);

    private CyclicBufferAppender<ILoggingEvent> cyclicBufferAppender;

    private HTMLLayout layout;

    /**
     * 日期 线程 日志级别 logger所在的类 用户ID 日志信息
     */
    private static String PATTERN = "%d%thread%level%logger{25}%mdc{" + Constants.USERID_MDC_KEY + "}%msg";

    @Override
    public void init() throws ServletException {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        initialize(lc);
        logger.debug("init completed");
        super.init();
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter output = resp.getWriter();

        output.append(layout.getFileHeader());
        String localRef = req.getContextPath();
        output.append("<h2>Last logging events</h2>");
        output.append("<table class=\"nav\">");
        output.append("<tr><td class=\"sexy\"><a href=\"" + localRef
                + "/index.jsp\" class=\"sexy\">Main Page</a></td></tr>");
        output
                .append("<tr><td class=\"sexy\"><a href=\"#bottom\" class=\"sexy\">Jump to bottom</a></td></tr>");
        output.append("</table>");

        output.append("<div class=\"content_full\">");
        output.append(layout.getPresentationHeader());

        printLogs(output);

        output.append(layout.getPresentationFooter());

        output.append("<a name=\"bottom\" />");

        output.append("</div>");

        output.append(layout.getFileFooter());

        output.flush();
        output.close();
    }

    private void printLogs(PrintWriter output) {
        int count = cyclicBufferAppender.getLength();

        if (count == 0) {
            output.append("<tr><td>No logging events to display</td></tr>\r\n");
        } else {
            for (int i = 0; i < count; i++) {
                LoggingEvent le = (LoggingEvent) cyclicBufferAppender.get(i);
                output.append(layout.doLayout(le) + "\r\n");
            }
        }
    }

    private void initialize(LoggerContext context) {
        logger.debug("Initializing ViewLastLog Servlet");
        cyclicBufferAppender = (CyclicBufferAppender<ILoggingEvent>) context.getLogger(Logger.ROOT_LOGGER_NAME)
                .getAppender(Constants.CYCLIC_BUFFER_APPENDER_NAME);
        layout = new HTMLLayout();
        layout.setContext(context);
        UrlCssBuilder cssBuilder = new UrlCssBuilder();
        cssBuilder.setUrl(getServletContext().getContextPath() + "/css/pk.css");
        layout.setCssBuilder(cssBuilder);
        layout.setPattern(PATTERN);
        layout.setTitle("Last Logging Events");
        layout.start();
    }

}
