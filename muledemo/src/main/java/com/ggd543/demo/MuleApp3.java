package com.ggd543.demo;

import jcifs.dcerpc.msrpc.samr;
import org.mule.DefaultMuleMessage;
import org.mule.MessageExchangePattern;
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.api.config.ConfigurationException;
import org.mule.api.context.MuleContextFactory;
import org.mule.api.endpoint.EndpointBuilder;
import org.mule.api.endpoint.EndpointException;
import org.mule.api.endpoint.InboundEndpoint;
import org.mule.api.endpoint.OutboundEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.MuleRegistry;
import org.mule.client.DefaultLocalMuleClient;
import org.mule.component.simple.EchoComponent;
import org.mule.construct.Flow;
import org.mule.context.DefaultMuleContextFactory;
import org.mule.endpoint.EndpointURIEndpointBuilder;

import java.util.Arrays;

/**
 * Created by ggd543 on 14-1-5.
 */
public class MuleApp3 {
    private static String MULE_SERVICE_URL = "http://localhost:9999";

    public static void main(String[] args) throws Exception {
        MuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        // create a muleContext
        MuleContext context = muleContextFactory.createMuleContext();
        // create a register
        MuleRegistry registry = context.getRegistry();

        context.start();
        // create an inbound endpoint
        EndpointBuilder inboundEndpointBuilder = new EndpointURIEndpointBuilder(MULE_SERVICE_URL + "/qq", context);
        inboundEndpointBuilder.setExchangePattern(MessageExchangePattern.REQUEST_RESPONSE);
//        registry.registerEndpointBuilder("local_baidu", inboundEndpointBuilder);
        InboundEndpoint inboundEndpoint = inboundEndpointBuilder.buildInboundEndpoint();
        registry.registerEndpoint(inboundEndpoint);

        // create an outbound endpoint
        EndpointBuilder outboundEndpointBuilder = new EndpointURIEndpointBuilder("http://www.qq.com", context);
        outboundEndpointBuilder.setExchangePattern(MessageExchangePattern.REQUEST_RESPONSE);
//        registry.registerEndpointBuilder("baidu",outboundEndpointBuilder);
        OutboundEndpoint outboundEndpoint = outboundEndpointBuilder.buildOutboundEndpoint();
        registry.registerEndpoint(outboundEndpoint);

        // create a flow
        Flow flow = new Flow("baidu", context);
        flow.setMessageSource(inboundEndpoint);
        flow.setMessageProcessors(Arrays.asList( (MessageProcessor) outboundEndpoint));
        registry.registerFlowConstruct(flow);

        MuleClient muleClient = new DefaultLocalMuleClient(context);
        MuleMessage response = muleClient.send("http://localhost:9999/baidu", new DefaultMuleMessage(null, context));
        System.out.println(response.getPayloadAsString());

//        context.stop();
//        context.dispose();
    }
}
