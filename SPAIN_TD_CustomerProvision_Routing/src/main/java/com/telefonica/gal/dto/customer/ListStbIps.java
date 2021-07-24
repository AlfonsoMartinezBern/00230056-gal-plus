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
        "stbip"
})

@XmlRootElement(name = "LIST_STB_IPS")
public class ListStbIps {
    @XmlElement(name = "STB_IP")
    protected List<String> stbip;

    public List<String> getStbip() {
        if (stbip == null) {
            stbip = new ArrayList<String>();
        }
        return this.stbip;
    }
}
