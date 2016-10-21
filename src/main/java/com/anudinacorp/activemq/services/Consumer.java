/**
 * 
 */
package com.anudinacorp.activemq.services;
import javax.jms.JMSException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	 
    private static final String ORDER_RESPONSE_QUEUE = "MY_MQ_V1";

    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(final Message<String> message) throws JMSException {
    	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers =  message.getHeaders();
       System.out.println("Application : headers received : {}"+headers);
         
       System.out.println("Application : response received : {}"+message);
         
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}