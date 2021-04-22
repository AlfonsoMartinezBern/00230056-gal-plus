package com.telefonica.gal.mapper.gvp;

import com.telefonica.gal.mapper.ObjectFactory;
import com.telefonica.gal.wsdl.northbound.provManagement.CreateUser;
import com.telefonica.gal.wsdl.southbound.gvp.UserDataContract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ObjectFactory.class)
public interface CreateUserRequestMapper {
    @Mapping(source = "createUser.userCreation.userNickName.alias", target = "uniqueId")
    @Mapping(source = "createUser.userCreation.email", target = "email")
    @Mapping(source = "createUser.userCreation.userPassword", target = "customFields")
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "instanceId", ignore = true)
    @Mapping(target = "EWallet", ignore = true)
    @Mapping(target = "platformId", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "serviceType", ignore = true)
    @Mapping(target = "videoServiceInfo", ignore = true)
    UserDataContract userDataMapper(CreateUser createUser);

    @Mapping(source = "createUser.userCreation.userNickName.alias", target = "uniqueId")
    @Mapping(source = "createUser.userCreation.userPassword", target = "customFields")
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "serviceType", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "instanceId", ignore = true)
    @Mapping(target = "EWallet", ignore = true)
    @Mapping(target = "platformId", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "videoServiceInfo", ignore = true)
    UserDataContract userDataMapper_2(CreateUser createUser);
}
