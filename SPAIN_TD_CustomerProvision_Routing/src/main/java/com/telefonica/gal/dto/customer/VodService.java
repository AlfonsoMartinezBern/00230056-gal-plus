package com.telefonica.gal.dto.customer;

import com.telefonica.gal.customerProvision.request.OperationType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "vodserviceid",
        "vodserviceoper"
})
@XmlRootElement(name = "VOD_SERVICE")
public class VodService {
    @XmlElement(name = "VOD_SERVICE_ID", required = true)
    protected String vodserviceid;
    @XmlElement(name = "VOD_SERVICE_OPER")
    @XmlSchemaType(name = "string")
    protected OperationType vodserviceoper;

    public String getVodserviceid() {
        return vodserviceid;
    }

    public void setVodserviceid(String vodserviceid) {
        this.vodserviceid = vodserviceid;
    }

    public OperationType getVodserviceoper() {
        return vodserviceoper;
    }

    public void setVodserviceoper(OperationType vodserviceoper) {
        this.vodserviceoper = vodserviceoper;
    }
}
