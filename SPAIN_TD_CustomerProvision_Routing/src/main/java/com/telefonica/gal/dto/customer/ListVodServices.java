package com.telefonica.gal.dto.customer;

import com.telefonica.gal.customerProvision.request.VODSERVICE;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "vodservice"
})
@XmlRootElement(name = "LIST_VOD_SERVICES")
public class ListVodServices {
    @XmlElement(name = "VOD_SERVICE")
    protected List<VodService> vodservice;

    public List<VodService> getVodservice() {
        if (vodservice == null) {
            vodservice = new ArrayList<VodService>();
        }
        return this.vodservice;
    }
}
