package com.telefonica.gal.transform;

import com.telefonica.gal.wsdl.southbound.gvp.CreateUserResponse;
import com.telefonica.gal.wsdl.southbound.gvp.ResultDataContractOfstring;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ObjectFactory.class)
public interface CreateUserResponseMapper {
    @Mapping(source = "response", target = "createUserResult")
    CreateUserResponse createUserResponseMapper(ResultDataContractOfstring response);
}
