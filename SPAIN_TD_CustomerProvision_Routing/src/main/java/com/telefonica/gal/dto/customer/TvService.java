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
        "tvserviceid",
        "tvserviceoper"
})
@XmlRootElement(name = "TV_SERVICE")
public class TvService {
    @XmlElement(name = "TV_SERVICE_ID", required = true)
    protected String tvserviceid;
    @XmlElement(name = "TV_SERVICE_OPER")
    @XmlSchemaType(name = "string")
    protected OperationType tvserviceoper;

    public String getTvserviceid() {
        return tvserviceid;
    }

    public void setTvserviceid(String tvserviceid) {
        this.tvserviceid = tvserviceid;
    }

    public OperationType getTvserviceoper() {
        return tvserviceoper;
    }

    public void setTvserviceoper(OperationType tvserviceoper) {
        this.tvserviceoper = tvserviceoper;
    }
}
