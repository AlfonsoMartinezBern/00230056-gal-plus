package com.telefonica.gal.service.userManagement;

import com.telefonica.gal.client.dynamicrouting.td.facade.DynamicRoutingTDClient;
import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.header.wsa.WSAHeader;
import com.telefonica.gal.transform.CreateUserRequestMapper;
import com.telefonica.gal.transform.CreateUserRequestMapper_UMG;
import com.telefonica.gal.transform.CreateUserResponseMapper;
import com.telefonica.gal.transform.CreateUserResponseMapper_UMG;
import com.telefonica.gal.ws.userManagement.WsITDregistrationService;
import com.telefonica.gal.ws.userManagement.WsITDregistrationService_UMG;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import com.telefonica.serviceid.ServiceIdType;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.context.MessageContext;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	private final static String CreateUser = "CreateUser";

	private final static CreateUserRequestMapper_UMG CREATE_USER_REQUEST_MAPPER_UMG =
			Mappers.getMapper(CreateUserRequestMapper_UMG.class);

	private final static CreateUserResponseMapper_UMG CREATE_USER_RESPONSE_MAPPER_UMG =
			Mappers.getMapper(CreateUserResponseMapper_UMG.class);

	private final static CreateUserRequestMapper CREATE_USER_REQUEST_MAPPER =
			Mappers.getMapper(CreateUserRequestMapper.class);

	private final static CreateUserResponseMapper CREATE_USER_RESPONSE_MAPPER =
			Mappers.getMapper(CreateUserResponseMapper.class);

    private final WsITDregistrationService wsITDregistrationService;
	private final WsITDregistrationService_UMG wsITDregistrationService_umg;
    
    @Autowired
    DynamicRoutingTDClient dynamicRoutingTD;

    public UserManagementServiceImpl(WsITDregistrationService wsITDregistrationService, WsITDregistrationService_UMG wsITDregistrationService_umg) {
        this.wsITDregistrationService = wsITDregistrationService;
		this.wsITDregistrationService_umg = wsITDregistrationService_umg;
	}

    @Override
    public CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser,MessageContext context ) throws Exception {
    	WSAHeader wsaHeader = new WSAHeader(context);
    	
    	CreateUserResponse response = new CreateUserResponse();

		if (wsaHeader.getAction().contains("IPTV")) {
			isPresentEmail(createUser.getUserCreation().getEmail());
		}
		
    	RoutingTDKey tdKey = new RoutingTDKey(wsaHeader.getAction(), CreateUser, wsaHeader.getFrom());

		RoutingTDInfo routingTDInfo = dynamicRoutingTD.search(tdKey);

		switch (routingTDInfo.getEndpoints().get(0).getEndpointType()) {
			case "GVP.GAL":
				return callWsUserManagementCreateUser_GVP(routingTDInfo, createUser, getServiceId_GVP(wsaHeader.getTo()));
			case "UMG":
				return callWsUserManagementCreateUser_UMG(routingTDInfo, createUser, getServiceId_UMG(wsaHeader.getTo()));
		}

        return response;
    }
	private CreateUserResponse callWsUserManagementCreateUser_GVP(RoutingTDInfo routingTDInfo, CreateUser createUser, com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType serviceID) throws Exception {
		List<Endpoint> endpointList = routingTDInfo.getEndpoints();

		String url = endpointList.get(0).getTargetEndpoint();
		int instanceId = endpointList.get(0).getInstanceID();
		int platformId = endpointList.get(0).getPlatformID();

		UserDataContract userDataContract = new UserDataContract();
		userDataContract = CREATE_USER_REQUEST_MAPPER.userDataMapper(createUser.getUserCreation());
		userDataContract.setServiceType(serviceID);

		ResultDataContractOfstring resultDataContractOfstring = new ResultDataContractOfstring();

		wsITDregistrationService.setURL(url);
		resultDataContractOfstring = wsITDregistrationService.createUser(instanceId, platformId, userDataContract);

		return CREATE_USER_RESPONSE_MAPPER.createUserResponseMapper(resultDataContractOfstring);
	}

	private CreateUserResponse callWsUserManagementCreateUser_UMG(RoutingTDInfo routingTDInfo, CreateUser createUser, ServiceIdType serviceID) throws Exception {
		List<Endpoint> endpointList = routingTDInfo.getEndpoints();

		String url = endpointList.get(0).getTargetEndpoint();
		int instanceId = endpointList.get(0).getInstanceID();
		int platformId = endpointList.get(0).getPlatformID();

		org.datacontract.schemas._2004._07.gvp_gal.UserDataContract userDataContract = new org.datacontract.schemas._2004._07.gvp_gal.UserDataContract();
		userDataContract = CREATE_USER_REQUEST_MAPPER_UMG.userDataMapper(createUser.getUserCreation());
		userDataContract.setServiceId(serviceID);

		org.datacontract.schemas._2004._07.gvp_gal.ResultDataContractOfstring resultDataContractOfstring = new org.datacontract.schemas._2004._07.gvp_gal.ResultDataContractOfstring();
		wsITDregistrationService_umg.setURL(url);
		resultDataContractOfstring = wsITDregistrationService_umg.createUser(instanceId, platformId, userDataContract.getServiceId(),userDataContract);

		return CREATE_USER_RESPONSE_MAPPER_UMG.createUserResponseMapper(resultDataContractOfstring);
	}

	private void isPresentEmail(final String email) {
		Optional<String> emailIptv = Optional.ofNullable(email);
		emailIptv.orElseThrow(NumberFormatException::new); // TODO Si no existe el campo email, Llamada al servicio de errores
	}

	private ServiceIdType getServiceId_UMG(String to){
    	if (to.contains("OTT") && to.contains("IPTV")){
			return ServiceIdType.fromValue("OTT and IPTV ");
		} else if (to.contains("IPTV")) {
			return ServiceIdType.fromValue("IPTV");
		} else if (to.contains("OTT")) {
			return ServiceIdType.fromValue("OTT");
		}
		return null;
	}

	private com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType getServiceId_GVP(String to){
		if (to.contains("OTT") && to.contains("IPTV")){
			return com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType.fromValue("OTT and IPTV ");
		} else if (to.contains("IPTV")) {
			return com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType.fromValue("IPTV");
		} else if (to.contains("OTT")) {
			return com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType.fromValue("OTT");
		}
		return null;
	}
}
