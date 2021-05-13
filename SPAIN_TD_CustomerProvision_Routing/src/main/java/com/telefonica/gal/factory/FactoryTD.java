package com.telefonica.gal.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.gal.client.dynamicrouting.td.facade.DynamicRoutingTD;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.customerProvision.request.*;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.mapper.CustomerProvisionRequestMapper;
import com.telefonica.gal.provisionApi.model.User;
import org.json.JSONObject;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Controller
@RequestMapping("/prueba")
@Component
public class FactoryTD<T> {

    @Autowired
    InvokeRESTFactory invokeRESTFactory;

    @Autowired
    DynamicRoutingTD dynamicRouting;

    @PostMapping("/prueba")
    public CUSTOMERPROVISIONRESPONSE prueba() throws IOException, ParserConfigurationException, SAXException {
        String uri = "localhost:1234/CustomerProvision/miview";
        CUSTOMER customer = new CUSTOMER();
        customer.setUSERID("1");
        customer.setSERVICETYPE("1");
        customer.setUSERTYPE("1");
        customer.setGEOGRAFICAREA(1);
        customer.setPOP(1);
        customer.setADDRESSING("1");
        LISTSTBIPS liststbips = new LISTSTBIPS();
        //liststbips.getSTBIP().add("STBIP");
        customer.setLISTSTBIPS(liststbips);
        customer.setMAXNUMSTBS(2);
        customer.setTVHD("1");
        customer.setLINEQUALITY("1");
        customer.setLIMITPPVPURCHASES(3);
        customer.setLIMITVODPURCHASES(4);
        customer.setLIMITUSERBONUSPURCHASES(2);
        SUBSCRIBERLINE subscriberline = new SUBSCRIBERLINE();
        subscriberline.setDOWNSTREAM(1);
        subscriberline.setUPSTREAM(2);
        customer.setSUBSCRIBERLINE(subscriberline);
        CUSTOMERS customers = new CUSTOMERS();
        customers.getCUSTOMER().add(customer);
        CUSTOMERPROVISIONREQUEST request = new CUSTOMERPROVISIONREQUEST();
        request.setCUSTOMERS(customers);
        request.setVersion("1.0.0");

        HashMap<String, Object> map = new HashMap<>();
        CUSTOMERPROVISIONRESPONSE res = invokeRESTService("TOP+", request, map);
        return res;
        // CUSTOMERPROVISIONRESPONSE res = invokeRESTService("MiViewTv", request, map);
    }

    public CUSTOMERPROVISIONRESPONSE invokeRESTService(T routingTD, T request, Map<String, Object> hashMap) {
        // TODO DynamicRoutingTD
        RoutingTDInfo info = getRoutingTDInfo((RoutingTDKey) routingTD);
        switch ("") {
            case "TOP+":
                return invokeRESTFactory.invokeTOPService("http://localhost:1234/customerprovision/top", (CUSTOMERPROVISIONREQUEST) request);
            case "MiViewTv":
                return invokeRESTFactory.invokeMiViewService("http://localhost:1234/customerprovision/miview", (CUSTOMERPROVISIONREQUEST) request);
            default:
                return null; // TODO devolver ERROR
        }
    }

    private RoutingTDInfo getRoutingTDInfo(RoutingTDKey key){
        RoutingTDInfo info = new RoutingTDInfo();

        return null;
    }

    // public JSONObject mapperXMLtoJSON(String xml) {return XML.toJSONObject(xml);}
}
