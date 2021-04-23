package com.telefonica.gal.service.userManagement;

import com.telefonica.gal.client.dynamicrouting.td.facade.DynamicRoutingTDClient;
import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.factory.FactoryRouting;
import com.telefonica.gal.header.wsa.WSAHeader;
import com.telefonica.gal.wsRouting.InvokeWs;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.serviceid.ServiceIdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.context.MessageContext;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	private final static String CreateUser = "CreateUser";
	private final static String GVP = "GVP.GAL";
	private final static String UMG = "UMG";
	private final static String UNKNOWN = "Unknown";

    @Autowired
    DynamicRoutingTDClient dynamicRoutingTD;

    @Autowired
	FactoryRouting factoryRouting;

    public UserManagementServiceImpl() {
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
			case GVP:
				return callWsUserManagementCreateUser_GVP(routingTDInfo, createUser, getServiceId_GVP(wsaHeader.getTo()));
			case UMG:
				return callWsUserManagementCreateUser_UMG(routingTDInfo, createUser, getServiceId_UMG(wsaHeader.getTo()));
		}

        return response;
    }
	private CreateUserResponse callWsUserManagementCreateUser_GVP(RoutingTDInfo routingTDInfo, CreateUser createUser, com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType serviceID) throws Exception {
    	CreateUserResponse createUserResponse = new CreateUserResponse();
		List<Endpoint> endpointList = routingTDInfo.getEndpoints();

		String url = endpointList.get(0).getTargetEndpoint();
		int instanceId = endpointList.get(0).getInstanceID();
		int platformId = endpointList.get(0).getPlatformID();
		//Invoke Factory
		InvokeWs invokeWs = factoryRouting.getInvokeWs(GVP, CreateUser, instanceId, platformId, url, createUser, serviceID);
		createUserResponse = (CreateUserResponse) invokeWs.invoke();

		return createUserResponse;
	}

	private CreateUserResponse callWsUserManagementCreateUser_UMG(RoutingTDInfo routingTDInfo, CreateUser createUser, ServiceIdType serviceID) throws Exception {
    	CreateUserResponse createUserResponse = new CreateUserResponse();
		List<Endpoint> endpointList = routingTDInfo.getEndpoints();

		String url = endpointList.get(0).getTargetEndpoint();
		int instanceId = endpointList.get(0).getInstanceID();
		int platformId = endpointList.get(0).getPlatformID();

		//Invoke Factory
		InvokeWs invokeWs = factoryRouting.getInvokeWs(UMG, CreateUser, instanceId, platformId, url, createUser, serviceID);
		createUserResponse = (CreateUserResponse) invokeWs.invoke();

		return createUserResponse;
	}

	private void isPresentEmail(final String email) {
		Optional<String> emailIptv = Optional.ofNullable(email);
		emailIptv.orElseThrow(NumberFormatException::new); // TODO Si no existe el campo email, Llamada al servicio de errores
	}

	private ServiceIdType getServiceId_UMG(String to){
    	if (to.contains("OTT") && to.contains("IPTV")){
			return ServiceIdType.fromValue("OTT and IPTV");
		} else if (to.contains("IPTV")) {
			return ServiceIdType.fromValue("IPTV");
		} else if (to.contains("OTT")) {
			return ServiceIdType.fromValue("OTT");
		}
		return ServiceIdType.fromValue(UNKNOWN);
	}

	private com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType getServiceId_GVP(String to){
		if (to.contains("OTT") && to.contains("IPTV")){
			return com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType.fromValue("OTTandIPTV");
		} else if (to.contains("IPTV")) {
			return com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType.fromValue("IPTV");
		} else if (to.contains("OTT")) {
			return com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType.fromValue("OTT");
		}
		return com.telefonica.gal.wsdl.southbound.gvp.ServiceIdType.fromValue(UNKNOWN);
	}
}
