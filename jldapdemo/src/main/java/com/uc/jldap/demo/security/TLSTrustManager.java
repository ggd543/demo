/*******************************************************************************
 * $Novell: TLSTrustManager.java,v 1.6 2003/08/21 11:56:19 $
 * Copyright (C) 1999, 2000, 2001 Novell, Inc. All Rights Reserved.
 *
 * THIS WORK IS SUBJECT TO U.S. AND INTERNATIONAL COPYRIGHT LAWS AND
 * TREATIES. USE AND REDISTRIBUTION OF THIS WORK IS SUBJECT TO THE LICENSE
 * AGREEMENT ACCOMPANYING THE SOFTWARE DEVELOPMENT KIT (SDK) THAT CONTAINS
 * THIS WORK. PURSUANT TO THE SDK LICENSE AGREEMENT, NOVELL HEREBY GRANTS TO
 * DEVELOPER A ROYALTY-FREE, NON-EXCLUSIVE LICENSE TO INCLUDE NOVELL'S SAMPLE
 * CODE IN ITS PRODUCT. NOVELL GRANTS DEVELOPER WORLDWIDE DISTRIBUTION RIGHTS
 * TO MARKET, DISTRIBUTE, OR SELL NOVELL'S SAMPLE CODE AS A COMPONENT OF
 * DEVELOPER'S PRODUCTS. NOVELL SHALL HAVE NO OBLIGATIONS TO DEVELOPER OR
 * DEVELOPER'S CUSTOMERS WITH RESPECT TO THIS CODE.
 *
 * $name:           TLSTrustManager.java
 *
 * $description:    The TLSTrustManager.java sample shows how to set up a JSSE
 *                  SSL connection and implement an SSLContext trust manager
 *                  (X509TrustManager). This trust manager is implemented as a
 *                  sub_class called MyTrustManager.MyTrustManager will search
 *                  the keystore for an entry that matches the certificate
 *                  chain. If a match is found the chain is trusted. If no match
 *                  is found the user will be queried with information about the
 *                  unknown chain, to see if the user wants to trust it. If
 *                  trusted the unknown chain is added to the keystore and the
 *                  connection succeeds. If not the connection fails.
 *
 *                  The reason that someone would implement their own trust
 *                  manager is to allow human interaction to decide weather a
 *                  certificate chain should be trusted or not. The default
 *                  trust manager in the SSLContext does not allow this.
 *
 *                  The keystore is the JSSE trusted certificate store.
 *
 *                  See: http://java.sun.com/j2se/1.4/docs/guide/security/jsse/
 *                  JSSERefGuide.html for information on JSSE, SSLContext, and
 *                  trust managers (X509TrustManager).
 *
 *       Note:
 *       eDirectory 8.7 and above support TLS.
 *
 *       This sample uses objects specific to Sun's JSSE provider.
 *       This provider is included with JDK1.4, otherwise you must obtain the
 *       JSSE package from Sun.  This sample must be used with version 1.7 or
 *       later of the Java LDAP NDK.
 *
 ******************************************************************************/
package com.uc.jldap.demo.security;

import com.novell.ldap.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.io.UnsupportedEncodingException;

public class TLSTrustManager {
    public static void main(String[] args) {
        try {

            System.setProperty("ldap.debug", "TraceAll");

            int ldapPort = 6361;
            String ldapHost = "192.168.121.130";
            String loginDN = "cn=admin,dc=ggd543,dc=com";
            String password = "123456";

            // Instantiate MyTrustManager that will handle server certificate
            // chains.
            TrustManager[] tms = {new MyTrustManager()};

            // Create context based on a TLS protocol and a SunJSSE provider.
//            SSLContext context = SSLContext.getInstance("TLS", "SunJSSE");
            SSLContext context = SSLContext.getInstance("TLS");

            // Initialize the SSL context with MyTrustManager.
            // The first parameter - null means use the default key manager.
            // The third parameter - null means use the default value
            // "secure random".
            context.init(null, tms, new SecureRandom());


            // The socket factory must be set before the connection is made.
            // Version 1.6 or later of the NDK must be used in order for this
            // code to compile properly.
            LDAPJSSESecureSocketFactory ssf = new LDAPJSSESecureSocketFactory(context.getSocketFactory());

            // Create an LDAP connection object. Pass in the secure socket.
            LDAPConnection lc = new LDAPConnection(ssf);

            // Connect to the server.
            lc.connect(ldapHost, ldapPort);

            // Authenticate to the server
            lc.bind(LDAPConnection.LDAP_V3, loginDN, password.getBytes("UTF8"));

            // At this point you are connected with a secure connection.
            System.out.println("isTLS: " + lc.isTLS());
            System.out.println("Successful bind using TLS connection.");

            String searchBase = "dc=ggd543,dc=com";
            String searchFilter = "objectclass=*";
            int searchScope = LDAPConnection.SCOPE_SUB;
            int ldapVersion = LDAPConnection.LDAP_V3;
            boolean attributeOnly = false;
            String attrs[] = null;

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

            // Close the connection.
            lc.disconnect();
            System.out.println("Disconnect");

            System.exit(0);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.toString());
        } catch (LDAPException ex) {
            System.out.println("LDAP Error: " + ex.toString());
        } catch (Exception e) {
            System.out.println("main Error: " + e.toString());
            System.exit(1);
        }
    }

    // MyTrustManager
    // This sub_class implements the X509TrustManager interface. MyTrustManager
    // trusts known certificate chains, and queries the user to approve unknown
    // chains. It will add trusted chains to the keystore.

    private static class MyTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            //To change body of implemented methods use File | Settings | File Templates.
        }


        // getAcceptedIssuers retrieves all of the certificates in the keyStore
        // and returns them in an X509Certificate array.
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}