package com.uc.jldap.demo;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPJSSESecureSocketFactory;
import com.uc.jldap.demo.security.TrustManager;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-5
 * Time: 下午5:31
 * To change this template use File | Settings | File Templates.
 */
public class LDAPVerifyPasswordDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String ldapHost = "192.168.121.130";
        String loginDN = "cn=admin,dc=ggd543,dc=com";
        String password = "123456";
        String verifyDN = "uid=Miumiu,ou=Tester,dc=ggd543,dc=com";
        String verifyPassword = "111111";

        int ldapPort = LDAPConnection.DEFAULT_SSL_PORT;

        int ldapVersion = LDAPConnection.LDAP_V3;
        LDAPJSSESecureSocketFactory ssf = new LDAPJSSESecureSocketFactory(TrustManager.createSSLSocketFactory());
        LDAPConnection lc = new LDAPConnection(ssf);

        try {
            lc.connect(ldapHost, ldapPort);
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            LDAPAttribute attr = new LDAPAttribute("userPassword", verifyPassword);
            boolean correct = lc.compare(verifyDN, attr);
            System.out.println(correct ? "The password is correct.^_^" : "The password is incorrect.!!!");
        } catch (LDAPException e) {
            e.printStackTrace();
            if (e.getResultCode() == LDAPException.NO_SUCH_OBJECT) {
                System.err.println("Error: No such entry");
            } else if (e.getResultCode() == LDAPException.NO_SUCH_ATTRIBUTE) {
                System.err.println("Error: No such attribute");
            } else {
                System.err.println("Error: " + e.toString());
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error: " + e.toString());
        } finally {
            try {
                if (lc.isConnected()) {
                    lc.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
