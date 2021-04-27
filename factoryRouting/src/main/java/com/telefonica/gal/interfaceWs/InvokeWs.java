package com.telefonica.gal.interfaceWs;

import com.telefonica.gal.wsdl.northbound.provManagement.ClientException;
import com.telefonica.gal.wsdl.northbound.provManagement.ServerException;

public interface InvokeWs<T> {
    T invoke() throws ServerException, ClientException;
}
