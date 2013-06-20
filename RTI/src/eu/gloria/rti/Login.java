
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
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pw" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sessionType" type="{http://gloria.eu/rti}sessionType"/>
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
    "user",
    "pw",
    "sessionType"
})
@XmlRootElement(name = "login")
public class Login {

    @XmlElement(required = true)
    protected String user;
    @XmlElement(required = true)
    protected String pw;
    @XmlElement(required = true)
    protected SessionType sessionType;

    /**
     * Obtiene el valor de la propiedad user.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Define el valor de la propiedad user.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Obtiene el valor de la propiedad pw.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPw() {
        return pw;
    }

    /**
     * Define el valor de la propiedad pw.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPw(String value) {
        this.pw = value;
    }

    /**
     * Obtiene el valor de la propiedad sessionType.
     * 
     * @return
     *     possible object is
     *     {@link SessionType }
     *     
     */
    public SessionType getSessionType() {
        return sessionType;
    }

    /**
     * Define el valor de la propiedad sessionType.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionType }
     *     
     */
    public void setSessionType(SessionType value) {
        this.sessionType = value;
    }

}
