package com.telefonica.gal.handler;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

public class WsAddressInjectHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(final SOAPMessageContext soapMessageContext) {
        System.out.println("WsAddressInjectHandler() *********************************");

            try{
                SOAPMessage soapMsg = soapMessageContext.getMessage();
                SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();

                String wsa = soapMsg.getSOAPHeader().getAttributeNS("http://schemas.datacontract.org/2004/07/GVP.GAL.Model", "xmlns:wsa");

                System.out.println("Probando obtener heard: " + wsa);


            }catch(SOAPException e){
                System.err.println(e);
                return false;
            }


        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        return false;
    }

    @Override
    public void close(MessageContext messageContext) {

    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

}
