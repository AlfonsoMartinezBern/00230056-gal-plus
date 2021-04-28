package com.telefonica.gal.service.userManagement;

import com.telefonica.gal.client.dynamicrouting.td.facade.DynamicRoutingTDClient;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.factory.FactoryTD;
import com.telefonica.gal.header.wsa.WSAHeader;
import com.telefonica.gal.interfaceWs.InvokeWs;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.serviceid.ServiceIdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.context.MessageContext;

import java.util.HashMap;
import java.util.Map;
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
	FactoryTD factoryTD;

    public UserManagementServiceImpl() {
	}

    @Override
    public CreateUserResponse callWsUserManagementCreateUser(CreateUser createUser,MessageContext context ) throws Exception {
    	WSAHeader wsaHeader = new WSAHeader(context);
    	CreateUserResponse createUserResponse = new CreateUserResponse();

		String serviceId = wsaHeader.getTo().contains("IPTV")?"IPTV":"OTT";

		if (serviceId.contains("IPTV")) {
			isPresentEmail(createUser.getUserCreation().getEmail());
		}

    	RoutingTDKey tdKey = new RoutingTDKey(serviceId, CreateUser, wsaHeader.getFrom());

		RoutingTDInfo routingTDInfo = dynamicRoutingTD.search(tdKey);
		Object serviceIdType = new Object();

		switch (routingTDInfo.getEndpoints().get(0).getEndpointType()) {
			case GVP:
				serviceIdType = getServiceId_GVP(wsaHeader.getTo());
				 break;
			case UMG:
				serviceIdType = getServiceId_UMG(wsaHeader.getTo());
				 break;
			default:
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ServiceId", serviceIdType);
		map.put("Operation", CreateUser);

		//Invoke Factory
		InvokeWs invokeWs = factoryTD.getInvokeWs(routingTDInfo, createUser, map);
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
