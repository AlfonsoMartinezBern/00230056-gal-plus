package com.telefonica.gal.handler;

import java.io.IOException;

import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.ws.soap.security.wss4j2.callback.SpringSecurityPasswordValidationCallbackHandler;

public class SOAPSecurityValidationCallbackHandler extends SpringSecurityPasswordValidationCallbackHandler {

	@Override
	protected void handleUsernameToken(WSPasswordCallback callback) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		super.handleUsernameToken(callback);
		System.out.println(callback.getPassword());
		System.out.println(callback.getIdentifier());

	}

	
}
