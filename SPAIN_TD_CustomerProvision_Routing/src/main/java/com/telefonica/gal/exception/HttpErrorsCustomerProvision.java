package com.telefonica.gal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class HttpErrorsCustomerProvision implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return clientHttpResponse.getStatusCode() != HttpStatus.OK;
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

    }
}
