package com.telefonica.gal.factory;

import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.request.CUSTOMERS;
import com.telefonica.gal.customerProvision.request.LISTSTBIPS;
import com.telefonica.gal.customerProvision.request.SUBSCRIBERLINE;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/prueba")
@Component
public class FactoryTD<T> {

    @Autowired
    InvokeRESTFactory invokeRESTFactory;

    /*@Autowired
    DynamicRoutingTD dynamicRouting;*/

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
        //CUSTOMERPROVISIONRESPONSE res = invokeRESTService("TOP+", request, map);
        return null;
        // CUSTOMERPROVISIONRESPONSE res = invokeRESTService("MiViewTv", request, map);
    }

    public CUSTOMERPROVISIONRESPONSE invokeRESTService(T routingTD, T request, Map<String, Object> hashMap) {
        // TODO DynamicRoutingTD
        //RoutingTDInfo info = getRoutingTDInfo((RoutingTDKey) routingTD);
        switch ("") {
            case "TOP+":
                return invokeRESTFactory.invokeTOPService("http://localhost:1234/customerprovision/top", (CUSTOMERPROVISIONREQUEST) request);
            case "MiViewTv":
                return invokeRESTFactory.invokeMiViewService("http://localhost:1234/customerprovision/miview", (CUSTOMERPROVISIONREQUEST) request);
            default:
                return null; // TODO devolver ERROR
        }
    }

    /*private RoutingTDInfo getRoutingTDInfo(RoutingTDKey key){
        RoutingTDInfo info = new RoutingTDInfo();

        return null;
    }*/

    // public JSONObject mapperXMLtoJSON(String xml) {return XML.toJSONObject(xml);}
}
