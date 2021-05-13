package com.telefonica.gal.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.gal.client.dynamicrouting.td.facade.DynamicRoutingTD;
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

    private final static CustomerProvisionRequestMapper CUSTOMER_PROVISION_REQUEST_MAPPER = Mappers.getMapper(
            CustomerProvisionRequestMapper.class);

    @Autowired
    DynamicRoutingTD dynamicRouting;

    @PostMapping("/prueba")
    public void prueba() throws IOException, ParserConfigurationException, SAXException {
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

        // CUSTOMERPROVISIONRESPONSE res = invokeRESTService("MiViewTv", request, map);
        CUSTOMERPROVISIONRESPONSE res0 = invokeRESTService("TOP+", request, map);
    }

    public CUSTOMERPROVISIONRESPONSE invokeRESTService(String routingTD, CUSTOMERPROVISIONREQUEST request, Map<String, Object> hashMap) {
        // TODO DynamicRoutingTD
        switch (routingTD) {
            case "TOP+":
                return invokeTOPService3("http://localhost:1234/customerprovision/top", (CUSTOMERPROVISIONREQUEST) request);
            case "MiViewTv":
                return invokeMiViewService("http://localhost:1234/customerprovision/miview", (CUSTOMERPROVISIONREQUEST) request);
            default:
                return null; // TODO devolver ERROR
        }

    }

    public CUSTOMERPROVISIONRESPONSE invokeTOPService(String url, CUSTOMERPROVISIONREQUEST request) {
        try {
            ArrayList<User> users = new ArrayList<>();
            HttpURLConnection conexion = (HttpURLConnection) new URL(url).openConnection();
            conexion.setRequestMethod("POST");
            for (CUSTOMER customer : request.getCUSTOMERS().getCUSTOMER()) {
                conexion.setRequestProperty("user", CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer).toString().replaceAll("\n", " "));
            }
            conexion.connect();

            //Almacenamos la respuesta
            InputSource resultado = new InputSource(conexion.getInputStream());

            //convertimos la respuesta que viene en binario a un archivo xml
            Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resultado);
            conexion.disconnect();

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // TODO return ERROR;
        }
    }

    public CUSTOMERPROVISIONRESPONSE invokeMiViewService(String path, CUSTOMERPROVISIONREQUEST request) {
        try {
            URL url = new URL(path); // TODO recuperar del routingTDInfo
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            ArrayList<User> users = new ArrayList<>();

            for (CUSTOMER customer : request.getCUSTOMERS().getCUSTOMER()) {
                connection.setRequestProperty("user", customer.toString());
            }

            Map<String, List<String>> headers = connection.getHeaderFields();
            CUSTOMERPROVISIONRESPONSE results = new CUSTOMERPROVISIONRESPONSE();

            InputStream stream = connection.getInputStream();
            String response = new Scanner(stream).next(); //TODO trasnformar response a CUSTOMERPROVISIONRESPONSE

        } catch (Exception e) {
            e.printStackTrace();
            // TODO return ERROR;
        }

        return null;

    }

    public CUSTOMERPROVISIONRESPONSE invokeTOPService2(String url, CUSTOMERPROVISIONREQUEST request) {
        try {
            ArrayList<User> users = new ArrayList<>();
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");

            for (CUSTOMER customer : request.getCUSTOMERS().getCUSTOMER()) {
                String prueba = new JSONObject(CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer)
                        .toString().replaceAll("\n", ",").replace("class User {,", "{")
                        .replace(",}", "}")).toString().replaceAll("\"", "").replace("{", "").replace("}", "");
                connection.setRequestProperty("user", prueba);
            }

            connection.connect();
            Object object = connection.getContent();

            InputStreamReader inStream = new InputStreamReader(connection.getInputStream(), "utf-8");
            BufferedReader br = new BufferedReader(inStream);
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }

            connection.getOutputStream();
            connection.disconnect();

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // TODO return ERROR;
        }
    }

    public CUSTOMERPROVISIONRESPONSE invokeTOPService3(String url, CUSTOMERPROVISIONREQUEST request) {
        RestTemplate restTemplate = new RestTemplate();
        CUSTOMERPROVISIONRESPONSE result = new CUSTOMERPROVISIONRESPONSE();
        try {
            for (CUSTOMER customer : request.getCUSTOMERS().getCUSTOMER()) {
                HttpEntity<String> entityRequest = new HttpEntity<>(new JSONObject(CUSTOMER_PROVISION_REQUEST_MAPPER.customerDataMapper(customer)
                        .toString().replaceAll("\n", ",").replace("class User {,", "{")
                        .replace(",}", "}")).toString().replaceAll("\"", "")
                        .replace("{", "").replace("}", ""));
                /*ResponseEntity<com.telefonica.gal.customerProvision.response.CUSTOMER> response = restTemplate
                        .getForEntity(url, com.telefonica.gal.customerProvision.response.CUSTOMER.class);*/
                ResponseEntity<com.telefonica.gal.customerProvision.response.CUSTOMER> response = restTemplate
                        .exchange(url, HttpMethod.POST,
                                entityRequest,
                                com.telefonica.gal.customerProvision.response.CUSTOMER.class);
                result.getCUSTOMERS().getCUSTOMER().add(response.getBody());
            }
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return result;
        }
    }

    // public JSONObject mapperXMLtoJSON(String xml) {return XML.toJSONObject(xml);}
}
