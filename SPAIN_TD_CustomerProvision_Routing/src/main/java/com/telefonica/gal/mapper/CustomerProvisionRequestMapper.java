package com.telefonica.gal.mapper;

import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.ObjectFactory;
import com.telefonica.gal.provisionApi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
    //TODO Products
    User customerDataMapper(CUSTOMER customer);

    default String checkAddressing(CUSTOMER customer){
        String addressing = customer.getADDRESSING();
        if (addressing.isEmpty() || addressing.equals("") && addressing == "" ){
            return "STATIC_IP";
        }
        return addressing;
    }

    default Integer checkTvHD(CUSTOMER customer){
        String tvhd = customer.getTVHD();
        if (!tvhd.isEmpty() && !tvhd.equals("") && tvhd != ""){
            return Integer.valueOf(tvhd);
        }
        return 0;
    }

    // ArrayList<User> customersDataMapper(CUSTOMERPROVISIONREQUEST customers);

}
