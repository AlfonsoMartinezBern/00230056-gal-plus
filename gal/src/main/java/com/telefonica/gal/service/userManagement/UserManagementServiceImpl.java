package com.telefonica.gal.service.userManagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.gal.dynamicrouting.tdo.Endpoint;
import com.telefonica.gal.dynamicrouting.tdo.RoutingTDInfo;
import com.telefonica.gal.dynamicrouting.tdo.RoutingTDKey;
import com.telefonica.gal.transform.CreateUserRequestMapper;
import com.telefonica.gal.ws.userManagement.WsITDregistrationService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	private final static CreateUserRequestMapper CREATE_USER_REQUEST_MAPPER =
			Mappers.getMapper(CreateUserRequestMapper.class);

    private final WsITDregistrationService wsITDregistrationService;


    public UserManagementServiceImpl(WsITDregistrationService wsITDregistrationService) {
        this.wsITDregistrationService = wsITDregistrationService;
    }

    @Override
    public CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser) {
    	
    	CreateUserResponse response = new CreateUserResponse();

    	// TODO Inicio agregado por JM
    	String alias = createUser.getUserCreation().getUserNickName().getAlias();
    	String email = createUser.getUserCreation().getEmail();

    	RoutingTDKey tdKey = new RoutingTDKey("OTT", "createUser", "http://telefonica.com/OB2/BSS/SIMULATOR/OProv_Management");


		RoutingTDInfo routingTDInfo = callDynamicRouting(tdKey );

		List<Endpoint> endpointList = targetEndpoint(routingTDInfo);

		String url = endpointList.get(0).getTargetEndpoint();
		int instanceId = endpointList.get(0).getInstanceID();
		int platformId = endpointList.get(0).getPlatformID();

        UserDataContract userDataContract = new UserDataContract();
        userDataContract = CREATE_USER_REQUEST_MAPPER.userDataMapper(createUser.getUserCreation());

		ResultDataContractOfstring resultDataContractOfstring = new ResultDataContractOfstring();


        wsITDregistrationService.setURL(url);
		resultDataContractOfstring = wsITDregistrationService.createUser(instanceId, platformId, userDataContract);


		JAXBElement<ResultDataContractOfstring> jaxbElement =  new JAXBElement(
				new QName("createUserResult"), ResultDataContractOfstring.class, resultDataContractOfstring);

		response.setCreateUserResult(jaxbElement);

        return response;
    }
    
    private RoutingTDInfo callDynamicRouting(RoutingTDKey key) {
    	String dynamicRoutingURL = "http://localhost:8081/dinamicRoutingTD/search?serviceID="+key.getServiceID()+"&operationTD=CreateUser&uri="+key.getUri();
    	RestTemplate restTemplate = new RestTemplate();

    	
    	String json = restTemplate.getForObject(dynamicRoutingURL, String.class);

    	
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
    }

    private List<Endpoint> targetEndpoint(final RoutingTDInfo routingTDInfo ) {

		List<Endpoint> url = routingTDInfo.getEndpoints().stream().collect(Collectors.toList());

    	return url;
	}
}
