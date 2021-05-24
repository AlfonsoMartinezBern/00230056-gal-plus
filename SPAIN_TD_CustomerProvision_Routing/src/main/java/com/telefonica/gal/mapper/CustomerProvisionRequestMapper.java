package com.telefonica.gal.mapper;

import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.LISTTVSERVICES;
import com.telefonica.gal.customerProvision.request.LISTVODSERVICES;
import com.telefonica.gal.customerProvision.request.ObjectFactory;
import com.telefonica.gal.customerProvision.request.OperationType;
import com.telefonica.gal.customerProvision.request.TVSERVICE;
import com.telefonica.gal.customerProvision.request.VODSERVICE;
import com.telefonica.gal.provisionApi.model.ProductOperation;
import com.telefonica.gal.provisionApi.model.Subscription;
import com.telefonica.gal.provisionApi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = ObjectFactory.class)
public interface CustomerProvisionRequestMapper {

    @Mapping(source = "USERID", target = "uniqueId")
    @Mapping(constant = "IPTV", target = "serviceType")
    @Mapping(source = "USERTYPE", target = "commercialOffer")
    @Mapping(source = "SERVICETYPE", target = "application")
    @Mapping(target = "addressing", expression = "java(checkAddressing(cUSTOMER))")
    @Mapping(source = "LISTSTBIPS.STBIP", target = "stbIps")
    @Mapping(source = "MAXNUMSTBS", target = "maxDevices")
    @Mapping(target = "tvHd", expression = "java(checkTvHD(cUSTOMER))")
    @Mapping(source = "LINEQUALITY" , target = "lineQuality")
    @Mapping(source = "LIMITVODPURCHASES", target = "limitVodPurchases")
    @Mapping(source = "LIMITPPVPURCHASES", target = "limitPPVPurchases")
    @Mapping(source = "LIMITUSERBONUSPURCHASES", target = "limitUserBonusPurchases")
    @Mapping(source = "SUBSCRIBERLINE.UPSTREAM", target = "subscriberLineUpstream")
    @Mapping(source = "SUBSCRIBERLINE.DOWNSTREAM", target = "subscriberLineDownstream")
    @Mapping(source = "GEOGRAFICAREA" , target = "userVideoServiceInfo.geographicArea")
    @Mapping(source = "POP" , target = "userVideoServiceInfo.serverCodeList")
    @Mapping(constant = "SNAPSHOT", target = "products.productsMode")
    @Mapping(target = "products.subscriptionsList", expression = "java(getSuscriptionsList(cUSTOMER))")
    User customerDataMapper(CUSTOMER cUSTOMER);

    default String checkAddressing(CUSTOMER cUSTOMER) {
        String addressing = cUSTOMER.getADDRESSING();
        if (addressing.isEmpty() || addressing.equals("") && addressing == "") {
            return "STATIC_IP";
        }
        return addressing;
    }

    default Integer checkTvHD(CUSTOMER customer) {
        String tvhd = customer.getTVHD();
        if (!tvhd.isEmpty() && !tvhd.equals("") && tvhd != "") {
            return Integer.valueOf(tvhd);
        }
        return 0;
    }

    default List<Subscription> getSuscriptionsList(CUSTOMER customer) {
        LISTTVSERVICES listtvservices = customer.getLISTTVSERVICES();
        LISTVODSERVICES listvodservices = customer.getLISTVODSERVICES();
        Subscription subscription = new Subscription();
        List<Subscription> subscriptionList = new ArrayList<>();;

        for(TVSERVICE tvservice : listtvservices.getTVSERVICE()) {
            subscription = new Subscription();
            subscription.setOperation(getOperation(tvservice.getTVSERVICEOPER()));
            subscription.setPendingConsolidation(0);
            subscription.setProductId(tvservice.getTVSERVICEID());
            subscriptionList.add(subscription);
        }

        for(VODSERVICE vodservice : listvodservices.getVODSERVICE()) {
            subscription = new Subscription();
            subscription.setOperation(getOperation(vodservice.getVODSERVICEOPER()));
            subscription.setPendingConsolidation(0);
            subscription.setProductId(vodservice.getVODSERVICEID());
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
