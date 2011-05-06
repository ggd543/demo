package servlet;

import jsee.demo1.ScriptCache;

import javax.script.ScriptContext;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 2010-10-4
 * Time: 9:18:48
 * To change this template use File | Settings | File Templates.
 */
public class JSServlet extends HttpServlet {
    private String cacheControlHeader;
    private String contentTypeHeader;
    private ScriptCache scriptCache;

    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        cacheControlHeader = config.getInitParameter("Cache-Control");
        contentTypeHeader = config.getInitParameter("Content-Type");
        int maxCachedScripts = Integer.parseInt(
                config.getInitParameter("Max-Cached-Scripts"));
        scriptCache = new ScriptCache(maxCachedScripts) {
            public File getScriptFile(String uri) {
                return new File(getServletContext().getRealPath(uri));
            }
        };
    }

    protected ScriptContext createScriptContext(
            HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ScriptContext scriptContext = new SimpleScriptContext();
        scriptContext.setWriter(response.getWriter());
        int scope = ScriptContext.ENGINE_SCOPE;
        scriptContext.setAttribute("config", getServletConfig(), scope);
        scriptContext.setAttribute("application", getServletContext(), scope);
        scriptContext.setAttribute("session", request.getSession(), scope);
        scriptContext.setAttribute("request", request, scope);
        scriptContext.setAttribute("response", response, scope);
        scriptContext.setAttribute("out", response.getWriter(), scope);
        scriptContext.setAttribute("factory",
                scriptCache.getEngine().getFactory(), scope);
        return scriptContext;
    }

    protected void runScript(String uri, ScriptContext scriptContext)
            throws ScriptException, IOException {
        scriptCache.getScript(uri).eval(scriptContext);
    }

    protected void handleRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (cacheControlHeader != null)
            response.setHeader("Cache-Control", cacheControlHeader);
        if (contentTypeHeader != null)
            response.setContentType(contentTypeHeader);
        ScriptContext scriptContext = createScriptContext(request, response);
        try {
            runScript("/init.jss", scriptContext);
//            String uri = request.getServletPath();
            String uri = request.getRequestURI();
            uri = uri.substring(request.getContextPath().length());
            try {
                runScript(uri, scriptContext);
            } catch (FileNotFoundException x) {
                response.sendError(404, request.getRequestURI());
            }
            runScript("/finalize.jss", scriptContext);
        } catch (ScriptException x) {
            x.printStackTrace(response.getWriter());
            throw new ServletException(x);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }
}
