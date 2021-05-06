
package com.telefonica.gal.CustomerProvision.request;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}VOD_SERVICE" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "vodservice"
})
@XmlRootElement(name = "LIST_VOD_SERVICES")
public class LISTVODSERVICES {

    @XmlElement(name = "VOD_SERVICE")
    protected List<VODSERVICE> vodservice;

    /**
     * Gets the value of the vodservice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vodservice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVODSERVICE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VODSERVICE }
     * 
     * 
     */
    public List<VODSERVICE> getVODSERVICE() {
        if (vodservice == null) {
            vodservice = new ArrayList<VODSERVICE>();
        }
        return this.vodservice;
    }

}
