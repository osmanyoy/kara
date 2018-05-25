package com.alz.jee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

@JMSDestinationDefinitions(value = {
        @JMSDestinationDefinition(name = "java:/jms/queue/MyQueue", destinationName = "MyQueue", interfaceName = "javax.jms.Queue"),
        @JMSDestinationDefinition(name = "java:/jms/topic/MyTopic", destinationName = "MyTopic", interfaceName = "javax.jms.Topic")

})

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "MyQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "MyQueue")
public class QueueListener1 implements MessageListener {

	/**
	 * Default constructor.
	 */
	public QueueListener1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("In message 1 : " + textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else if (message instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage) message;
			try {
				LogObj logObj = (LogObj) objectMessage.getObject();
				System.out.println("Message : " + logObj.getMessage() + " type : " + logObj.getType() + " test : "
				        + logObj.getTest());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}

}
