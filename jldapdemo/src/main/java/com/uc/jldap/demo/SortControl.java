/*******************************************************************************
 * Novell:$ Copyright (c) 20010 Novell, Inc. All Rights Reserved.
 * 
 * THIS WORK IS SUBJECT TO U.S. AND INTERNATIONAL COPYRIGHT LAWS AND TREATIES. USE AND REDISTRIBUTION OF THIS WORK IS
 * SUBJECT TO THE LICENSE AGREEMENT ACCOMPANYING THE SOFTWARE DEVELOPMENT KIT (SDK) THAT CONTAINS THIS WORK. PURSUANT TO
 * THE SDK LICENSE AGREEMENT, NOVELL HEREBY GRANTS TO DEVELOPER A ROYALTY-FREE, NON-EXCLUSIVE LICENSE TO INCLUDE
 * NOVELL'S SAMPLE CODE IN ITS PRODUCT. NOVELL GRANTS DEVELOPER WORLDWIDE DISTRIBUTION RIGHTS TO MARKET, DISTRIBUTE, OR
 * SELL NOVELL'S SAMPLE CODE AS A COMPONENT OF DEVELOPER'S PRODUCTS. NOVELL SHALL HAVE NO OBLIGATIONS TO DEVELOPER OR
 * DEVELOPER'S CUSTOMERS WITH RESPECT TO THIS CODE.
 * 
 * $name: SortControl.java $description: SortControl.java demonstrates how to use the server server side control with
 * Synchronous search requests. The program is hard coded to sort based on the common name attribute, and it searches
 * for all objects at the specified searchBase.
 * 
 * Note that Novell eDirectory does not support multiple sort keys at this time.
 ******************************************************************************/
package com.uc.jldap.demo;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;

import com.novell.ldap.*;
import com.novell.ldap.controls.LDAPSortControl;
import com.novell.ldap.controls.LDAPSortKey;
import com.novell.ldap.controls.LDAPSortResponse;

public class SortControl {
    
    public static void main(String[] args) {
        
        // Read command line arguments
        String ldapHost = "192.168.121.130";
        String loginDN = "cn=admin,dc=ucweb,dc=com";
        String password = "123456";
        String searchBase = "dc=ucweb,dc=com";
        String returnedAttributes[] = { "*", "+" };
        String oid;
        boolean attributeOnly = false;
        boolean isSupported = false;
        int ldapPort = LDAPConnection.DEFAULT_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;
        String searchFilter = "(objectclass=*)";
        LDAPConnection lc = new LDAPConnection();
        
        try {
            // connect to the server
            lc.connect(ldapHost, ldapPort);
            // bind to the server
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            /*
             * To search for root DSE, 1. Set LDAP version to LDAP_V3 before binding 2. Set the search base to an empty
             * string 3. Set the search filter to (objectclass=*) 4. Set the search scope to LDAP_SCOPE_BASE
             */
            LDAPSearchResults searchResults = lc.search(
                    "",
                    LDAPConnection.SCOPE_BASE,
                    "(objectclass=*)",
                    returnedAttributes,
                    attributeOnly);
            
            /*
             * The search returns one entry in the search results, and it is the root DSE.
             */
            LDAPEntry entry = null;
            
            try {
                entry = searchResults.next();
            } catch (LDAPException e) {
                System.out.println("Error: " + e.toString());
            }
            
            LDAPAttributeSet attributeSet = entry.getAttributeSet();
            Iterator allAttributes = attributeSet.iterator();
            
            while (allAttributes.hasNext()) {
                LDAPAttribute attribute = (LDAPAttribute)allAttributes.next();
                String attrName = attribute.getName();
                Enumeration allValues = attribute.getStringValues();
                
                if (allValues != null) {
                    while (allValues.hasMoreElements()) {
                        if (attrName.equalsIgnoreCase("supportedControl")) {
                            oid = (String)allValues.nextElement();
                            
                            // Check whether the requested server supports the Sort Control
                            // Set to true if it is supported.
                            if (oid.equalsIgnoreCase("1.2.840.113556.1.4.473")
                                    || oid.equalsIgnoreCase("1.2.840.113556.1.4.474"))
                                isSupported = true;
                        } else {
                            allValues.nextElement();
                        }
                    }
                }
            }
            
            // Proceed if the Sort Control is supported.
            if (isSupported == true) {
                // Results of the search only include sn
                String[] attrs = new String[2];
                attrs[0] = "sn";
                attrs[1] = "cn";
                // The results should be sorted using the cn attribute
                LDAPSortKey[] keys = new LDAPSortKey[1];
                keys[0] = new LDAPSortKey("sn");
                // Create a LDAPSortControl object - Fail if cannot sort
                LDAPSortControl sort = new LDAPSortControl(keys, true);
                // Set the Sort control to be sent as part of search request
                LDAPSearchConstraints cons = lc.getSearchConstraints();
                cons.setControls(sort);
                lc.setConstraints(cons);
                // Perform the search - SYNCHRONOUS SEARCH USED HERE
                System.out.println("\nCalling search request...");
                LDAPSearchResults res = null;
                try{
                res = lc.search(
                        searchBase,
                        LDAPConnection.SCOPE_SUB,
                        searchFilter,
                        attrs, // only return sn
                        false // and it's value
                       );
                }catch (Exception e){
                    System.out.println("------------");
                    e.printStackTrace();
                    System.exit(1);
                }
                // Loop on results until finished
                while (res.hasMore()) {
                    // Get next directory entry - this next object can
                    // be an LDAPException if something went wrong
                    LDAPEntry nextEntry;
                    try {
                        nextEntry = res.next();
                    } catch (LDAPException e) {
                        e.printStackTrace();
                        if (e instanceof LDAPReferralException)
                            continue;
                        else
                            break;
                    }
                    
                    // Print out the entry DN
                    System.out.println();
                    System.out.println("Entry dn: " + nextEntry.getDN());
                    
                    // Get the attributes of the entry
                    LDAPAttributeSet findAttrs = nextEntry.getAttributeSet();
                    
                    Iterator enumAttrs = findAttrs.iterator();
                    System.out.println("Attribute(s):");
                    
                    // Loop on attributes
                    while (enumAttrs.hasNext()) {
                        LDAPAttribute anAttr = (LDAPAttribute)enumAttrs.next();
                        // get attribute name
                        String attrName = anAttr.getName();
                        // get attribute value
                        Enumeration enumVals = anAttr.getStringValues();
                        while (enumVals.hasMoreElements()) {
                            String aVal = (String)enumVals.nextElement();
                            // print out attribute name and value
                            System.out.println("    " + attrName + ": " + aVal);
                        }
                    }
                }
                
                // Server should send back a control irrespective of the status of the search request
                LDAPControl[] controls = res.getResponseControls();
                if (controls != null) {
                    // Theoritically we could have multiple controls returned
                    for (int i = 0; i < controls.length; i++) {
                        
                        // We are looking for the LDAPSortResponse Control class -
                        // the control sent back in response to LDAPSortControl
                        if (controls[i] instanceof LDAPSortResponse) {
                            System.out.println("Received LDAP Sort Control from server");
                            
                            // We must have an error code and maybe a string
                            // identifying erring attribute in the response control.
                            String bad = ((LDAPSortResponse)controls[i]).getFailedAttribute();
                            int result = ((LDAPSortResponse)controls[i]).getResultCode();
                            
                            // Print out error ccode (0 if no error) and any
                            // returned attribute
                            System.out.println("Error code: " + result);
                            if (bad != null)
                                System.out.println("Offending " + "attribute: " + bad);
                            else
                                System.out.println("No offending " + "attribute " + "returned");
                        }
                    }
                }
                
                // All done - disconnect
                if (lc.isConnected()){
                    lc.disconnect();
                }
            }
            // Print message if the Sort Control is not supported.
            else {
                System.out.println("The Requested Server does not support the Sort Control.");
                lc.disconnect();
                System.exit(1);
            }
            
        } catch (LDAPException e) {
            System.out.println(e.toString());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.toString());
        }
        
    }
}
