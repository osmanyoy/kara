package com.alz.jee.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/jms")
public class JMSRest {
	
	@Inject
	private JMSContext jmsContext;

	@Resource(lookup="java:/jms/queue/MyQueue")
	private Queue queue;
	
	@Resource(lookup="java:/jms/topic/MyTopic")
	private Topic topic;
	
	@Path("/sendToQueue/{msg}")
	@GET
	public String sendMessageToQueue(@PathParam("msg") String message) {
		JMSProducer createProducer = jmsContext.createProducer();
		createProducer.send(queue, message);
		return "OK";
	}
	
	@Path("/sendObject")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String sendObjectToQueue(LogObj logObj) {
		JMSProducer createProducer = jmsContext.createProducer();
		createProducer.send(queue, logObj);
		return "OK";
	}

	
	@Path("/sendToTopic/{msg}")
	@GET
	public String sendMessageToTopic(@PathParam("msg") String message) {
		JMSProducer createProducer = jmsContext.createProducer();
		createProducer.send(topic, message);
		return "OK"; 
	}
	
}
