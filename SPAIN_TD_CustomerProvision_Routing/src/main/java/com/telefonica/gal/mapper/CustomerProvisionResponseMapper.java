package com.telefonica.gal.mapper;

import com.telefonica.gal.customerProvision.response.CUSTOMER;
import com.telefonica.gal.provisionApi.model.Result;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.http.ResponseEntity;

@Mapper
public interface CustomerProvisionResponseMapper {
    @Mapping(target = "USERID", source = "uniqueId")
    @Mapping(target = "OPERATIONID", source = "userId")
    @Mapping(target = "RESULTCODE", source = "resultCode")
    @Mapping(target = "DESCRIPTION", source = "description")

    CUSTOMER transformationResponse(Result result);

}
