package com.telefonica.gal.dto.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tvservice"
})

@XmlRootElement(name = "LIST_TV_SERVICES")
public class ListTVServices {
    @XmlElement(name = "TV_SERVICE")
    protected List<TvService> tvservice;

    public List<TvService> getTvservice() {
        if (tvservice == null) {
            tvservice = new ArrayList<TvService>();
        }
        return this.tvservice;
    }
}
