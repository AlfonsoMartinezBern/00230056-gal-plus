
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
 *         &lt;element ref="{}VOD_SERVICE_ID"/&gt;
 *         &lt;element name="VOD_SERVICE_OPER" type="{}operationType" minOccurs="0"/&gt;
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
    "vodserviceid",
    "vodserviceoper"
})
@XmlRootElement(name = "VOD_SERVICE")
public class VODSERVICE {

    @XmlElement(name = "VOD_SERVICE_ID", required = true)
    protected String vodserviceid;
    @XmlElement(name = "VOD_SERVICE_OPER")
    @XmlSchemaType(name = "string")
    protected OperationType vodserviceoper;

    /**
     * Obtiene el valor de la propiedad vodserviceid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVODSERVICEID() {
        return vodserviceid;
    }

    /**
     * Define el valor de la propiedad vodserviceid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVODSERVICEID(String value) {
        this.vodserviceid = value;
    }

    /**
     * Obtiene el valor de la propiedad vodserviceoper.
     * 
     * @return
     *     possible object is
     *     {@link OperationType }
     *     
     */
    public OperationType getVODSERVICEOPER() {
        return vodserviceoper;
    }

    /**
     * Define el valor de la propiedad vodserviceoper.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationType }
     *     
     */
    public void setVODSERVICEOPER(OperationType value) {
        this.vodserviceoper = value;
    }

}
