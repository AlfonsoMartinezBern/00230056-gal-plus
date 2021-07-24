package com.telefonica.gal.validate;

import com.telefonica.gal.servicesConsolidation.request.CUSTOMER;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ConsolidationValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "OPERATION_ID", "3");

        CUSTOMER customer = (CUSTOMER) object;
        if(customer.getOPERATIONID().isEmpty() || customer.getOPERATIONID().length() > 11) {
            errors.rejectValue("OPERATION_ID", "Falta campo obligatorio OPERATION_ID");
        }

    }
}
