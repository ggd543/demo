package com.carver.tool;

import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlCheckBoxInput;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlImageInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

/**
 * µÇÂ¼ÌÔ±¦Íø»ñÈ¡ÊÚÈ¨¡£
 *
 * @author carver.gu
 * @since 1.0, Nov 11, 2009
 */
public class LoginUtil {

    private static final String ONLINE_CONTAINER = "http://container.open.taobao.com/container?appkey=";
    private static final Pattern P_SESSION = Pattern.compile("top\\_session=(\\w+?)&");

    static {
        Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.SEVERE);
        Logger.getLogger("org.apache.commons.httpclient.HttpMethodBase").setLevel(Level.SEVERE);
    }

    public static void main(String[] args) throws Exception {
        String session = getOnlineSession("app_key", "ggd543", "4phvjs");
        System.out.println("session_key: " + session);
    }

    public static String getOnlineSession(String appkey, String uid, String pwd) throws Exception {
        String url = "http://member1.taobao.com/member/mini_login.htm?login_type=3&redirect_url=";
        return getSession(url, ONLINE_CONTAINER, appkey, uid, pwd);
    }

    private static String getSession(String loginUrl, String topUrl, String appkey, String uid,
            String pwd) throws Exception {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3);

        String fullUrl = loginUrl + URLEncoder.encode(topUrl + appkey, "utf-8");

        System.out.println("fullUrl: "+fullUrl);

        HtmlPage loginPage = webClient.getPage(fullUrl);
        HtmlForm loginForm = loginPage.getForms().get(0);
        HtmlTextInput uidInput = loginForm.getInputByName("TPL_username");
        uidInput.setValueAttribute(uid);
        HtmlPasswordInput pwdInput = loginForm.getInputByName("TPL_password");
        pwdInput.setValueAttribute(pwd);
        HtmlButton loginButton = loginForm.getButtonByName("");

        HtmlPage loginRsp = null;
        try {
            Page rsp = loginButton.click();
            if (rsp instanceof HtmlPage) {
                loginRsp = (HtmlPage) rsp;
            } else if (rsp instanceof TextPage) {
                TextPage textRsp = (TextPage) rsp;
                return extractSession(textRsp.getContent());
            } else {
                return null;
            }
        } catch (FailingHttpStatusCodeException e) {
            if (e.getStatusCode() == 404) {
                return extractSession(e.getMessage());
            }
        } catch (Exception e) {
        }

        HtmlCheckBoxInput agreeCheck = (HtmlCheckBoxInput) loginRsp.getElementById("agreement");
        if (agreeCheck == null) {
            return extractSession(loginRsp.getWebResponse().getRequestSettings().getUrl().toString());
        } else {
            agreeCheck.click();
        }

        HtmlForm agreeForm = loginRsp.getForms().get(1);
        List<HtmlElement> inputElements = agreeForm.getHtmlElementsByTagName("input");
        HtmlImageInput agreeButton = null;
        for (HtmlElement inputElement : inputElements) {
            if (inputElement instanceof HtmlImageInput) {
                agreeButton = (HtmlImageInput) inputElement;
                break;
            }
        }

        Page agreeRsp = null;
        try {
            agreeRsp = agreeButton.click();
        } catch (FailingHttpStatusCodeException e) {
            if (e.getStatusCode() == 404) {
                return extractSession(e.getMessage());
            }
        } catch (Exception e) {
        }
        return extractSession(agreeRsp.getWebResponse().getRequestSettings().getUrl().toString());
    }

    private static String extractSession(String response) {
        Matcher matcher = P_SESSION.matcher(response);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }

}