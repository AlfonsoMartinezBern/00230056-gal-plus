package com.telefonica.gal.service.userManagement;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.gal.dynamicrouting.tdo.RoutingTDInfo;
import com.telefonica.gal.dynamicrouting.tdo.RoutingTDKey;
import com.telefonica.gal.ws.userManagement.WsITDregistrationService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ArrayOfUserCustomFieldDataContract;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.UserCustomFieldDataContract;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;

@Service
public class UserManagementServiceImpl implements UserManagementService {
    private final WsITDregistrationService wsITDregistrationService;

    public UserManagementServiceImpl(WsITDregistrationService wsITDregistrationService) {
        this.wsITDregistrationService = wsITDregistrationService;
    }

    @Override
    public CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser) {
    	
    	CreateUserResponse cur = new CreateUserResponse();
    	
    	String alias = createUser.getUserCreation().getUserNickName().getAlias();
    	String email = createUser.getUserCreation().getEmail();

    	RoutingTDKey tdKey = new RoutingTDKey("OTT", "createUser", "http://telefonica.com/OB2/BSS/SIMULATOR/OProv_Management");
    	
		RoutingTDInfo routingTDInfo = callDynamicRouting(tdKey );

		String url = routingTDInfo.getEndpoints().get(0).getTargetEndpoint();
		int instanceID = routingTDInfo.getEndpoints().get(0).getInstanceID();
		int platformID = routingTDInfo.getEndpoints().get(0).getPlatformID();
		
    	
        ResultDataContractOfstring resultDataContractOfstring = new ResultDataContractOfstring();

        UserDataContract userDataContract = new UserDataContract();
        JAXBElement<String> uniqueID =  new JAXBElement(new QName("http://schemas.datacontract.org/2004/07/GVP.GAL.Model", "UniqueId"), String.class, alias);
		userDataContract.setUniqueId(uniqueID);
		 JAXBElement<String> email_ =  new JAXBElement(new QName("http://schemas.datacontract.org/2004/07/GVP.GAL.Model", "Email"), String.class, email);
        userDataContract.setEmail(email_);
        
	//        JAXBElement<UserCustomFieldDataContract> customField =  new JAXBElement(new QName("http://schemas.datacontract.org/2004/07/GVP.GAL.Model", "UserCustomFieldDataContract"), UserCustomFieldDataContract.class, email);
	//		JAXBElement<ArrayOfUserCustomFieldDataContract> customFields = new JAXBElement(new QName("http://schemas.datacontract.org/2004/07/GVP.GAL.Model", "CustomFields"), ArrayOfUserCustomFieldDataContract.class, customField);;
	//		userDataContract.setCustomFields(customFields);
        
        wsITDregistrationService.setURL(url);

        
        resultDataContractOfstring = wsITDregistrationService.createUser(instanceID,platformID,userDataContract);
        
        System.out.println(resultDataContractOfstring);
        
        return cur;
    }
    
    private RoutingTDInfo callDynamicRouting(RoutingTDKey key) {
    	String dynamicRoutingURL = "http://localhost:8081/dinamicRoutingTD/search?serviceID="+key.getServiceID()+"&operationTD=CreateUser&uri="+key.getUri();
    	RestTemplate restTemplate = new RestTemplate();

    	
    	String json = restTemplate.getForObject(dynamicRoutingURL, String.class);
    	
    	//RoutingTDInfo json = restTemplate.getForObject(dynamicRoutingURL, RoutingTDInfo.class);
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	RoutingTDInfo dynamicRoutingTD;
		try {
			dynamicRoutingTD = objectMapper.readValue(json, RoutingTDInfo.class);	    	
	    	return dynamicRoutingTD;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
    	
//    	RestTemplate restTemplate = new RestTemplate();
//    	String dynamicRoutingURL = "http://localhost:8081/dinamicRoutingTD/search?serviceID={serviceID}&operationTD=CreateUser&uri={uri}";
//    	System.out.println(dynamicRoutingURL);
//    	return restTemplate.getForObject( dynamicRoutingURL, RoutingTDInfo.class,key.getServiceID(),key.getUri());
    }

}
