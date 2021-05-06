
package com.telefonica.gal.CustomerProvision.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{}TV_SERVICE_ID"/&gt;
 *         &lt;element name="TV_SERVICE_OPER" type="{}operationType" minOccurs="0"/&gt;
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
    "tvserviceid",
    "tvserviceoper"
})
@XmlRootElement(name = "TV_SERVICE")
public class TVSERVICE {

    @XmlElement(name = "TV_SERVICE_ID", required = true)
    protected String tvserviceid;
    @XmlElement(name = "TV_SERVICE_OPER")
    @XmlSchemaType(name = "string")
    protected OperationType tvserviceoper;

    /**
     * Obtiene el valor de la propiedad tvserviceid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTVSERVICEID() {
        return tvserviceid;
    }

    /**
     * Define el valor de la propiedad tvserviceid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTVSERVICEID(String value) {
        this.tvserviceid = value;
    }

    /**
     * Obtiene el valor de la propiedad tvserviceoper.
     * 
     * @return
     *     possible object is
     *     {@link OperationType }
     *     
     */
    public OperationType getTVSERVICEOPER() {
        return tvserviceoper;
    }

    /**
     * Define el valor de la propiedad tvserviceoper.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationType }
     *     
     */
    public void setTVSERVICEOPER(OperationType value) {
        this.tvserviceoper = value;
    }

}
