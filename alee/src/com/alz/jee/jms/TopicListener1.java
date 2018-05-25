package com.alz.jee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "MyTopic"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "MyTopic")
public class TopicListener1 implements MessageListener {

    /**
     * Default constructor. 
     */
    public TopicListener1() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
        	TextMessage textMessage = (TextMessage) message;
        	try {
				System.out.println("Topic message 1 : " + textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
        }
        
    }

}
