package com.ggd543.demo;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleContext;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.api.context.MuleContextFactory;
import org.mule.config.ConfigResource;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;

import java.net.URL;

/**
 * Created by ggd543 on 14-1-4.
 */
public class MuleApp1 {
    public static void main(String[] args) throws Exception {
        MuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        URL url = MuleApp1.class.getResource("/app/mule-config.xml");
        SpringXmlConfigurationBuilder configBuilder = new SpringXmlConfigurationBuilder(new ConfigResource[]{new ConfigResource(url)});
        MuleContext muleContext = muleContextFactory.createMuleContext(configBuilder);
        muleContext.start();

//        MuleClient muleClient = new DefaultLocalMuleClient(muleContext);
//         MuleMessage message = muleClient.request("http://localhost:8888/?name=sdf",-1);
//        System.out.println(message.getPayloadAsString());

        MuleClient client = muleContext.getClient();
        MuleMessage response = client.send("http://localhost:9081", new DefaultMuleMessage(null, muleContext));
        System.out.println(response.getPayloadAsString());

//        muleContext.stop();
//        muleContext.dispose();

        System.out.println("-------------------");
        System.out.println(muleContext.isStopping());
        System.out.println(muleContext.isDisposed());
    }
}
