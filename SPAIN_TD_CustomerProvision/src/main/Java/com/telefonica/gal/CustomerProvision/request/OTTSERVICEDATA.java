
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
 *         &lt;element ref="{}MOBILITY_MODE"/&gt;
 *         &lt;element ref="{}SERVICE_USER"/&gt;
 *         &lt;element ref="{}SERVICE_PASSWORD"/&gt;
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
    "mobilitymode",
    "serviceuser",
    "servicepassword"
})
@XmlRootElement(name = "OTT_SERVICE_DATA")
public class OTTSERVICEDATA {

    @XmlElement(name = "MOBILITY_MODE", required = true)
    protected String mobilitymode;
    @XmlElement(name = "SERVICE_USER", required = true)
    protected String serviceuser;
    @XmlElement(name = "SERVICE_PASSWORD", required = true)
    protected String servicepassword;

    /**
     * Obtiene el valor de la propiedad mobilitymode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMOBILITYMODE() {
        return mobilitymode;
    }

    /**
     * Define el valor de la propiedad mobilitymode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMOBILITYMODE(String value) {
        this.mobilitymode = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceuser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEUSER() {
        return serviceuser;
    }

    /**
     * Define el valor de la propiedad serviceuser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEUSER(String value) {
        this.serviceuser = value;
    }

    /**
     * Obtiene el valor de la propiedad servicepassword.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEPASSWORD() {
        return servicepassword;
    }

    /**
     * Define el valor de la propiedad servicepassword.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEPASSWORD(String value) {
        this.servicepassword = value;
    }

}
