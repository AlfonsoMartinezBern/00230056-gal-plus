package com.telefonica.gal.service.registrationService;

import com.telefonica.gal.header.wsa.WSAHeader;
import com.telefonica.gal.wsdl.southbound.registration.GetAccountForDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.context.MessageContext;
import com.telefonica.gal.factory.FactoryRouting;

@Service
public class IdentityManagementPortServiceImpl implements IdentityManagementPortService {

    private final static String AuthenticateUser = "AuthenticateUser";
    private final static String GVP = "GVP.GAL";
    private final static String UMG = "UMG";

    // @Autowired
    // DynamicRoutingBUClient dynamicRoutingBU;

    @Autowired
    FactoryRouting factoryRouting;

    @Override
    public void callWsAuthenticateUser(GetAccountForDevice getAccountForDevice, MessageContext context) throws Exception {
        WSAHeader wsaHeader = new WSAHeader(context);

        // TODO DynamicRoutingBU
        // RoutingBUKey buKey = new RoutingBUKey(AuthenticateUser, getAccountForDevice.getInstanceId(), getAccountForDevice.getPlatformId());
        // RoutingBUInfo routingBUInfo = DynamicRoutingBU(buKey)

        // TODO InvokeWs
        // InvokeWs invokeWs = factoryRouting.getInvokeWs(routingBUInfo, GetAccountForDevice);
        // invokeWs.invoke();
    }
}
