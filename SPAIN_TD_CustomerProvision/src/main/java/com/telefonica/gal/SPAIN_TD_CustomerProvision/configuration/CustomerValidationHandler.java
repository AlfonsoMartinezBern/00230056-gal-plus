package com.telefonica.gal.SPAIN_TD_CustomerProvision.configuration;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;

public class CustomerValidationHandler implements ValidationEventHandler {
    @Override
    public boolean handleEvent(ValidationEvent event) {
        if (event.getSeverity() == ValidationEvent.FATAL_ERROR ||
                event.getSeverity() == ValidationEvent.ERROR) {
            ValidationEventLocator locator = event.getLocator();

            throw new RuntimeException("Error in CustomerValidationHandler GAL+. line number: " + locator.getLineNumber()
                                        + "  Mensaje: " +  event.getMessage());

        }
        return true;
    }
}
