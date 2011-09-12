package com.ggd543.rmi.test;

import com.ggd543.rmi.HelloService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.net.URL;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.*;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-12
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
public class Setup {
    public static void main(String[] args) throws ActivationException, IOException, NamingException {
        URL serverPolicyUrl = Setup.class.getResource("/server.policy");
        System.out.println("The path of server.policy: "+serverPolicyUrl);
        Properties prop = new Properties();
        prop.put("java.security.policy",serverPolicyUrl.toString());
        //创建激活组描述符ActivationGroupDesc对象
        ActivationGroupDesc groupDesc =  new ActivationGroupDesc(prop,null);
        //注册ActivationGroup
        ActivationGroupID groupId = ActivationGroup.getSystem().registerGroup(groupDesc);

        String classURL = System.getProperty("java.rmi.server.codebase");
        MarshalledObject param = new MarshalledObject("HelloService");
        //创建激活对象描述符ActivationDesc对象
        ActivationDesc desc  = new ActivationDesc(groupId, "com.ggd543.rmi.impl.HelloServiceImpl", classURL, param);

        //向rmid注册激活对象
        HelloService hs = (HelloService) Activatable.register(desc);

        System.out.println(hs.getClass().getName());

        Context context = new InitialContext();
        //向rmiregistry注册两个激活对象
        context.rebind("rmi:HelloService",hs);
        System.out.println("服务器注册了一个可激活的HelloService对象");
    }
}
