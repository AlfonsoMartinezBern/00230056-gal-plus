
package com.telefonica.gal.CustomerProvision.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}OPERATION_ID"/&gt;
 *         &lt;element ref="{}OPERATION_TYPE"/&gt;
 *         &lt;element ref="{}USER_ID"/&gt;
 *         &lt;element ref="{}NEW_USER_ID" minOccurs="0"/&gt;
 *         &lt;element ref="{}GEOGRAFIC_AREA"/&gt;
 *         &lt;element ref="{}USER_TYPE"/&gt;
 *         &lt;element ref="{}SERVICE_TYPE"/&gt;
 *         &lt;element ref="{}ADDRESSING" minOccurs="0"/&gt;
 *         &lt;element ref="{}MAX_NUM_STBS" minOccurs="0"/&gt;
 *         &lt;element ref="{}LIST_STB_IPS"/&gt;
 *         &lt;element ref="{}LIST_TV_SERVICES"/&gt;
 *         &lt;element ref="{}LIST_VOD_SERVICES"/&gt;
 *         &lt;element ref="{}POP"/&gt;
 *         &lt;element ref="{}TV_HD" minOccurs="0"/&gt;
 *         &lt;element ref="{}LINE_QUALITY" minOccurs="0"/&gt;
 *         &lt;element ref="{}LIST_OPERATOR_BONUS" minOccurs="0"/&gt;
 *         &lt;element ref="{}LIMIT_VOD_PURCHASES" minOccurs="0"/&gt;
 *         &lt;element ref="{}LIMIT_PPV_PURCHASES" minOccurs="0"/&gt;
 *         &lt;element ref="{}LIMIT_USER_BONUS_PURCHASES" minOccurs="0"/&gt;
 *         &lt;element ref="{}SUBSCRIBER_LINE"/&gt;
 *         &lt;element ref="{}OTT_SERVICE_DATA" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "operationid",
    "operationtype",
    "userid",
    "newuserid",
    "geograficarea",
    "usertype",
    "servicetype",
    "addressing",
    "maxnumstbs",
    "liststbips",
    "listtvservices",
    "listvodservices",
    "pop",
    "tvhd",
    "linequality",
    "listoperatorbonus",
    "limitvodpurchases",
    "limitppvpurchases",
    "limituserbonuspurchases",
    "subscriberline",
    "ottservicedata"
})
@XmlRootElement(name = "CUSTOMER")
public class CUSTOMER {

    @XmlElement(name = "OPERATION_ID", required = true)
    protected String operationid;
    @XmlElement(name = "OPERATION_TYPE", required = true)
    protected String operationtype;
    @XmlElement(name = "USER_ID", required = true)
    protected String userid;
    @XmlElement(name = "NEW_USER_ID")
    protected String newuserid;
    @XmlElement(name = "GEOGRAFIC_AREA")
    protected int geograficarea;
    @XmlElement(name = "USER_TYPE", required = true)
    protected String usertype;
    @XmlElement(name = "SERVICE_TYPE", required = true)
    protected String servicetype;
    @XmlElement(name = "ADDRESSING")
    protected String addressing;
    @XmlElement(name = "MAX_NUM_STBS")
    protected Integer maxnumstbs;
    @XmlElement(name = "LIST_STB_IPS", required = true)
    protected LISTSTBIPS liststbips;
    @XmlElement(name = "LIST_TV_SERVICES", required = true)
    protected LISTTVSERVICES listtvservices;
    @XmlElement(name = "LIST_VOD_SERVICES", required = true)
    protected LISTVODSERVICES listvodservices;
    @XmlElement(name = "POP")
    protected int pop;
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
    protected SUBSCRIBERLINE subscriberline;
    @XmlElement(name = "OTT_SERVICE_DATA")
    protected OTTSERVICEDATA ottservicedata;

    /**
     * Obtiene el valor de la propiedad operationid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERATIONID() {
        return operationid;
    }

    /**
     * Define el valor de la propiedad operationid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERATIONID(String value) {
        this.operationid = value;
    }

    /**
     * Obtiene el valor de la propiedad operationtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERATIONTYPE() {
        return operationtype;
    }

    /**
     * Define el valor de la propiedad operationtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERATIONTYPE(String value) {
        this.operationtype = value;
    }

    /**
     * Obtiene el valor de la propiedad userid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERID() {
        return userid;
    }

    /**
     * Define el valor de la propiedad userid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERID(String value) {
        this.userid = value;
    }

    /**
     * Obtiene el valor de la propiedad newuserid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEWUSERID() {
        return newuserid;
    }

    /**
     * Define el valor de la propiedad newuserid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEWUSERID(String value) {
        this.newuserid = value;
    }

    /**
     * Obtiene el valor de la propiedad geograficarea.
     * 
     */
    public int getGEOGRAFICAREA() {
        return geograficarea;
    }

    /**
     * Define el valor de la propiedad geograficarea.
     * 
     */
    public void setGEOGRAFICAREA(int value) {
        this.geograficarea = value;
    }

    /**
     * Obtiene el valor de la propiedad usertype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERTYPE() {
        return usertype;
    }

    /**
     * Define el valor de la propiedad usertype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERTYPE(String value) {
        this.usertype = value;
    }

    /**
     * Obtiene el valor de la propiedad servicetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICETYPE() {
        return servicetype;
    }

    /**
     * Define el valor de la propiedad servicetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICETYPE(String value) {
        this.servicetype = value;
    }

    /**
     * Obtiene el valor de la propiedad addressing.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRESSING() {
        return addressing;
    }

    /**
     * Define el valor de la propiedad addressing.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRESSING(String value) {
        this.addressing = value;
    }

    /**
     * Obtiene el valor de la propiedad maxnumstbs.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMAXNUMSTBS() {
        return maxnumstbs;
    }

    /**
     * Define el valor de la propiedad maxnumstbs.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMAXNUMSTBS(Integer value) {
        this.maxnumstbs = value;
    }

    /**
     * Obtiene el valor de la propiedad liststbips.
     * 
     * @return
     *     possible object is
     *     {@link LISTSTBIPS }
     *     
     */
    public LISTSTBIPS getLISTSTBIPS() {
        return liststbips;
    }

    /**
     * Define el valor de la propiedad liststbips.
     * 
     * @param value
     *     allowed object is
     *     {@link LISTSTBIPS }
     *     
     */
    public void setLISTSTBIPS(LISTSTBIPS value) {
        this.liststbips = value;
    }

    /**
     * Obtiene el valor de la propiedad listtvservices.
     * 
     * @return
     *     possible object is
     *     {@link LISTTVSERVICES }
     *     
     */
    public LISTTVSERVICES getLISTTVSERVICES() {
        return listtvservices;
    }

    /**
     * Define el valor de la propiedad listtvservices.
     * 
     * @param value
     *     allowed object is
     *     {@link LISTTVSERVICES }
     *     
     */
    public void setLISTTVSERVICES(LISTTVSERVICES value) {
        this.listtvservices = value;
    }

    /**
     * Obtiene el valor de la propiedad listvodservices.
     * 
     * @return
     *     possible object is
     *     {@link LISTVODSERVICES }
     *     
     */
    public LISTVODSERVICES getLISTVODSERVICES() {
        return listvodservices;
    }

    /**
     * Define el valor de la propiedad listvodservices.
     * 
     * @param value
     *     allowed object is
     *     {@link LISTVODSERVICES }
     *     
     */
    public void setLISTVODSERVICES(LISTVODSERVICES value) {
        this.listvodservices = value;
    }

    /**
     * Obtiene el valor de la propiedad pop.
     * 
     */
    public int getPOP() {
        return pop;
    }

    /**
     * Define el valor de la propiedad pop.
     * 
     */
    public void setPOP(int value) {
        this.pop = value;
    }

    /**
     * Obtiene el valor de la propiedad tvhd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTVHD() {
        return tvhd;
    }

    /**
     * Define el valor de la propiedad tvhd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTVHD(String value) {
        this.tvhd = value;
    }

    /**
     * Obtiene el valor de la propiedad linequality.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINEQUALITY() {
        return linequality;
    }

    /**
     * Define el valor de la propiedad linequality.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINEQUALITY(String value) {
        this.linequality = value;
    }

    /**
     * Obtiene el valor de la propiedad listoperatorbonus.
     * 
     * @return
     *     possible object is
     *     {@link LISTOPERATORBONUS }
     *     
     */
    public LISTOPERATORBONUS getLISTOPERATORBONUS() {
        return listoperatorbonus;
    }

    /**
     * Define el valor de la propiedad listoperatorbonus.
     * 
     * @param value
     *     allowed object is
     *     {@link LISTOPERATORBONUS }
     *     
     */
    public void setLISTOPERATORBONUS(LISTOPERATORBONUS value) {
        this.listoperatorbonus = value;
    }

    /**
     * Obtiene el valor de la propiedad limitvodpurchases.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLIMITVODPURCHASES() {
        return limitvodpurchases;
    }

    /**
     * Define el valor de la propiedad limitvodpurchases.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLIMITVODPURCHASES(Integer value) {
        this.limitvodpurchases = value;
    }

    /**
     * Obtiene el valor de la propiedad limitppvpurchases.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLIMITPPVPURCHASES() {
        return limitppvpurchases;
    }

    /**
     * Define el valor de la propiedad limitppvpurchases.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLIMITPPVPURCHASES(Integer value) {
        this.limitppvpurchases = value;
    }

    /**
     * Obtiene el valor de la propiedad limituserbonuspurchases.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLIMITUSERBONUSPURCHASES() {
        return limituserbonuspurchases;
    }

    /**
     * Define el valor de la propiedad limituserbonuspurchases.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLIMITUSERBONUSPURCHASES(Integer value) {
        this.limituserbonuspurchases = value;
    }

    /**
     * Obtiene el valor de la propiedad subscriberline.
     * 
     * @return
     *     possible object is
     *     {@link SUBSCRIBERLINE }
     *     
     */
    public SUBSCRIBERLINE getSUBSCRIBERLINE() {
        return subscriberline;
    }

    /**
     * Define el valor de la propiedad subscriberline.
     * 
     * @param value
     *     allowed object is
     *     {@link SUBSCRIBERLINE }
     *     
     */
    public void setSUBSCRIBERLINE(SUBSCRIBERLINE value) {
        this.subscriberline = value;
    }

    /**
     * Obtiene el valor de la propiedad ottservicedata.
     * 
     * @return
     *     possible object is
     *     {@link OTTSERVICEDATA }
     *     
     */
    public OTTSERVICEDATA getOTTSERVICEDATA() {
        return ottservicedata;
    }

    /**
     * Define el valor de la propiedad ottservicedata.
     * 
     * @param value
     *     allowed object is
     *     {@link OTTSERVICEDATA }
     *     
     */
    public void setOTTSERVICEDATA(OTTSERVICEDATA value) {
        this.ottservicedata = value;
    }

}
