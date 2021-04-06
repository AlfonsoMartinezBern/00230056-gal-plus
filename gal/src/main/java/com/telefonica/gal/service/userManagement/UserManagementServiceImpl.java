package com.telefonica.gal.service.userManagement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.gal.client.dynamicrouting.td.facade.DynamicRoutingTDClient;
import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.header.wsa.facade.WSAHeaderImpl;
import com.telefonica.gal.transform.CreateUserRequestMapper;
import com.telefonica.gal.transform.CreateUserResponseMapper;
import com.telefonica.gal.ws.userManagement.WsITDregistrationService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	private final static String CreateUser = "CreateUser";

	private final static CreateUserRequestMapper CREATE_USER_REQUEST_MAPPER =
			Mappers.getMapper(CreateUserRequestMapper.class);

	private final static CreateUserResponseMapper CREATE_USER_RESPONSE_MAPPER =
			Mappers.getMapper(CreateUserResponseMapper.class);

    private final WsITDregistrationService wsITDregistrationService;
    
    @Autowired
    DynamicRoutingTDClient dynamicRoutingTD;

    public UserManagementServiceImpl(WsITDregistrationService wsITDregistrationService) {
        this.wsITDregistrationService = wsITDregistrationService;
    }

    @Override
    public CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser,WSAHeaderImpl wsaHeader ) {
    	
    	CreateUserResponse response = new CreateUserResponse();

    	// TODO URI: Corresponde al FROM de la cabecera wsa:From WS-Addressing
		if (wsaHeader.getAction().contains("IPTV")) {
			isPresentEmail(createUser.getUserCreation().getEmail());
		}
		
		
    	RoutingTDKey tdKey = new RoutingTDKey(wsaHeader.getAction(), CreateUser, wsaHeader.getFrom());

		RoutingTDInfo routingTDInfo = dynamicRoutingTD.search(tdKey);

		System.out.println(routingTDInfo);
		
		List<Endpoint> endpointList = routingTDInfo.getEndpoints();
		
		String url = endpointList.get(0).getTargetEndpoint();
		int instanceId = endpointList.get(0).getInstanceID();
		int platformId = endpointList.get(0).getPlatformID();

        UserDataContract userDataContract = new UserDataContract();
        userDataContract = CREATE_USER_REQUEST_MAPPER.userDataMapper(createUser.getUserCreation());

		ResultDataContractOfstring resultDataContractOfstring = new ResultDataContractOfstring();

        wsITDregistrationService.setURL(url);
		resultDataContractOfstring = wsITDregistrationService.createUser(instanceId, platformId, userDataContract);

		response = CREATE_USER_RESPONSE_MAPPER.createUserResponseMapper(resultDataContractOfstring);

        return response;
    }
    
//    private RoutingTDInfo callDynamicRouting(RoutingTDKey key) {
//    	String dynamicRoutingURL = URL +"/dinamicRoutingTD/search?serviceID="+key.getServiceID()+
//				"&operationTD=CreateUser&uri="+key.getUri();
//    	RestTemplate restTemplate = new RestTemplate();
//
//    	String json = restTemplate.getForObject(dynamicRoutingURL, String.class);
//    	
//    	ObjectMapper objectMapper = new ObjectMapper();
//    	RoutingTDInfo dynamicRoutingTD;
//		try {
//			dynamicRoutingTD = objectMapper.readValue(json, RoutingTDInfo.class);	    	
//	    	return dynamicRoutingTD;
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//    }

    private List<Endpoint> targetEndpoint(final RoutingTDInfo routingTDInfo ) {
		List<Endpoint> url = routingTDInfo.getEndpoints().stream().collect(Collectors.toList());
    	return url;
	}

	private void isPresentEmail(final String email) {
		Optional<String> emailIptv = Optional.ofNullable(email);
		emailIptv.orElseThrow(NumberFormatException::new); // TODO Si no existe el campo email, Llamada al servicio de errores
	}
}
