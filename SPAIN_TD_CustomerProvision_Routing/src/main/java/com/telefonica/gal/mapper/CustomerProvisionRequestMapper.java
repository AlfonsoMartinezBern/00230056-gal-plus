package com.telefonica.gal.mapper;

import com.telefonica.gal.client.spain.dynamicrouting.td.msg.Endpoint;
import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.LISTTVSERVICES;
import com.telefonica.gal.customerProvision.request.LISTVODSERVICES;
import com.telefonica.gal.customerProvision.request.ObjectFactory;
import com.telefonica.gal.customerProvision.request.OperationType;
import com.telefonica.gal.customerProvision.request.TVSERVICE;
import com.telefonica.gal.customerProvision.request.VODSERVICE;
import com.telefonica.gal.dto.customer.Customer;
import com.telefonica.gal.dto.customer.ListTVServices;
import com.telefonica.gal.dto.customer.ListVodServices;
import com.telefonica.gal.dto.customer.TvService;
import com.telefonica.gal.dto.customer.VodService;
import com.telefonica.gal.provisionApi.model.ProductOperation;
import com.telefonica.gal.provisionApi.model.Subscription;
import com.telefonica.gal.provisionApi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = ObjectFactory.class)
public interface CustomerProvisionRequestMapper {

    @Mapping(source = "customer.userid", target = "uniqueId")
    @Mapping(constant = "IPTV", target = "serviceType")
    @Mapping(source = "customer.usertype", target = "commercialOffer")
    @Mapping(source = "customer.servicetype", target = "application")
    @Mapping(source = "endpoint.platformID", target = "platformId")
    @Mapping(target = "addressing", expression = "java(checkAddressing(customer))")
    @Mapping(source = "customer.liststbips.stbip", target = "stbIps")
    @Mapping(source = "customer.maxnumstbs", target = "maxDevices")
    @Mapping(target = "tvHd", expression = "java(checkTvHD(customer))")
    @Mapping(source = "customer.linequality" , target = "lineQuality")
    @Mapping(source = "customer.limitvodpurchases", target = "limitVodPurchases")
    @Mapping(source = "customer.limitppvpurchases", target = "limitPPVPurchases")
    @Mapping(source = "customer.limituserbonuspurchases", target = "limitUserBonusPurchases")
    @Mapping(source = "customer.subscriberline.upstream", target = "subscriberLineUpstream")
    @Mapping(source = "customer.subscriberline.downstream", target = "subscriberLineDownstream")
    @Mapping(source = "customer.geograficarea" , target = "userVideoServiceInfo.geographicArea")
    @Mapping(source = "customer.pop" , target = "userVideoServiceInfo.serverCodeList")
    @Mapping(constant = "SNAPSHOT", target = "products.productsMode")
    @Mapping(target = "products.subscriptionsList", expression = "java(getSuscriptionsList(customer))")
    //User customerDataMapper(CUSTOMER customer, Endpoint endpoint);
    User customerDataMapper(Customer customer, Endpoint endpoint);

    default String checkAddressing(Customer customer) {
        String addressing = customer.getAddressing();
        if (addressing.isEmpty() || addressing.equals("") && addressing == "") {
            return "STATIC_IP";
        }
        return addressing;
    }

    default Integer checkTvHD(Customer customer) {
        String tvhd = customer.getTvhd();
        if (!tvhd.isEmpty() && !tvhd.equals("") && tvhd != "") {
            return Integer.valueOf(tvhd);
        }
        return 0;
    }

    default List<Subscription> getSuscriptionsList(Customer customer) {
        /*LISTTVSERVICES listtvservices = customer.getLISTTVSERVICES();
        LISTVODSERVICES listvodservices = customer.getLISTVODSERVICES();*/
        ListTVServices listtvservices = customer.getListtvservices();
        ListVodServices listvodservices = customer.getListvodservices();

        Subscription subscription = new Subscription();
        List<Subscription> subscriptionList = new ArrayList<>();;

        for(TvService tvservice : listtvservices.getTvservice()) {
            subscription = new Subscription();
            subscription.setOperation(getOperation(tvservice.getTvserviceoper()));
            subscription.setPendingConsolidation(0);
            subscription.setProductId(tvservice.getTvserviceid());
            subscriptionList.add(subscription);
        }

        for(VodService vodservice : listvodservices.getVodservice()) {
            subscription = new Subscription();
            subscription.setOperation(getOperation(vodservice.getVodserviceoper()));
            subscription.setPendingConsolidation(0);
            subscription.setProductId(vodservice.getVodserviceid());
            subscriptionList.add(subscription);
        }

        return subscriptionList;
    }

    default ProductOperation getOperation(OperationType operationType) {
        ProductOperation productOperation = ProductOperation.ON;

        switch (operationType) {
            case ON:
                productOperation = ProductOperation.ON;
                break;
            case OFF:
                productOperation = ProductOperation.OFF;
                break;
            case KEEP:
                productOperation = ProductOperation.KEEP;
                break;

        }

        return productOperation;

    }

}
