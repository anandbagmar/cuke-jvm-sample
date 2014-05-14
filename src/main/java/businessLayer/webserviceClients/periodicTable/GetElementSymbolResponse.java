
package businessLayer.webserviceClients.periodicTable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetElementSymbolResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getElementSymbolResult"
})
@XmlRootElement(name = "GetElementSymbolResponse")
public class GetElementSymbolResponse {

    @XmlElement(name = "GetElementSymbolResult")
    protected String getElementSymbolResult;

    /**
     * Gets the value of the getElementSymbolResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetElementSymbolResult() {
        return getElementSymbolResult;
    }

    /**
     * Sets the value of the getElementSymbolResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetElementSymbolResult(String value) {
        this.getElementSymbolResult = value;
    }

}
