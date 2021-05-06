
package com.telefonica.gal.CustomerProvision.request;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.telefonica.gal.CustomerProvision.request package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OPERATIONID_QNAME = new QName("", "OPERATION_ID");
    private final static QName _OPERATIONTYPE_QNAME = new QName("", "OPERATION_TYPE");
    private final static QName _USERID_QNAME = new QName("", "USER_ID");
    private final static QName _NEWUSERID_QNAME = new QName("", "NEW_USER_ID");
    private final static QName _GEOGRAFICAREA_QNAME = new QName("", "GEOGRAFIC_AREA");
    private final static QName _USERTYPE_QNAME = new QName("", "USER_TYPE");
    private final static QName _SERVICETYPE_QNAME = new QName("", "SERVICE_TYPE");
    private final static QName _ADDRESSING_QNAME = new QName("", "ADDRESSING");
    private final static QName _MAXNUMSTBS_QNAME = new QName("", "MAX_NUM_STBS");
    private final static QName _STBIP_QNAME = new QName("", "STB_IP");
    private final static QName _TVSERVICEID_QNAME = new QName("", "TV_SERVICE_ID");
    private final static QName _VODSERVICEID_QNAME = new QName("", "VOD_SERVICE_ID");
    private final static QName _POP_QNAME = new QName("", "POP");
    private final static QName _TVHD_QNAME = new QName("", "TV_HD");
    private final static QName _LINEQUALITY_QNAME = new QName("", "LINE_QUALITY");
    private final static QName _LIMITVODPURCHASES_QNAME = new QName("", "LIMIT_VOD_PURCHASES");
    private final static QName _LIMITPPVPURCHASES_QNAME = new QName("", "LIMIT_PPV_PURCHASES");
    private final static QName _LIMITUSERBONUSPURCHASES_QNAME = new QName("", "LIMIT_USER_BONUS_PURCHASES");
    private final static QName _UPSTREAM_QNAME = new QName("", "UPSTREAM");
    private final static QName _DOWNSTREAM_QNAME = new QName("", "DOWNSTREAM");
    private final static QName _MOBILITYMODE_QNAME = new QName("", "MOBILITY_MODE");
    private final static QName _SERVICEUSER_QNAME = new QName("", "SERVICE_USER");
    private final static QName _SERVICEPASSWORD_QNAME = new QName("", "SERVICE_PASSWORD");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.telefonica.gal.CustomerProvision.request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LISTSTBIPS }
     * 
     */
    public LISTSTBIPS createLISTSTBIPS() {
        return new LISTSTBIPS();
    }

    /**
     * Create an instance of {@link LISTTVSERVICES }
     * 
     */
    public LISTTVSERVICES createLISTTVSERVICES() {
        return new LISTTVSERVICES();
    }

    /**
     * Create an instance of {@link TVSERVICE }
     * 
     */
    public TVSERVICE createTVSERVICE() {
        return new TVSERVICE();
    }

    /**
     * Create an instance of {@link LISTVODSERVICES }
     * 
     */
    public LISTVODSERVICES createLISTVODSERVICES() {
        return new LISTVODSERVICES();
    }

    /**
     * Create an instance of {@link VODSERVICE }
     * 
     */
    public VODSERVICE createVODSERVICE() {
        return new VODSERVICE();
    }

    /**
     * Create an instance of {@link LISTOPERATORBONUS }
     * 
     */
    public LISTOPERATORBONUS createLISTOPERATORBONUS() {
        return new LISTOPERATORBONUS();
    }

    /**
     * Create an instance of {@link OPERATORBONUS }
     * 
     */
    public OPERATORBONUS createOPERATORBONUS() {
        return new OPERATORBONUS();
    }

    /**
     * Create an instance of {@link SUBSCRIBERLINE }
     * 
     */
    public SUBSCRIBERLINE createSUBSCRIBERLINE() {
        return new SUBSCRIBERLINE();
    }

    /**
     * Create an instance of {@link OTTSERVICEDATA }
     * 
     */
    public OTTSERVICEDATA createOTTSERVICEDATA() {
        return new OTTSERVICEDATA();
    }

    /**
     * Create an instance of {@link CUSTOMER }
     * 
     */
    public CUSTOMER createCUSTOMER() {
        return new CUSTOMER();
    }

    /**
     * Create an instance of {@link CUSTOMERS }
     * 
     */
    public CUSTOMERS createCUSTOMERS() {
        return new CUSTOMERS();
    }

    /**
     * Create an instance of {@link CUSTOMERPROVISIONREQUEST }
     * 
     */
    public CUSTOMERPROVISIONREQUEST createCUSTOMERPROVISIONREQUEST() {
        return new CUSTOMERPROVISIONREQUEST();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "OPERATION_ID")
    public JAXBElement<String> createOPERATIONID(String value) {
        return new JAXBElement<String>(_OPERATIONID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "OPERATION_TYPE")
    public JAXBElement<String> createOPERATIONTYPE(String value) {
        return new JAXBElement<String>(_OPERATIONTYPE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "USER_ID")
    public JAXBElement<String> createUSERID(String value) {
        return new JAXBElement<String>(_USERID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "NEW_USER_ID")
    public JAXBElement<String> createNEWUSERID(String value) {
        return new JAXBElement<String>(_NEWUSERID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "GEOGRAFIC_AREA")
    public JAXBElement<Integer> createGEOGRAFICAREA(Integer value) {
        return new JAXBElement<Integer>(_GEOGRAFICAREA_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "USER_TYPE")
    public JAXBElement<String> createUSERTYPE(String value) {
        return new JAXBElement<String>(_USERTYPE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "SERVICE_TYPE")
    public JAXBElement<String> createSERVICETYPE(String value) {
        return new JAXBElement<String>(_SERVICETYPE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ADDRESSING")
    public JAXBElement<String> createADDRESSING(String value) {
        return new JAXBElement<String>(_ADDRESSING_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MAX_NUM_STBS")
    public JAXBElement<Integer> createMAXNUMSTBS(Integer value) {
        return new JAXBElement<Integer>(_MAXNUMSTBS_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "STB_IP")
    public JAXBElement<String> createSTBIP(String value) {
        return new JAXBElement<String>(_STBIP_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "TV_SERVICE_ID")
    public JAXBElement<String> createTVSERVICEID(String value) {
        return new JAXBElement<String>(_TVSERVICEID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "VOD_SERVICE_ID")
    public JAXBElement<String> createVODSERVICEID(String value) {
        return new JAXBElement<String>(_VODSERVICEID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "POP")
    public JAXBElement<Integer> createPOP(Integer value) {
        return new JAXBElement<Integer>(_POP_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "TV_HD")
    public JAXBElement<String> createTVHD(String value) {
        return new JAXBElement<String>(_TVHD_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "LINE_QUALITY")
    public JAXBElement<String> createLINEQUALITY(String value) {
        return new JAXBElement<String>(_LINEQUALITY_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "LIMIT_VOD_PURCHASES")
    public JAXBElement<Integer> createLIMITVODPURCHASES(Integer value) {
        return new JAXBElement<Integer>(_LIMITVODPURCHASES_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "LIMIT_PPV_PURCHASES")
    public JAXBElement<Integer> createLIMITPPVPURCHASES(Integer value) {
        return new JAXBElement<Integer>(_LIMITPPVPURCHASES_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "LIMIT_USER_BONUS_PURCHASES")
    public JAXBElement<Integer> createLIMITUSERBONUSPURCHASES(Integer value) {
        return new JAXBElement<Integer>(_LIMITUSERBONUSPURCHASES_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "UPSTREAM")
    public JAXBElement<Integer> createUPSTREAM(Integer value) {
        return new JAXBElement<Integer>(_UPSTREAM_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "DOWNSTREAM")
    public JAXBElement<Integer> createDOWNSTREAM(Integer value) {
        return new JAXBElement<Integer>(_DOWNSTREAM_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MOBILITY_MODE")
    public JAXBElement<String> createMOBILITYMODE(String value) {
        return new JAXBElement<String>(_MOBILITYMODE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "SERVICE_USER")
    public JAXBElement<String> createSERVICEUSER(String value) {
        return new JAXBElement<String>(_SERVICEUSER_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "SERVICE_PASSWORD")
    public JAXBElement<String> createSERVICEPASSWORD(String value) {
        return new JAXBElement<String>(_SERVICEPASSWORD_QNAME, String.class, null, value);
    }

}
