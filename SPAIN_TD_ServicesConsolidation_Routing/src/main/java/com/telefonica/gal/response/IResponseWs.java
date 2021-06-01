package com.telefonica.gal.response;

import org.springframework.http.ResponseEntity;

public interface IResponseWs {
    com.telefonica.gal.servicesConsolidation.response.CUSTOMER responseInfo(final ResponseEntity<Object> objectResponseEntity,
                                                                            final String codeInterface,
                                                                            final String codeOperation);
}
