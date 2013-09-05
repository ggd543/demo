package com.uc.jldap.demo;

import com.novell.ldap.*;
import com.uc.jldap.demo.security.TrustManager;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-5
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class JLDAPAddDemo {
    public static void main(String[] args) {
        String ldapHost = "192.168.121.130";
        String loginDN =  "cn=admin,dc=ggd543,dc=com";
        String password = "123456";
        String containerName = "dc=ggd543,dc=com";

        int ldapPort = LDAPConnection.DEFAULT_SSL_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;

        LDAPJSSESecureSocketFactory ssf = new LDAPJSSESecureSocketFactory(TrustManager.createSSLSocketFactory());
        LDAPConnection lc = new LDAPConnection(ssf);

        LDAPAttributeSet attributeSet = new LDAPAttributeSet();

        attributeSet.add(new LDAPAttribute("objectclass", new String[]{new String("top"), new String("person")}));
        attributeSet.add(new LDAPAttribute("cn", "test3"));
        attributeSet.add(new LDAPAttribute("sn", "test3"));
//        attributeSet.add(new LDAPAttribute("mail", "test3@ucweb.com"));
        attributeSet.add(new LDAPAttribute("userPassword", "111111"));
        String dn = "cn=test3,"+containerName;
        LDAPEntry newEntry = new LDAPEntry(dn, attributeSet);

        try {
            lc.connect(ldapHost, ldapPort);
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            System.out.println("login ldap server successfully.");
            lc.add(newEntry);
            System.out.println("Added object: " + dn + " successfully.");

        } catch (LDAPException e) {
            e.printStackTrace();
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
