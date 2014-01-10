/*******************************************************************************
 * $Novell: SSLConnection.java,v 1.24 2006/02/03 06:14:06 $
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
 * $name:           SSLConnection.java
 * $description:    The SSLConnection.java sample shows how to set up a secure
 *                  SSL connection
 *
 * It is necessary to have an SSL package in your class path to run this
 * program. You can use JSSE, a Security provider implemented by Sun.  
 * Documentation is available from the NDK to set up Java SSL on a client.
 *
 * This example shows dynamic (run-time) configuration for JSSE provider
 * and for identification of keystores of trusted Certificates.
 ******************************************************************************/
package com.uc.jldap.demo.security;

import com.novell.ldap.*;

import java.security.Security;
import java.io.UnsupportedEncodingException;

public class SSLConnection {
    public static void main(String[] args) {
        System.setProperty("ldap.debug", "TraceAll");
        int ldapPort = LDAPConnection.DEFAULT_SSL_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;
        String ldapHost = "192.168.121.130";
        String loginDN = "cn=admin,dc=ggd543,dc=com";
        String password = "123456";
        String path =  SSLConnection.class.getResource("/openldap.jks").getPath();
        System.out.println("jks_path: "+path);
        LDAPSocketFactory ssf;

        try {
            // Dynamically set JSSE as a security provider
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            // Dynamically set the property that JSSE uses to identify
            // the keystore that holds trusted root certificates
            System.setProperty("javax.net.ssl.trustStore", path);

            ssf = new LDAPJSSESecureSocketFactory();

            // Set the socket factory as the default for all future connections
//            LDAPConnection.setSocketFactory(ssf);

            // Note: the socket factory can also be passed in as a parameter
            // to the constructor to set it for this connection only.
            LDAPConnection lc = new LDAPConnection(ssf);

            // connect to the server
            lc.connect(ldapHost, ldapPort);

            // authenticate to the server
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF-8"));

            System.out.println("isTLS: "+lc.isTLS());
            // at this point you are connected with a secure connection
            System.out.println("Successful SSL bind with server.");

            String searchBase = "dc=ggd543,dc=com";
            String searchFilter = "objectclass=*";
            int searchScope = LDAPConnection.SCOPE_SUB;
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


            lc.disconnect();
        } catch (LDAPException e) {
            System.out.println("Error: " + e.toString());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.toString());
        }
    }

}
