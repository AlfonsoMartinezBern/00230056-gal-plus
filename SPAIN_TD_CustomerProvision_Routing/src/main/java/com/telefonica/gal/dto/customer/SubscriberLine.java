package com.telefonica.gal.dto.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "upstream",
        "downstream"
})
@XmlRootElement(name = "SUBSCRIBER_LINE")
public class SubscriberLine {
    @XmlElement(name = "UPSTREAM")
    protected String upstream;
    @XmlElement(name = "DOWNSTREAM")
    protected String downstream;

    public String getUpstream() {
        return upstream;
    }

    public void setUpstream(String upstream) {
        this.upstream = upstream;
    }

    public String getDownstream() {
        return downstream;
    }

    public void setDownstream(String downstream) {
        this.downstream = downstream;
    }
}
