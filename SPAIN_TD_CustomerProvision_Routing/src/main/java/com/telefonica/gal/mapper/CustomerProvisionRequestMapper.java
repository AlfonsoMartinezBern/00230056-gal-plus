package com.telefonica.gal.mapper;

import com.telefonica.gal.customerProvision.request.CUSTOMER;
import com.telefonica.gal.customerProvision.request.ObjectFactory;
import com.telefonica.gal.provisionApi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ObjectFactory.class)
public interface CustomerProvisionRequestMapper {

    @Mapping(source = "userid", target = "uniqueId")
    @Mapping(defaultValue = "IPTV", target = "serviceType")
    @Mapping(source = "usertype", target = "commercialOffer")
    @Mapping(source = "geograficarea", target = "geographicArea")
    @Mapping(source = "pop", target = "serverCode")
    @Mapping(source = "servicetype", target = "application")
    @Mapping(target = "addressing", expression = "java(checkAddressing(addressing))")
    @Mapping(source = "liststbips.stbip", target = "stbIps")
    @Mapping(source = "maxnumstbs", target = "maxDevices")
    @Mapping(target = "tvHd", expression = "java(checkTvHD(tvhd))")
    @Mapping(source = "linequality", target = "lineQuality")
    @Mapping(source = "limitvodpurchases", target = "limitVodPurchases")
    @Mapping(source = "limitppvpurchases", target = "limitPPVPurchases")
    @Mapping(source = "limituserbonuspurchases", target = "limitUserBonusPurchases")
    @Mapping(source = "subscriberline.upstream", target = "subscriberLineUpstream")
    @Mapping(source = "subscriberline.downstream", target = "subscriberLineDOwnstream")
    User customerDataMapper(CUSTOMER customer);

    default String checkAddressing(String addressing){
        if (addressing.isEmpty() || addressing.equals("") && addressing == "" ){
            return "STATIC_IP";
        }
        return addressing;
    }

    default Integer checkTvHD(String tvhd){
        if (!tvhd.isEmpty() && !tvhd.equals("") && tvhd != ""){
            return Integer.valueOf(tvhd);
        }
        return 0;
    }

    // ArrayList<User> customersDataMapper(CUSTOMERPROVISIONREQUEST customers);

}
