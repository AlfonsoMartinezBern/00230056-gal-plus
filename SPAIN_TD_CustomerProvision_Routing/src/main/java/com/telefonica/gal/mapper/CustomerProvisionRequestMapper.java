package com.telefonica.gal.mapper;

import com.telefonica.gal.customerProvision.request.*;
import com.telefonica.gal.provisionApi.model.Product;
import com.telefonica.gal.provisionApi.model.User;
import com.telefonica.gal.provisionApi.model.UserProducts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = ObjectFactory.class)
public interface CustomerProvisionRequestMapper {

    @Mapping(source = "USERID", target = "uniqueId")
    @Mapping(constant = "IPTV", target = "serviceType")
    @Mapping(source = "USERTYPE", target = "commercialOffer")
    @Mapping(source = "GEOGRAFICAREA", target = "geographicArea")
    @Mapping(source = "POP", target = "serverCode")
    @Mapping(source = "SERVICETYPE", target = "application")
    @Mapping(target = "addressing", expression = "java(checkAddressing(customer))")
    @Mapping(source = "LISTSTBIPS.STBIP", target = "stbIps")
    @Mapping(source = "MAXNUMSTBS", target = "maxDevices")
    @Mapping(target = "tvHd", expression = "java(checkTvHD(customer))")
    @Mapping(source = "LINEQUALITY", target = "lineQuality")
    @Mapping(source = "LIMITVODPURCHASES", target = "limitVodPurchases")
    @Mapping(source = "LIMITPPVPURCHASES", target = "limitPPVPurchases")
    @Mapping(source = "LIMITUSERBONUSPURCHASES", target = "limitUserBonusPurchases")
    @Mapping(source = "SUBSCRIBERLINE.UPSTREAM", target = "subscriberLineUpstream")
    @Mapping(source = "SUBSCRIBERLINE.DOWNSTREAM", target = "subscriberLineDOwnstream")
    @Mapping(constant = "SNAPSHOT", target = "products.productsMode")
    @Mapping(target = "products", expression = "java(getSuscriptionsList(customer))")
    User customerDataMapper(CUSTOMER customer);

    default String checkAddressing(CUSTOMER customer) {
        String addressing = customer.getADDRESSING();
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

    default UserProducts getSuscriptionsList(CUSTOMER customer) {
        LISTTVSERVICES listtvservices = customer.getLISTTVSERVICES();
        LISTVODSERVICES listvodservices = customer.getLISTVODSERVICES();
        UserProducts userProducts = new UserProducts();
        Product product = new Product();
        for(TVSERVICE tvservice : listtvservices.getTVSERVICE()){
            product.setProductId(tvservice.getTVSERVICEID());
            userProducts.getSuscriptionsList().add(product);
        }
        for(VODSERVICE vodservice : listvodservices.getVODSERVICE()){
            product.setProductId(vodservice.getVODSERVICEID());
            userProducts.getSuscriptionsList().add(product);
        }
        return userProducts;
    }

    // ArrayList<User> customersDataMapper(CUSTOMERPROVISIONREQUEST customers);

}
