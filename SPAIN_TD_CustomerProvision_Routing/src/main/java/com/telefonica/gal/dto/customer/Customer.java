package com.telefonica.gal.dto.customer;

import com.telefonica.gal.customerProvision.request.LISTOPERATORBONUS;
import com.telefonica.gal.customerProvision.request.OTTSERVICEDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "CUSTOMER")
public class Customer {
    @XmlElement(name = "OPERATION_ID", required = true)
    protected String operationid;
    @XmlElement(name = "OPERATION_TYPE", required = true)
    protected String operationtype;
    @XmlElement(name = "USER_ID", required = true)
    protected String userid;
    @XmlElement(name = "NEW_USER_ID")
    protected String newuserid;
    @XmlElement(name = "GEOGRAFIC_AREA")
    protected String geograficarea;
    @XmlElement(name = "USER_TYPE", required = true)
    protected String usertype;
    @XmlElement(name = "SERVICE_TYPE", required = true)
    protected String servicetype;
    @XmlElement(name = "ADDRESSING")
    protected String addressing;
    @XmlElement(name = "MAX_NUM_STBS")
    protected String maxnumstbs;
    @XmlElement(name = "LIST_STB_IPS", required = true)
    protected ListStbIps liststbips;
    @XmlElement(name = "LIST_TV_SERVICES", required = true)
    protected ListTVServices listtvservices;
    @XmlElement(name = "LIST_VOD_SERVICES", required = true)
    protected ListVodServices listvodservices;
    @XmlElement(name = "POP")
    protected String pop;
    @XmlElement(name = "TV_HD")
    protected String tvhd;
    @XmlElement(name = "LINE_QUALITY")
    protected String linequality;
    @XmlElement(name = "LIST_OPERATOR_BONUS")
    protected LISTOPERATORBONUS listoperatorbonus;
    @XmlElement(name = "LIMIT_VOD_PURCHASES")
    protected Integer limitvodpurchases;
    @XmlElement(name = "LIMIT_PPV_PURCHASES")
    protected Integer limitppvpurchases;
    @XmlElement(name = "LIMIT_USER_BONUS_PURCHASES")
    protected Integer limituserbonuspurchases;
    @XmlElement(name = "SUBSCRIBER_LINE", required = true)
    protected SubscriberLine subscriberline;
    @XmlElement(name = "OTT_SERVICE_DATA")
    protected OTTSERVICEDATA ottservicedata;
    @XmlElement(name = "VOD_SERVER")
    protected String vodserver;

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNewuserid() {
        return newuserid;
    }

    public void setNewuserid(String newuserid) {
        this.newuserid = newuserid;
    }

    public String getGeograficarea() {
        return geograficarea;
    }

    public void setGeograficarea(String geograficarea) {
        this.geograficarea = geograficarea;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getAddressing() {
        return addressing;
    }

    public void setAddressing(String addressing) {
        this.addressing = addressing;
    }

    public String getMaxnumstbs() {
        return maxnumstbs;
    }

    public void setMaxnumstbs(String maxnumstbs) {
        this.maxnumstbs = maxnumstbs;
    }

    public ListStbIps getListstbips() {
        return liststbips;
    }

    public void setListstbips(ListStbIps liststbips) {
        this.liststbips = liststbips;
    }

    public ListTVServices getListtvservices() {
        return listtvservices;
    }

    public void setListtvservices(ListTVServices listtvservices) {
        this.listtvservices = listtvservices;
    }

    public ListVodServices getListvodservices() {
        return listvodservices;
    }

    public void setListvodservices(ListVodServices listvodservices) {
        this.listvodservices = listvodservices;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getTvhd() {
        return tvhd;
    }

    public void setTvhd(String tvhd) {
        this.tvhd = tvhd;
    }

    public String getLinequality() {
        return linequality;
    }

    public void setLinequality(String linequality) {
        this.linequality = linequality;
    }

    public LISTOPERATORBONUS getListoperatorbonus() {
        return listoperatorbonus;
    }

    public void setListoperatorbonus(LISTOPERATORBONUS listoperatorbonus) {
        this.listoperatorbonus = listoperatorbonus;
    }

    public Integer getLimitvodpurchases() {
        return limitvodpurchases;
    }

    public void setLimitvodpurchases(Integer limitvodpurchases) {
        this.limitvodpurchases = limitvodpurchases;
    }

    public Integer getLimitppvpurchases() {
        return limitppvpurchases;
    }

    public void setLimitppvpurchases(Integer limitppvpurchases) {
        this.limitppvpurchases = limitppvpurchases;
    }

    public Integer getLimituserbonuspurchases() {
        return limituserbonuspurchases;
    }

    public void setLimituserbonuspurchases(Integer limituserbonuspurchases) {
        this.limituserbonuspurchases = limituserbonuspurchases;
    }

    public SubscriberLine getSubscriberline() {
        return subscriberline;
    }

    public void setSubscriberline(SubscriberLine subscriberline) {
        this.subscriberline = subscriberline;
    }

    public OTTSERVICEDATA getOttservicedata() {
        return ottservicedata;
    }

    public void setOttservicedata(OTTSERVICEDATA ottservicedata) {
        this.ottservicedata = ottservicedata;
    }

    public String getVodserver() {
        return vodserver;
    }

    public void setVodserver(String vodserver) {
        this.vodserver = vodserver;
    }
}
