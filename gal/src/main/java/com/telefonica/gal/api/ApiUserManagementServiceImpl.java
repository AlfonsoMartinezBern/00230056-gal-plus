package com.telefonica.gal.api;

import com.telefonica.gal.service.userManagement.UserManagementService;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Endpoint
public class ApiUserManagementServiceImpl implements ApiUserManagementService {
    public static final String NAMESPACE = "http://www.telefonica.com/wsdl/UNICA/SOAP/OProv_Management/v7/local";

    private final HttpServletRequest httpServletRequest;

    private final UserManagementService userManagementService;

    public ApiUserManagementServiceImpl(UserManagementService userManagementService, HttpServletRequest httpServletRequest) {
        this.userManagementService = userManagementService;
        this.httpServletRequest = httpServletRequest;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "createUser")
    @ResponsePayload
    public CreateUserResponse callWsUserManagementCreateUser(@RequestPayload CreateUser createUserRequest) {

        Enumeration<String> headers = httpServletRequest.getHeaderNames();

        while (headers.hasMoreElements()) {
            System.out.println("Header Gal: " + httpServletRequest.getHeader(headers.nextElement()));
        }

        String serviceId = httpServletRequest.getHeader("wsa05");
        //String wsFrom = httpServletRequest.getHeader("wsaFrom");
        CreateUserResponse response = new CreateUserResponse();
        response = userManagementService.callWsUserManagementCreateUser(createUserRequest, serviceId);

        return response;
    }
}
