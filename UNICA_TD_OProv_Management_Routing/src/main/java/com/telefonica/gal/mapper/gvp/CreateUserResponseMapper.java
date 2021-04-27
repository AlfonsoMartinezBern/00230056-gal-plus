package com.telefonica.gal.mapper.gvp;

import com.telefonica.gal.mapper.ObjectFactory;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ObjectFactory.class)
public interface CreateUserResponseMapper {
    @Mapping(source = "response.statusCode", target = "globalUserID.alias")
    CreateUserResponse createUserResponseMapper(ResultDataContractOfstring response);
}
