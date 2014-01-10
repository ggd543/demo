package com.uc.jldap.demo;

import java.io.UnsupportedEncodingException;

import com.novell.ldap.*;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-8-1 Time: 下午6:13 To change this template use File | Settings
 * | File Templates.
 */
public class ALLSearchDemo {
    
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
        String searchFilter = null;
        // String searchFilter = "(&(objectClass=*)(cn=test2))";
        
        // System.setProperty("ldap.debug", "TraceAll");
        
        LDAPConnection lc = new LDAPConnection();
        long t1=0,t2=0,t3=0;
        try {
            
            // connect to the server
            lc.connect(ldapHost, ldapPort);
            
            // bind to the server
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            // System.exit(0);
            LDAPSearchResults searchResults;
            
            LDAPSearchConstraints constraints = new LDAPSearchConstraints();
            constraints.setBatchSize(100);
            constraints.setMaxResults(10000);

           t1 = System.nanoTime();
            searchResults = lc.search(searchBase, // container to search
                    searchScope, // search scope
                    searchFilter, // search filter
                    attrs, // "1.1" returns entry name only
                    attributeOnly, constraints);
            t2 = System.nanoTime();
            System.out.println(" --- " + searchResults.getCount() + " --- "+(t2-t1)/1000000+" ms");

            System.out.println();
            int total=0;
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
                    if (e.getResultCode() == LDAPException.SIZE_LIMIT_EXCEEDED){
                        t3= System.nanoTime();
                        System.out.println("total time: "+(t3-t1)/1000000+" ms");
                        continue;
                    }else{
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("count: "+searchResults.getCount()+" total: "+(++total));
            }
        } catch (LDAPException e) {

            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
        } finally {
            // disconnect with the server
            try {
                lc.disconnect();
            } catch (LDAPException e) {
                e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
