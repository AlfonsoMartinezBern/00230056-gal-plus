package com.telefonica.gal.factory;

import com.telefonica.gal.client.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.client.dynamicrouting.td.msg.Flow;
import com.telefonica.gal.client.dynamicrouting.td.msg.RoutingTDInfo;
import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.CUSTOMERPROVISIONREQUEST;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.mapper.CustomerProvisionRequestMapper;
import com.telefonica.gal.provisionApi.model.User;
import org.json.JSONObject;
import org.json.XML;
import org.mapstruct.factory.Mappers;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

public class FactoryTD<T> {

    private final static CustomerProvisionRequestMapper CUSTOMER_PROVISION_REQUEST_MAPPER = Mappers.getMapper(
            CustomerProvisionRequestMapper.class);

    public CUSTOMERPROVISIONRESPONSE invokeRESTService(T routingTD, T request, Map<String, Object> hashMap) {
        // CUSTOMERPROVISIONRESPONSE response = new CUSTOMERPROVISIONRESPONSE();


        return null;
    }

    public CUSTOMERPROVISIONRESPONSE invokeTOPService(CUSTOMERPROVISIONREQUEST request){
        try {
            URL url = new URL("host+path TOP+");
            HttpsURLConnection connection = null;
            connection = (HttpsURLConnection) url.openConnection();

            ArrayList<User> users = new ArrayList<>();

            for (CUSTOMER customer : request.getCUSTOMERS().getCUSTOMER()){
                users.add(CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer));
            }

            for (User user : users){
                connection.setRequestProperty("¿?", user.toString());
            }

            Map<String, List<String>> headers = connection.getHeaderFields();
            CUSTOMERPROVISIONRESPONSE results = new CUSTOMERPROVISIONRESPONSE();

            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).next();
            JSONObject jsonResponse = new JSONObject(response); //TODO trasnformar a CUSTOMERPROVISIONRESPONSE

        } catch (IOException e) {
            e.printStackTrace();
            // TODO return ERROR;
        }
        return null;
    }

    public CUSTOMERPROVISIONRESPONSE invokeMiViewService(CUSTOMERPROVISIONREQUEST request){
        try {
            URL url = new URL("host+path MiView");
            HttpsURLConnection connection = null;
            connection = (HttpsURLConnection) url.openConnection();

            ArrayList<User> users = new ArrayList<>();

            for (CUSTOMER customer : request.getCUSTOMERS().getCUSTOMER()){
                connection.setRequestProperty("¿?", customer.toString());
            }

            Map<String, List<String>> headers = connection.getHeaderFields();
            CUSTOMERPROVISIONRESPONSE results = new CUSTOMERPROVISIONRESPONSE();

            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).next(); //TODO trasnformar response a CUSTOMERPROVISIONRESPONSE

        } catch (IOException e) {
            e.printStackTrace();
            // TODO return ERROR;
        }
        return null;
    }

    // public JSONObject mapperXMLtoJSON(String xml) {return XML.toJSONObject(xml);}
}
