package com.uc.jldap.demo;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPJSSESecureSocketFactory;
import com.uc.jldap.demo.security.TrustManager;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-5
 * Time: 下午5:15
 * To change this template use File | Settings | File Templates.
 */
public class LDAPDeleteDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String ldapHost = "192.168.121.130";
        String loginDN = "cn=admin,dc=ggd543,dc=com";
        String password = "123456";
        String deleteDN = "cn=test3,dc=ggd543,dc=com";

//        int ldapPort = LDAPConnection.DEFAULT_PORT;
        int ldapPort = LDAPConnection.DEFAULT_SSL_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;
        LDAPJSSESecureSocketFactory ssf = new LDAPJSSESecureSocketFactory(TrustManager.createSSLSocketFactory());
        LDAPConnection lc = new LDAPConnection(ssf);
        try {
            lc.connect(ldapHost, ldapPort);
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));

            lc.delete(deleteDN);
            System.out.println(" delete Entry: " + deleteDN + " success.");
            lc.disconnect();
        } catch (LDAPException e) {
            if (e.getResultCode() == LDAPException.NO_SUCH_OBJECT) {
                System.err.println("Error: No such object");
            } else if (e.getResultCode() == LDAPException.INSUFFICIENT_ACCESS_RIGHTS) {
                System.err.println("Error: Insufficient rights");
            } else {
                System.err.println("Error: " + e.toString());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
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
