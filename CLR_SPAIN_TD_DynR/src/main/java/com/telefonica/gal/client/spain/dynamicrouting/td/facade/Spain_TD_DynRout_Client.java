package com.telefonica.gal.client.spain.dynamicrouting.td.facade;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Spain_TD_DynRout_Client implements ISpainDynamicRoutingTD {
    //@Value("${demo.dynamicRouting.uri}")
//    private String URI = "http://192.168.40.14:31659/dynamicConfig/spain/td";
    private String URI = "http://localhost:8081/dynamicConfig/spain/td";

    public RoutingTDInfo search(RoutingTDKey tdkey) {
        String dynamicRoutingURL =
                URI
                        + "/search?operationTD=" + tdkey.getOperationTD();

        RestTemplate plantilla = new RestTemplate();

        return plantilla.getForObject(dynamicRoutingURL, RoutingTDInfo.class);
    }

}
