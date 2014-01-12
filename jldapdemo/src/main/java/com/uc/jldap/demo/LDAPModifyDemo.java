package com.uc.jldap.demo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.novell.ldap.*;
import com.uc.jldap.demo.security.TrustManager;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-9-5 Time: 下午5:26 To change this template use File | Settings
 * | File Templates.
 */
public class LDAPModifyDemo {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        String ldapHost = "192.168.121.130";
        String loginDN = "cn=admin,dc=ucweb,dc=com";
        String password = "123456";
        String modifyDN = "cn=test_19,dc=ucweb,dc=com";
        
        int ldapPort = LDAPConnection.DEFAULT_SSL_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;
        
        LDAPJSSESecureSocketFactory ssf = new LDAPJSSESecureSocketFactory(TrustManager.createSSLSocketFactory());
        LDAPConnection lc = new LDAPConnection(ssf);
        
        List<LDAPModification> modList = new ArrayList<LDAPModification>();
        
        // Add a new value to the description attribute
        String desc = "This object was modified at " + new Date();
        LDAPAttribute attribute = new LDAPAttribute("description", "xx");
        modList.add(new LDAPModification(LDAPModification.REPLACE, attribute));
        
        attribute = new LDAPAttribute("telephoneNumber", "");
//        attribute = new LDAPAttribute("telephoneNumber", "1");
        modList.add(new LDAPModification(LDAPModification.ADD, attribute));
        
        // Replace the labeledURI address with a new value
        attribute = new LDAPAttribute("userPassword","");
        modList.add(new LDAPModification(LDAPModification.REPLACE, attribute));
        
        // delete the email attribute
        // attribute = new LDAPAttribute("mail");
        // modList.add(new LDAPModification(LDAPModification.DELETE, attribute));
        
        LDAPModification[] mods = new LDAPModification[modList.size()];
        mods = (LDAPModification[])modList.toArray(mods);
//        mods = new LDAPModification[0];
        try {
            lc.connect(ldapHost, ldapPort);
            lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            lc.modify(modifyDN, mods);
            System.out.println("LDAPAttribute add、replace、delete all successful.");
        } catch (LDAPException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.toString());
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
