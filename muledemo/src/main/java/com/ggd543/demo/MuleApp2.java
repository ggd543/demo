package com.ggd543.demo;

import org.apache.commons.lang.Validate;
import org.mule.MessageExchangePattern;
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.api.config.ConfigurationException;
import org.mule.api.context.MuleContextBuilder;
import org.mule.api.context.MuleContextFactory;
import org.mule.api.endpoint.EndpointBuilder;
import org.mule.api.endpoint.InboundEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.MuleRegistry;
import org.mule.client.DefaultLocalMuleClient;
import org.mule.construct.Flow;
import org.mule.context.DefaultMuleContextBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.mule.endpoint.EndpointURIEndpointBuilder;
import org.mule.transformer.simple.StringAppendTransformer;

import java.util.Arrays;

/**
 * Created by ggd543 on 14-1-4.
 */
public class MuleApp2 {
    public static void main(String[] args) throws Exception {
        MuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
        // create a muleContext
        MuleContext context = muleContextFactory.createMuleContext();
        // create a register
        MuleRegistry registry = context.getRegistry();
        // start context
        context.start();

        // create an endpoint
        EndpointBuilder testEndpointBuilder = new EndpointURIEndpointBuilder("vm://testFlow.in", context);
        testEndpointBuilder.setExchangePattern(MessageExchangePattern.REQUEST_RESPONSE);
        registry.registerEndpointBuilder("testFlow.in", testEndpointBuilder);
        InboundEndpoint vmInboundEndpoint = testEndpointBuilder.buildInboundEndpoint();
        registry.registerEndpoint(vmInboundEndpoint);
        // create a transformer
        StringAppendTransformer stringAppendTransformer = new StringAppendTransformer(" world");
        stringAppendTransformer.setMuleContext(context);
        // create a flow
        Flow testFlow = new Flow("testFlow", context);
        testFlow.setMessageSource(vmInboundEndpoint);
        testFlow.setMessageProcessors(Arrays.asList((MessageProcessor) stringAppendTransformer));
        registry.registerFlowConstruct(testFlow);

        MuleClient muleClient = new DefaultLocalMuleClient(context);
        MuleMessage response = muleClient.send("vm://testFlow.in", "hello", null);
        Validate.isTrue(response.getPayloadAsString().equals("hello world"));

//        context.stop();
//        context.dispose();
    }
}
