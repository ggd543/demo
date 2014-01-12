package com.ggd543.authetication.handler;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-2
 * Time: 下午8:10
 * To change this template use File | Settings | File Templates.
 */
public class SimpleUsernameAndPasswordAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    static{
//       System.out.println(i);
        System.out.println("hello");
        i = 10;
    }

    static  int i=100;


    @Override
    protected boolean authenticateUsernamePasswordInternal(UsernamePasswordCredentials usernamePasswordCredentials) throws AuthenticationException {
        System.out.println(usernamePasswordCredentials);
        String username = getPrincipalNameTransformer().transform(usernamePasswordCredentials.getUsername());
        String password = getPasswordEncoder().encode(usernamePasswordCredentials.getPassword());
        System.out.println("username: " + username + " password: " + password);
        return "ggd543".equalsIgnoreCase(username) && "abc123".equalsIgnoreCase(password);
    }

    public static void main(String[] args) {
        System.out.println(i);
    }
}
