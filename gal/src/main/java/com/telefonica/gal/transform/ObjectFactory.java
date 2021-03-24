package com.telefonica.gal.transform;

import com.telefonica.gal.wsdl.southbound.gvp.ArrayOfUserCustomFieldDataContract;
import com.telefonica.gal.wsdl.southbound.gvp.UserCustomFieldDataContract;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    private final static QName _UserCreationType_QNAME = new QName("http://schemas.datacontract.org/2004/07/GVP.GAL.Model",
            "UniqueId");

    private final static QName _UserCreationTypeEmail_QNAME = new QName("http://schemas.datacontract.org/2004/07/GVP.GAL.Model",
            "Email");

    private final static QName _UserCreationTypePassword_QNAME = new QName("http://schemas.datacontract.org/2004/07/GVP.GAL.Model",
            "CustomFields");


    public ObjectFactory() {
    }

    public ArrayOfUserCustomFieldDataContract arrayOfUserCustomFieldDataContract() {
        return new ArrayOfUserCustomFieldDataContract();
    }

    public UserCustomFieldDataContract userCustomFieldDataContract() {
        return new UserCustomFieldDataContract();
    }

    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GVP.GAL.Model", name = "UniqueId")
    public JAXBElement<String> userCreate(String value) {
        return new JAXBElement<String>(_UserCreationType_QNAME, String.class, value);
    }

    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GVP.GAL.Model", name = "Email")
    public JAXBElement<String> userCreateEmail(String value) {
        return new JAXBElement<String>(_UserCreationTypeEmail_QNAME, String.class, value);
    }

    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GVP.GAL.Model", name = "CustomFields")
    public JAXBElement<ArrayOfUserCustomFieldDataContract> userCreatePassword(ArrayOfUserCustomFieldDataContract value) {
        return new JAXBElement<ArrayOfUserCustomFieldDataContract>(_UserCreationTypePassword_QNAME,
                ArrayOfUserCustomFieldDataContract.class, value);

    }

    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GVP.GAL.Model", name = "CustomFields")
    public JAXBElement<ArrayOfUserCustomFieldDataContract> password(String value) {
        return new JAXBElement(new QName("http://schemas.datacontract.org/2004/07/GVP.GAL.Model","CustomFields"),
                String.class, value);
    }

}
