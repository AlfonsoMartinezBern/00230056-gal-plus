package com.telefonica.gal.header.wsa;

import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import com.telefonica.gal.header.wsa.model.EndpointReferenceType;
import com.telefonica.gal.header.wsa.model.ObjectFactory;



public class WSAHeader {

	private static final String ACTION = "Action";
	private static final String TO = "To";
	private static final String FROM = "From";
	
	private MessageContext messageContext;
	
	private String from;
	private String to;
	private String action;
	
	public WSAHeader(MessageContext context) throws Exception {
		super();
		this.messageContext = context;
		analizeMessageContext();
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getAction() {
		return action;
	}
	
	
	private void analizeMessageContext() throws Exception {
		 SaajSoapMessage soapRequest = (SaajSoapMessage) messageContext
	                .getRequest();
	        SoapHeader reqheader = soapRequest.getSoapHeader();
	        
	        Iterator<SoapHeaderElement> itr = reqheader.examineAllHeaderElements();
	        while (itr.hasNext()) {
	            SoapHeaderElement element = itr.next();
	           
	            if(isAction(element)) {
	            	this.action=element.getText();
	            }else if(isTo(element)) {
	            	this.to=element.getText();
	            }else if(isFrom(element)) {
	            	this.from=getAddressFrom(element);
	            }
	        }
	}

	private boolean isFrom(SoapHeaderElement ele) {
		return ele.getName().getLocalPart().equals(FROM);
	}

	private boolean isTo(SoapHeaderElement ele) {
		return ele.getName().getLocalPart().equals(TO);
	}

	private boolean isAction(SoapHeaderElement ele) {
		return ele.getName().getLocalPart().equals(ACTION);
	}
	
	private String getAddressFrom(SoapHeaderElement from) throws JAXBException {
   	 JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        JAXBElement<EndpointReferenceType> fromJB =
            (JAXBElement<EndpointReferenceType>) unmarshaller
                .unmarshal(from.getSource());

		return  fromJB.getValue().getAddress().getValue();
   }

	
}
