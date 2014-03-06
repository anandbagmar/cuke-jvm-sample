
package flows.WebserviceClients.tempconvert.com.w3schools.webservices;

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
 *         &lt;element name="CelsiusToFahrenheitResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "celsiusToFahrenheitResult"
})
@XmlRootElement(name = "CelsiusToFahrenheitResponse")
public class CelsiusToFahrenheitResponse {

    @XmlElement(name = "CelsiusToFahrenheitResult")
    protected String celsiusToFahrenheitResult;

    /**
     * Gets the value of the celsiusToFahrenheitResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCelsiusToFahrenheitResult() {
        return celsiusToFahrenheitResult;
    }

    /**
     * Sets the value of the celsiusToFahrenheitResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCelsiusToFahrenheitResult(String value) {
        this.celsiusToFahrenheitResult = value;
    }

}
