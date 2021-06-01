package com.telefonica.gal.mapper;

import com.telefonica.gal.provisionApi.model.ProductOperation;
import com.telefonica.gal.provisionApi.model.Subscription;
import com.telefonica.gal.provisionApi.model.User;
import com.telefonica.gal.servicesConsolidation.request.CUSTOMER;
import com.telefonica.gal.servicesConsolidation.request.LISTTVSERVICES;
import com.telefonica.gal.servicesConsolidation.request.LISTVODSERVICES;
import com.telefonica.gal.servicesConsolidation.request.ObjectFactory;
import com.telefonica.gal.servicesConsolidation.request.OperationType;
import com.telefonica.gal.servicesConsolidation.request.TVSERVICE;
import com.telefonica.gal.servicesConsolidation.request.VODSERVICE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.ArrayList;
import java.util.List;

@Mapper(uses = ObjectFactory.class)
public interface ServicesConsolidationRequestMapper {

    @Mapping(constant = "IPTV", target = "serviceType")
    @Mapping(constant = "INCREMENTAL", target = "products.productsMode")
    @Mapping(target = "products.subscriptionsList", expression = "java(getSuscriptionsList(cUSTOMER))")
    @Mapping(source = "USERID", target = "uniqueId")
    User servicesConsolidationMapper(CUSTOMER cUSTOMER);

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
