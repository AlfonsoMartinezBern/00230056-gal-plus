package com.telefonica.gal.transform;

import com.telefonica.gal.wsdl.northbound.provManagement.UserCreationType;
import org.datacontract.schemas._2004._07.gvp_gal.UserDataContract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ObjectFactory.class)
public interface CreateUserRequestMapper_UMG {

    @Mapping(source = "userCreationType.userNickName.alias", target = "uniqueId")
    @Mapping(source = "userCreationType.email", target = "email")
    @Mapping(target = "customFields", ignore = true)
    @Mapping(target = "serviceId", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "instanceId", ignore = true)
    @Mapping(target = "EWallet", ignore = true)
    @Mapping(target = "platformId", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "videoServiceAdditionalInfo", ignore = true)
    UserDataContract userDataMapper(UserCreationType userCreationType);

    @Mapping(source = "userCreationType.userNickName.alias", target = "uniqueId")
    @Mapping(source = "userCreationType.userPassword", target = "customFields")
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "serviceId", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "instanceId", ignore = true)
    @Mapping(target = "EWallet", ignore = true)
    @Mapping(target = "platformId", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "videoServiceAdditionalInfo", ignore = true)
    UserDataContract userDataMapper_2(UserCreationType userCreationType);

}