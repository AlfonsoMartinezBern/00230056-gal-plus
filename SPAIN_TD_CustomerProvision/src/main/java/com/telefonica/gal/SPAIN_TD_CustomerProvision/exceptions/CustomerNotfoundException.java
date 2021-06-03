package com.telefonica.gal.SPAIN_TD_CustomerProvision.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class CustomerNotfoundException implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        mostrarError(exception);
        exception.printStackTrace();
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        mostrarError(exception);
        exception.printStackTrace();
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        mostrarError(exception);
        exception.printStackTrace();
    }


    private void mostrarError(SAXParseException exception) {
        System.out.println("Linea: "
                + String.format("%4s|", exception.getLineNumber())
                + exception.getMessage());
    }

}
