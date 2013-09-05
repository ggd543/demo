package com.uc.jldap.demo;

import com.novell.ldap.*;
import com.novell.ldap.client.Debug;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-1
 * Time: 下午6:13
 * To change this template use File | Settings | File Templates.
 */
public class JLDAPSearchDemo {

    public static void main(String[] args){
        int ldapPort = LDAPConnection.DEFAULT_PORT;
        int searchScope = LDAPConnection.SCOPE_SUB;
        int ldapVersion = LDAPConnection.LDAP_V3;
        boolean attributeOnly = false;
        String attrs[] = null;
        String ldapHost = "192.168.121.130";
//        String ldapHost = "localhost";
        String loginDN = "cn=admin,dc=ggd543,dc=com";
        String password = "123456";
        String searchBase = "dc=ggd543,dc=com";
        String searchFilter = "objectclass=*";

        System.setProperty("ldap.debug", "TraceAll");

        LDAPConnection lc = new LDAPConnection();

        try {

            // connect to the server
            lc.connect(ldapHost, ldapPort);
            System.out.println("isConnect: "+lc.isConnected());
            System.out.println("isConnectActive: "+lc.isConnectionAlive());

            System.out.println("isTLS: "+lc.isTLS());

            // bind to the server
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
//            System.exit(0);
            LDAPSearchResults searchResults = lc.search(searchBase, // container to search
                    searchScope, // search scope
                    searchFilter, // search filter
                    attrs, // "1.1" returns entry name only
                    attributeOnly); // no attributes are returned
            System.out.println(searchResults);
            // print out all the objects
            while (searchResults.hasMore()) {
                LDAPEntry nextEntry = null;
                try {
                    nextEntry = searchResults.next();
                    System.out.println("dn: " + nextEntry.getDN());
                    System.out.println("attribute set: " + nextEntry.getAttributeSet());
                } catch (LDAPException e) {
                    e.printStackTrace();
                    // Exception is thrown, go for next entry
                    continue;
                }
            }

        } catch (LDAPException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {

            // disconnect with the server
            try {
                lc.disconnect();
            } catch (LDAPException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
        System.exit(0);
    }
}
