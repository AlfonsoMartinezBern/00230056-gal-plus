package com.telefonica.gal.dynamicconf.unica.credential.td.repository;

import java.util.List;

import com.telefonica.gal.dynamicconf.unica.credential.td.repository.model.Credential_UNICA_TD_WSSE;

public class DynamicRoutingRepository_UNICA_TD_WSSE_Validator  {

	public static  boolean isValid(List<Credential_UNICA_TD_WSSE> credentials) {
		// TODO Auto-generated method stub
		return isCredentialsValid(credentials);
	}
	
	private static boolean isCredentialsValid(List<Credential_UNICA_TD_WSSE> credentials) {
//		for( Credential_UNICA_TD_WSSE credential : credentials) {
//			if(!isCompleteCredential(credential)) {
//				return false;
//			}
//		}
		return true;
	}
	
	private static boolean isCompleteCredential(Credential_UNICA_TD_WSSE credential) {
		return credential.getPassword() != null && credential.getUser() != null;
	}


	

}
