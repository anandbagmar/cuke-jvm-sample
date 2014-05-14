
package businessLayer.webserviceClients.periodicTable;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the businessLayer.webserviceClients.periodicTable package.
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

    private final static QName _String_QNAME = new QName("http://www.webserviceX.NET", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: businessLayer.webserviceClients.periodicTable
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetElementSymbol }
     * 
     */
    public GetElementSymbol createGetElementSymbol() {
        return new GetElementSymbol();
    }

    /**
     * Create an instance of {@link GetAtoms }
     * 
     */
    public GetAtoms createGetAtoms() {
        return new GetAtoms();
    }

    /**
     * Create an instance of {@link GetAtomsResponse }
     * 
     */
    public GetAtomsResponse createGetAtomsResponse() {
        return new GetAtomsResponse();
    }

    /**
     * Create an instance of {@link GetAtomicWeightResponse }
     * 
     */
    public GetAtomicWeightResponse createGetAtomicWeightResponse() {
        return new GetAtomicWeightResponse();
    }

    /**
     * Create an instance of {@link GetAtomicNumber }
     * 
     */
    public GetAtomicNumber createGetAtomicNumber() {
        return new GetAtomicNumber();
    }

    /**
     * Create an instance of {@link GetElementSymbolResponse }
     * 
     */
    public GetElementSymbolResponse createGetElementSymbolResponse() {
        return new GetElementSymbolResponse();
    }

    /**
     * Create an instance of {@link GetAtomicNumberResponse }
     * 
     */
    public GetAtomicNumberResponse createGetAtomicNumberResponse() {
        return new GetAtomicNumberResponse();
    }

    /**
     * Create an instance of {@link GetAtomicWeight }
     * 
     */
    public GetAtomicWeight createGetAtomicWeight() {
        return new GetAtomicWeight();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.webserviceX.NET", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}
