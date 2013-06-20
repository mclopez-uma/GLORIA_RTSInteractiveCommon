
package eu.gloria.rti;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ascension" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="declination" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "session",
    "deviceId",
    "ascension",
    "declination"
})
@XmlRootElement(name = "mntSlewToCoordinates")
public class MntSlewToCoordinates {

    @XmlElement(required = true)
    protected String session;
    @XmlElement(required = true)
    protected String deviceId;
    protected double ascension;
    protected double declination;

    /**
     * Obtiene el valor de la propiedad session.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSession() {
        return session;
    }

    /**
     * Define el valor de la propiedad session.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSession(String value) {
        this.session = value;
    }

    /**
     * Obtiene el valor de la propiedad deviceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Define el valor de la propiedad deviceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceId(String value) {
        this.deviceId = value;
    }

    /**
     * Obtiene el valor de la propiedad ascension.
     * 
     */
    public double getAscension() {
        return ascension;
    }

    /**
     * Define el valor de la propiedad ascension.
     * 
     */
    public void setAscension(double value) {
        this.ascension = value;
    }

    /**
     * Obtiene el valor de la propiedad declination.
     * 
     */
    public double getDeclination() {
        return declination;
    }

    /**
     * Define el valor de la propiedad declination.
     * 
     */
    public void setDeclination(double value) {
        this.declination = value;
    }

}
