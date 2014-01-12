package com.uc.jldap.demo;

/* **************************************************************************
 * 
 * $Novell: VLVControl.java,v 1.19 2005/07/07 09:45:12 $
 * 
 * 
 * 
 * Copyright (C) 2001 Novell, Inc. All Rights Reserved.
 * 
 * 
 * 
 * * THIS WORK IS SUBJECT TO U.S. AND INTERNATIONAL COPYRIGHT LAWS AND
 * 
 * TREATIES. USE AND REDISTRIBUTION OF THIS WORK IS SUBJECT TO THE LICENSE
 * 
 * AGREEMENT ACCOMPANYING THE SOFTWARE DEVELOPMENT KIT (SDK) THAT CONTAINS
 * 
 * THIS WORK. PURSUANT TO THE SDK LICENSE AGREEMENT, NOVELL HEREBY GRANTS TO
 * 
 * DEVELOPER A ROYALTY-FREE, NON-EXCLUSIVE LICENSE TO INCLUDE NOVELL'S SAMPLE
 * 
 * CODE IN ITS PRODUCT. NOVELL GRANTS DEVELOPER WORLDWIDE DISTRIBUTION RIGHTS
 * 
 * TO MARKET, DISTRIBUTE, OR SELL NOVELL'S SAMPLE CODE AS A COMPONENT OF
 * 
 * DEVELOPER'S PRODUCTS. NOVELL SHALL HAVE NO OBLIGATIONS TO DEVELOPER OR
 * 
 * DEVELOPER'S CUSTOMERS WITH RESPECT TO THIS CODE.
 * 
 * *************************************************************************
 */

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;

import com.novell.ldap.*;
import com.novell.ldap.controls.*;

/**
 * The following sample demonstrates how to use the VLV control with Synchronous search requests. As required a Server
 * Side Sort Control is also included in the request. The program is hard coded to sort based on the common name
 * attribute, and it searches for all objects at the specified searchBase.
 * 
 * Usage: Usage: java VLVControl <host name> <login dn> <password> <searchBase>
 * 
 * 
 */

public class VLVControl {
    
    public static void main(String[] args) {
        
        // /* Check if we have the correct number of command line arguments */
        //
        // if (args.length != 4) {
        //
        // System.err.println("Usage:   java VLVControl <host name> <login dn>"
        //
        // + " <password> <container>");
        //
        // System.err.println(
        //
        // "Example: java VLVControl Acme.com \"cn=admin,o=Acme\" secret"
        //
        // + " \"ou=Sales,o=Acme\"");
        //
        // System.exit(1);
        //
        // }
        
        /* Parse the command line arguments */
        
        String ldapHost = "192.168.121.130";
        String loginDN = "cn=admin,dc=ucweb,dc=com";
        String password = "123456";
        String searchBase = "dc=ucweb,dc=com";
        String searchFilter = "(objectclass=*)";
        
        String returnedAttributes[] = { "*", "+" };
        
        String oid;
        
        boolean attributeOnly = false;
        
        boolean isSupported = false;
        
        int ldapPort = LDAPConnection.DEFAULT_PORT;
        
        int ldapVersion = LDAPConnection.LDAP_V3;
        
        LDAPConnection lc = new LDAPConnection();
        
        try {
            // connect to the server
            lc.connect(ldapHost, ldapPort);
            // bind to the server
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            System.out.println("Succesfully logged in to server: " + ldapHost);
            
            /*
             * To search for root DSE,
             * 
             * 1. Set LDAP version to LDAP_V3 before binding
             * 
             * 2. Set the search base to an empty string
             * 
             * 3. Set the search filter to (objectclass=*)
             * 
             * 4. Set the search scope to LDAP_SCOPE_BASE
             */
            
            LDAPSearchResults searchResults = lc.search(
                    "",
                    LDAPConnection.SCOPE_BASE,
                    "(objectclass=*)",
                    returnedAttributes,
                    attributeOnly);
            
            /*
             * The search returns one entry in the search results, and
             * 
             * it is the root DSE.
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
                            // Check whether the requested server supports the VLV Control
                            // Set to true if it is supported.
                            if (oid.equalsIgnoreCase("2.16.840.1.113730.3.4.9")
                                    || oid.equalsIgnoreCase("2.16.840.1.113730.3.4.10")) {
                                isSupported = true;
                            }
                        } else {
                            allValues.nextElement();
                        }
                    }
                }
            }
            
            // Proceed if the Sort Control is supported.
            
            if (isSupported == true) {
                System.out.println("VLV supported");
                /*
                 * Set default filter - Change this line if you need a different set
                 * 
                 * of search restrictions. Read the "NDS and LDAP Integration Guide"
                 * 
                 * for information on support by Novell eDirectory of this
                 * 
                 * functionaliry.
                 */
                
                String MY_FILTER = "objectclass=*";
                
                /*
                 * We are requesting that the givenname and cn fields for each
                 * 
                 * object be returned
                 */
                
                String[] attrs = new String[2];
                attrs[0] = "sn";
                attrs[1] = "cn";
                
                // We will be sending two controls to the server
                LDAPControl requestControls[] = new LDAPControl[2];
                /*
                 * Create the sort key to be used by the sort control
                 * 
                 * Results should be sorted based on the cn attribute.
                 * 
                 * See the "NDS and LDAP Integration Guide" for information on
                 * 
                 * Novell eDirectory support of this functionaliry.
                 */
                
                LDAPSortKey[] keys = new LDAPSortKey[1];
                
                keys[0] = new LDAPSortKey("sn");
                // Create the sort control
                requestControls[0] = new LDAPSortControl(keys, false);
                /*
                 * Create the VLV Control.
                 * 
                 * These two fields in the VLV Control identify the before and
                 * 
                 * after count of entries to be returned
                 */
                
                int beforeCount = 0;
                int afterCount = 2;
                
                /*
                 * The VLV control request can specify the index using one of the two methods described below:
                 * 
                 * TYPED INDEX: Here we request all objects that have cn greater than or equal to the letter "a"
                 */
                // requestControls[1] = new LDAPVirtualListControl("test", beforeCount, afterCount);
                
                /*
                 * The following code needs to be enabled to specify the index directly
                 * 
                 * int offset = 0; - offset of the index
                 * 
                 * int contentCount = 3; - our estimate of the search result size
                 * 
                 * requestControls[1] = new LDAPVirtualListControl(offset,
                 * 
                 * beforeCount, afterCount, contentCount);
                 */
                int offset = 0;
                int contentCount = 3;
                requestControls[1] = new LDAPVirtualListControl(offset, beforeCount, afterCount, contentCount);
                // Set the controls to be sent as part of search request
                
                LDAPSearchConstraints cons = lc.getSearchConstraints();
                cons.setControls(requestControls);
                lc.setConstraints(cons);
                // Send the search request - Synchronous Search is being used here
                System.out.println("Calling synchronous Search...");
                long t1, t2;
                t1 = System.nanoTime();
                LDAPSearchResults res = lc.search(searchBase,
                        LDAPConnection.SCOPE_SUB,
                        MY_FILTER,
                        attrs,
                        false,
                        (LDAPSearchConstraints)null);
                // Loop through the results and print them out
                int total = 0;
                while (res.hasMore()) {
                    /*
                     * Get next returned entry. Note that we should expect a LDAPException object as well just in case
                     * something goes wrong
                     */
                    
                    LDAPEntry nextEntry;
                    try {
                        nextEntry = res.next();
                        total++;
                    } catch (LDAPException e) {
                        if (e instanceof LDAPReferralException) {
                            continue;
                        } else if (e.getResultCode() == LDAPException.SIZE_LIMIT_EXCEEDED) {
                            t2 = System.nanoTime();
                            System.out.println("total : " + (t2 - t1) / 1000000 + " ms " + (total));
                            continue;
                        } else {
                            System.out.println("Search stopped with exception " + e.toString());
                            break;
                        }
                    }
                    
                    /* Print out the returned Entries distinguished name. */
                    System.out.println();
                    System.out.println(nextEntry.getDN());
                    
                    /* Get the list of attributes for the current entry */
                    LDAPAttributeSet findAttrs = nextEntry.getAttributeSet();
                    /* Convert attribute list to Enumeration */
                    Iterator enumAttrs = findAttrs.iterator();
                    System.out.println("Attributes: ");
                    /* Loop through all attributes in the enumeration */
                    while (enumAttrs.hasNext()) {
                        LDAPAttribute anAttr = (LDAPAttribute)enumAttrs.next();
                        /* Print out the attribute name */
                        String attrName = anAttr.getName();
                        System.out.println("" + attrName);
                        // Loop through all values for this attribute and print them
                        Enumeration enumVals = anAttr.getStringValues();
                        while (enumVals.hasMoreElements()) {
                            String aVal = (String)enumVals.nextElement();
                            System.out.println("" + aVal);
                        }// for each attr's value
                    }// for each attr
                }// for each entry
                
                // Server should send back a control irrespective of the status of the search request
                LDAPControl[] controls = res.getResponseControls();
                if (controls == null) {
                    System.out.println("No controls returned");
                } else {
                    // We are likely to have multiple controls returned
                    for (int i = 0; i < controls.length; i++) {
                        /* Is this the Sort Response Control. */
                        if (controls[i] instanceof LDAPSortResponse) {
                            System.out.println("Received LDAP Sort Control from Server");
                            /*
                             * We could have an error code and maybe a string
                             * 
                             * identifying erring attribute in the response control.
                             */
                            String bad = ((LDAPSortResponse)controls[i]).getFailedAttribute();
                            int result = ((LDAPSortResponse)controls[i]).getResultCode();
                            
                            // Print out error code (0 if no error) and any
                            // returned attribute
                            System.out.println("Error code: " + result);
                            if (bad != null) {
                                System.out.println("Offending " + "attribute: " + bad);
                            } else {
                                System.out.println("No offending " + "attribute " + "returned");
                            }
                        }
                        
                        /* Is this a VLV Response Control */
                        if (controls[i] instanceof LDAPVirtualListResponse) {
                            System.out.println("Received VLV Response Control from Server...");
                            /* Get all returned fields */
                            int firstPosition = ((LDAPVirtualListResponse)controls[i]).getFirstPosition();
                            int ContentCount = ((LDAPVirtualListResponse)controls[i]).getContentCount();
                            int resultCode = ((LDAPVirtualListResponse)controls[i]).getResultCode();
                            String context = ((LDAPVirtualListResponse)controls[i]).getContext();
                            
                            /*
                             * Print out the returned fields. Typically you would
                             * 
                             * have used these fields to reissue another VLV request
                             * 
                             * or to display the list on a GUI
                             */
                            System.out.println("Result Code    => " + resultCode);
                            System.out.println("First Position => " + firstPosition);
                            System.out.println("Content Count  => " + ContentCount);
                            
                            if (context != null) {
                                System.out.println("Context String => " + context);
                            } else {
                                System.out.println("No Context String in returned control");
                            }
                        }
                    }
                }
                
                /* We are done - disconnect */
                if (lc.isConnected()) {
                    lc.disconnect();
                }
            } else {
                // Print message if the Sort Control is not supported.
                System.out.println("The Requested Server does not support the VLV Control.");
                lc.disconnect();
                System.exit(1);
            }
        } catch (LDAPException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error: " + e.toString());
        }
        
    }
}
