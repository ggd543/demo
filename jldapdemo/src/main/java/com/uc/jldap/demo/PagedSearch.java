// Warning: This code has been marked up for HTML

/*******************************************************************************
 * 
 * Copyright (C) 2008 Novell, Inc. All Rights Reserved.
 * 
 * THIS WORK IS SUBJECT TO U.S. AND INTERNATIONAL COPYRIGHT LAWS AND TREATIES. USE AND REDISTRIBUTION OF THIS WORK IS
 * SUBJECT TO THE LICENSE AGREEMENT ACCOMPANYING THE SOFTWARE DEVELOPMENT KIT (SDK) THAT CONTAINS THIS WORK. PURSUANT TO
 * THE SDK LICENSE AGREEMENT, NOVELL HEREBY GRANTS TO DEVELOPER A ROYALTY-FREE, NON-EXCLUSIVE LICENSE TO INCLUDE
 * NOVELL'S SAMPLE CODE IN ITS PRODUCT. NOVELL GRANTS DEVELOPER WORLDWIDE DISTRIBUTION RIGHTS TO MARKET, DISTRIBUTE, OR
 * SELL NOVELL'S SAMPLE CODE AS A COMPONENT OF DEVELOPER'S PRODUCTS. NOVELL SHALL HAVE NO OBLIGATIONS TO DEVELOPER OR
 * DEVELOPER'S CUSTOMERS WITH RESPECT TO THIS CODE.
 * 
 * $name: PagedSearch.java $description: The PagedSearch.java example returns all the entries in the specified container
 * (search base). All attributes and values are printed. If some attribute values are not printable, they will be base64
 * encoded. The search is done using simple paging mechanism.
 ******************************************************************************/
package com.uc.jldap.demo;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;

import com.novell.ldap.*;
import com.novell.ldap.LDAPControl;
import com.novell.ldap.controls.LDAPPagedResultsControl;
import com.novell.ldap.controls.LDAPPagedResultsResponse;
import com.novell.ldap.util.Base64;

public class PagedSearch {
    public static void main(String[] args)
    {
        
        int ldapPort = LDAPConnection.DEFAULT_PORT;
        int searchScope = LDAPConnection.SCOPE_ONE;
        int ldapVersion = LDAPConnection.LDAP_V3;
        String ldapHost = "192.168.121.130";
        String loginDN = "cn=admin,dc=ucweb,dc=com";
        String password = "123456";
        String searchBase = "dc=ucweb,dc=com";
        String searchFilter = "(objectclass=*)";
        
        int pageSize = 1;
        
        LDAPConnection lc = new LDAPConnection();
        
        try {
            // connect to the server
            lc.connect(ldapHost, ldapPort);
            // bind to the server
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            
            LDAPPagedResultsControl prc = new LDAPPagedResultsControl(pageSize, false);
            
            do {
                LDAPSearchConstraints cons = lc.getSearchConstraints();
                cons.setControls(prc);
                lc.setConstraints(cons);
                
                LDAPSearchResults searchResults =
                        lc.search(searchBase,
                                searchScope,
                                searchFilter,
                                null, // return all attributes
                                false); // return attrs and values
                
                /*
                 * To print out the search results, -- The first while loop goes through all the entries -- The second
                 * while loop goes through all the attributes -- The third while loop goes through all the attribute
                 * values
                 */
                while (searchResults.hasMore()) {
                    LDAPEntry nextEntry = null;
                    try {
                        nextEntry = searchResults.next();
                    } catch (LDAPException e) {
                        System.out.println("Error: " + e.toString());
                        
                        // Exception is thrown, go for next entry
                        if (e.getResultCode() == LDAPException.LDAP_TIMEOUT
                                || e.getResultCode() == LDAPException.CONNECT_ERROR)
                            break;
                        else
                            continue;
                        
                    }
                    
                    System.out.println("\n" + nextEntry.getDN());
                    System.out.println("  Attributes: ");
                    
                    LDAPAttributeSet attributeSet = nextEntry.getAttributeSet();
                    Iterator allAttributes = attributeSet.iterator();
                    
                    while (allAttributes.hasNext()) {
                        LDAPAttribute attribute = (LDAPAttribute)allAttributes.next();
                        String attributeName = attribute.getName();
                        System.out.println("    " + attributeName);
                        Enumeration allValues = attribute.getStringValues();
                        if (allValues != null) {
                            while (allValues.hasMoreElements()) {
                                String Value = (String)allValues.nextElement();
                                if (Base64.isLDIFSafe(Value)) {
                                    // is printable
                                    System.out.println("      " + Value);
                                }
                                else {
                                    // base64 encode and then print out
                                    Value = Base64.encode(Value.getBytes());
                                    System.out.println("      " + Value);
                                }
                            }
                        }
                    }// for each attributes
                }// has more results ?
                
                LDAPControl[] responseControls = searchResults.getResponseControls();
                prc.setCookie(null); // in case no cookie is returned we need to step out of do..while
                if (responseControls != null) {
                    for (int i = 0; i < responseControls.length; i++) {
                        if (responseControls[i] instanceof LDAPPagedResultsResponse) {
                            LDAPPagedResultsResponse response = (LDAPPagedResultsResponse)responseControls[i];
                            prc.setCookie(response.getCookie());
                        }
                    }
                }
                printCookieIfNeccessary(prc.getCookie());
                System.out.println("------------------------");
            } while (prc.getCookie() != null); // for each page
            
            // disconnect with the server
            lc.disconnect();
            
        } catch (LDAPException e) {
            System.out.println("Error: " + e.toString());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.toString());
        }
        System.exit(0);
    }
    
    private static void printCookieIfNeccessary(byte[] cookie) {
        if (cookie != null) {
            System.out.print(" cookie: ");
            for (byte b : cookie) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
