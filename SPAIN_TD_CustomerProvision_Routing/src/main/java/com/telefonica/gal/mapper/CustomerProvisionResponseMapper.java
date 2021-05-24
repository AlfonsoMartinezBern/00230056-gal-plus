package com.telefonica.gal.mapper;

import com.telefonica.gal.customerProvision.response.CUSTOMER;
import com.telefonica.gal.provisionApi.model.ResultOK;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerProvisionResponseMapper {
    @Mapping(target = "USERID", source = "uniqueId")
    @Mapping(target = "OPERATIONID", source = "userId")
    CUSTOMER transformationResponse(ResultOK result);

}
