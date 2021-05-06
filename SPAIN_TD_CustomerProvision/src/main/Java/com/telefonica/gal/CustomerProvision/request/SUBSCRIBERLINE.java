
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
 *         &lt;element ref="{}UPSTREAM"/&gt;
 *         &lt;element ref="{}DOWNSTREAM"/&gt;
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
    "upstream",
    "downstream"
})
@XmlRootElement(name = "SUBSCRIBER_LINE")
public class SUBSCRIBERLINE {

    @XmlElement(name = "UPSTREAM")
    protected int upstream;
    @XmlElement(name = "DOWNSTREAM")
    protected int downstream;

    /**
     * Obtiene el valor de la propiedad upstream.
     * 
     */
    public int getUPSTREAM() {
        return upstream;
    }

    /**
     * Define el valor de la propiedad upstream.
     * 
     */
    public void setUPSTREAM(int value) {
        this.upstream = value;
    }

    /**
     * Obtiene el valor de la propiedad downstream.
     * 
     */
    public int getDOWNSTREAM() {
        return downstream;
    }

    /**
     * Define el valor de la propiedad downstream.
     * 
     */
    public void setDOWNSTREAM(int value) {
        this.downstream = value;
    }

}
