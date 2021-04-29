package com.telefonica.gal.factory;

import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;

public class ResponseGal {
    protected InvokeWs createUserResponse;
    protected String type;

    public ResponseGal(InvokeWs createUserResponse, String type) {
        this.createUserResponse = createUserResponse;
        this.type = type;
    }

    public InvokeWs getCreateUserResponse() {
        return createUserResponse;
    }

    public void setCreateUserResponse(InvokeWs createUserResponse) {
        this.createUserResponse = createUserResponse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
