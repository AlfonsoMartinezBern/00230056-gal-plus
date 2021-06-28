package com.telefonica.gal.SPAIN_TD_CustomerProvision.service;

import com.telefonica.gal.SPAIN_TD_CustomerProvision.dto.LogCustomer;
import com.telefonica.gal.SPAIN_TD_CustomerProvision.dto.ServiceInfoCustomer;
import com.telefonica.gal.SPAIN_TD_CustomerProvision.exceptions.ErrorMessage;
import com.telefonica.gal.SPAIN_TD_CustomerProvision.validator.CustomerProvisionValidator;
import com.telefonica.gal.client.spain.dynamicrouting.td.facade.ISpainDynamicRoutingTD;
import com.telefonica.gal.client.spain.dynamicrouting.td.msg.RoutingTDKey;
import com.telefonica.gal.customerProvision.response.CUSTOMER;
import com.telefonica.gal.customerProvision.response.CUSTOMERPROVISIONRESPONSE;
import com.telefonica.gal.customerProvision.response.CUSTOMERS;
import com.telefonica.gal.dto.customer.CustomerProvisionRequest;
import com.telefonica.gal.factory.FactoryTD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.UUID;

@Service
public class CustomerProvisionServiceImpl implements CustomerProvisionService {
    private static Logger loggerWithCustomLayout = LogManager.getLogger("LOGS_CUSTOMER_V1");
    private ServiceInfoCustomer serviceInfoDto = new ServiceInfoCustomer("SPAIN_TD_CustomerProvision");
    private static final String CustomerProvision = "CustomerProvision";

    private ISpainDynamicRoutingTD dynamicRoutingTD;

    private FactoryTD factoryTD;

    private CustomerProvisionValidator customerProvisionValidator = new CustomerProvisionValidator();

    @Autowired
    public CustomerProvisionServiceImpl(ISpainDynamicRoutingTD dynamicRoutingTD, FactoryTD factoryTD) {
        this.dynamicRoutingTD = dynamicRoutingTD;
        this.factoryTD = factoryTD;
    }

    @Override
    public CUSTOMERPROVISIONRESPONSE customersProvision(String xmlRequest) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CustomerProvisionRequest.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            com.telefonica.gal.dto.customer.CustomerProvisionRequest customerProvisionRequest = (com.telefonica.gal.dto.customer.CustomerProvisionRequest)
                    jaxbUnmarshaller.unmarshal(new StringReader(xmlRequest));

            customerProvisionValidator.isValid(customerProvisionRequest);

            return factoryTD.invokeWs(dynamicRoutingTD.search(new RoutingTDKey(CustomerProvision)),
                    customerProvisionRequest, null);

        } catch (ErrorMessage errorMessage) {
           CUSTOMERPROVISIONRESPONSE response = new CUSTOMERPROVISIONRESPONSE();
           CUSTOMERS customers = new CUSTOMERS();
           CUSTOMER customer = new CUSTOMER();
           LogCustomer logCustomer = new LogCustomer();

           customer.setUSERID(errorMessage.getUserid());
           customer.setOPERATIONID(errorMessage.getOperationid());
           customer.setRESULTCODE(new BigInteger(errorMessage.getCodError()));
           customer.setDESCRIPTION(errorMessage.getMessage());

           customers.getCUSTOMER().add(customer);
           response.setCUSTOMERS(customers);

           logCustomer.setIdLog(UUID.randomUUID().toString());
           logCustomer.setServiceInfo(serviceInfoDto);
           logCustomer.setMessage(errorMessage.getMessage());
           loggerWithCustomLayout.error(logCustomer);

            System.out.println("Exception ErrorMessage ........................");

           return response;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

}
