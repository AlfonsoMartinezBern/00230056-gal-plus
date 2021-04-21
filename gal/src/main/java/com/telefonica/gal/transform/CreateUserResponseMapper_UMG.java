package com.telefonica.gal.transform;


import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import org.datacontract.schemas._2004._07.gvp_gal.ResultDataContractOfstring;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ObjectFactory.class)
public interface CreateUserResponseMapper_UMG {
    @Mapping(source = "response.statusCode", target = "globalUserID.alias")
    CreateUserResponse createUserResponseMapper(ResultDataContractOfstring response);
}
