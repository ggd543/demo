package com.uc.jldap.demo;

import java.io.UnsupportedEncodingException;

import com.novell.ldap.*;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-8-1 Time: 下午6:13 To change this template use File | Settings
 * | File Templates.
 */
public class JLDAPSearchDemo {
    
    public static void main(String[] args) {
        int ldapPort = LDAPConnection.DEFAULT_PORT;
        int searchScope = LDAPConnection.SCOPE_SUB;
        int ldapVersion = LDAPConnection.LDAP_V3;
        boolean attributeOnly = false;
        String attrs[] = null;
        String ldapHost = "192.168.121.130";
        // String ldapHost = "localhost";
        String loginDN = "cn=admin,dc=ucweb,dc=com";
        String password = "123456";
        String searchBase = "dc=ucweb,dc=com";
        // String searchFilter = "cn=test1";
        // String searchFilter = null;
        // String searchFilter = "(&(objectClass=*)(cn=test2))";
        String searchFilter = "(&(objectclass=*))";
        // System.setProperty("ldap.debug", "TraceAll");
        
        LDAPConnection lc = new LDAPConnection();
        
        try {
            
            // connect to the server
            lc.connect(ldapHost, ldapPort);
            System.out.println("isConnect: " + lc.isConnected());
            System.out.println("isConnectActive: " + lc.isConnectionAlive());
            
            System.out.println("isTLS: " + lc.isTLS());
            
            // bind to the server
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            // System.exit(0);
            LDAPSearchResults searchResults;
            // LDAPSearchResults searchResults = lc.search(searchBase, // container to search
            // searchScope, // search scope
            // searchFilter, // search filter
            // attrs, // "1.1" returns entry name only
            // attributeOnly); // no attributes are returned
            // System.out.println(searchResults);
            // System.out.println(searchResults.getCount());
            System.out.println();
            System.out.println();
            
            LDAPSearchConstraints constraints = new LDAPSearchConstraints();
            constraints.setBatchSize(50);
            constraints.setMaxResults(100000);
            searchResults = lc.search(searchBase, // container to search
                    searchScope, // search scope
                    searchFilter, // search filter
                    attrs, // "1.1" returns entry name only
                    attributeOnly, constraints);
            
            System.out.println(" --- " + searchResults.getCount() + " --- ");
            System.out.println();
            // print out all the objects
            while (searchResults.hasMore()) {
                LDAPEntry nextEntry = null;
                try {
                    nextEntry = searchResults.next();
                    System.out.println("dn: " + nextEntry.getDN());
                    System.out.println("attribute set: " + nextEntry.getAttributeSet());
                    LDAPAttribute cnAttr = nextEntry.getAttribute("cn");
                    // System.out.println("name: " + cnAttr.getName() + " baseName: " + cnAttr.getBaseName()
                    // + " string value: " + cnAttr.getStringValue());
                    System.out.println("password: " + nextEntry.getAttribute("userPassword"));
                } catch (LDAPException e) {
                    e.printStackTrace();
                    // Exception is thrown, go for next entry
                    continue;
                }
                System.out.println(searchResults.getCount());
            }
            System.exit(0);
            System.out.println("after : " + searchResults.getCount() + " " + searchResults.hasMore());
            System.out.println();
            LDAPSearchConstraints constraints2 = new LDAPSearchConstraints();
            constraints2.setBatchSize(0);
            constraints2.setMaxResults(20);
            searchResults = lc.search(searchBase, // container to search
                    searchScope, // search scope
                    searchFilter, // search filter
                    attrs, // "1.1" returns entry name only
                    attributeOnly, constraints2);
            // Thread.sleep(1000L);
            // System.out.println(searchResults.getCount() + " " + searchResults.hasMore());
            // System.out.println(searchResults.getCount() + " " + searchResults.hasMore());
            System.out.println(searchResults.getCount());
            System.out.println(searchResults.getCount());
            Thread.sleep(3000L);
            System.out.println(searchResults.getCount());
            System.out.println(searchResults.next());
            Thread.sleep(5000L);
            System.out.println(searchResults.getCount() + " " + searchResults.hasMore());
            System.out.println(searchResults.getCount() + " " + searchResults.hasMore());
            
        } catch (LDAPException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
        } finally {
            
            // disconnect with the server
            try {
                lc.disconnect();
            } catch (LDAPException e) {
                e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
            }
            
        }
        System.exit(0);
    }
}
