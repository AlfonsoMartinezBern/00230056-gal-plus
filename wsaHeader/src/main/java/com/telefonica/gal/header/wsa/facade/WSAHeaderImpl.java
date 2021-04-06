package com.telefonica.gal.header.wsa.facade;

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



public class WSAHeaderImpl implements WSAHeader {


	private MessageContext messageContext;
	
	private String from;
	private String to;
	private String action;
	
	public WSAHeaderImpl(MessageContext context) throws Exception {
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
	            SoapHeaderElement ele = itr.next();
	           
	            if(ele.getName().getLocalPart().equals("Action")) {
	            	this.action=ele.getText();
	            }else if(ele.getName().getLocalPart().equals("To")) {
	            	this.to=ele.getText();
	            }else if(ele.getName().getLocalPart().equals("From")) {
	            	this.from=getAddressFrom(ele);
	            }
	        }
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
