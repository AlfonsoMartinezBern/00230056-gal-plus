package com.telefonica.gal.service.userManagement;

import com.telefonica.gal.factory.FactoryRouting;
import com.telefonica.gal.client.dynamicrouting.td.facade.DynamicRoutingTDClient;
import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.header.wsa.WSAHeader;
import com.telefonica.gal.transform.CreateUserRequestMapper;
import com.telefonica.gal.transform.CreateUserResponseMapper;
import com.telefonica.gal.ws.userManagement.WsITDregistrationService;
import com.telefonica.gal.wsRouting.InvokeWs;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.context.MessageContext;

import java.util.List;
import java.util.Optional;

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
    public CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser,MessageContext context ) throws Exception {
    	WSAHeader wsaHeader = new WSAHeader(context);
		FactoryRouting factoryRouting = new FactoryRouting();
    	
    	CreateUserResponse response = new CreateUserResponse();

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

        //Inicio pruebas factoria para probar
		InvokeWs wsGvp = factoryRouting.getInvokeWs("GVP",CreateUser, instanceId, platformId, url,
				userDataContract);
		wsGvp.invoke();

		//fin prueba factoria

		ResultDataContractOfstring resultDataContractOfstring = new ResultDataContractOfstring();

        wsITDregistrationService.setURL(url);
		resultDataContractOfstring = wsITDregistrationService.createUser(instanceId, platformId, userDataContract);

		response = CREATE_USER_RESPONSE_MAPPER.createUserResponseMapper(resultDataContractOfstring);

        return response;
    }


	private void isPresentEmail(final String email) {
		Optional<String> emailIptv = Optional.ofNullable(email);
		emailIptv.orElseThrow(NumberFormatException::new); // TODO Si no existe el campo email, Llamada al servicio de errores
	}
}
