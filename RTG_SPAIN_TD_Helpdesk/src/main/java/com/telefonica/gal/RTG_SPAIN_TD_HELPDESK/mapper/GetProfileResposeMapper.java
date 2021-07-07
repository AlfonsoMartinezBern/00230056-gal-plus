package com.telefonica.gal.RTG_SPAIN_TD_HELPDESK.mapper;

import com.telefonica.gal.provisionApi.model.UserResponse;
import com.telefonica.gal.wsdl.getProfile.GetProfileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = GetProfileResposeMapper.class)
public interface GetProfileResposeMapper {

    GetProfileResposeMapper INSTANCE = Mappers.getMapper( GetProfileResposeMapper.class );

    @Mapping(source = "userVideoServiceInfo.geographicArea", target = "customer_profile.geograficAreaId")
    @Mapping(source = "userVideoServiceInfo.geographicAreaDesc", target = "customer_profile.geograficAreaDesc")
    @Mapping(source = "commercialOffer", target = "customer_profile.userType")
    @Mapping(source = "application", target = "customer_profile.serviceTypeId")
    @Mapping(source = "applicationDesc", target = "customer_profile.serviceTypeDesc")
    @Mapping(source = "tvHd", target = "customer_profile.hdTV")
    @Mapping(source = "limitVodPurchases", target = "customer_profile.limitVodPurchases")
    @Mapping(source = "limitPPVPurchases", target = "customer_profile.limitPpvPurchases")
    @Mapping(source = "limitUserBonusPurchases", target = "customer_profile.limitUserVoucherPurchases")
    @Mapping(source = "addressing", target = "customer_profile.addressing")
    @Mapping(source = "stbIps", target = "customer_profile.ipStbList")
    @Mapping(source = "maxDevices", target = "customer_profile.maxNumStbs")
    @Mapping(source = "subscriberLineUpstream", target = "customer_profile.upStreamSubscriberLine")
    @Mapping(source = "subscriberLineDownstream", target = "customer_profile.downStreamSubscriberLine")
    GetProfileResponse mapTOPResponse(UserResponse userResponse);
}
