package com.telefonica.gal.transform;


import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ObjectFactory.class)
public interface CreateUserResponseMapper {
    @Mapping(source = "response", target = "globalUserID")
    CreateUserResponse createUserResponseMapper(gal.gvp.CreateUserResponse response);
}
