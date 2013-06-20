
package eu.gloria.rti;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para sessionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="sessionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TOKEN"/>
 *     &lt;enumeration value="COOKIE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sessionType")
@XmlEnum
public enum SessionType {

    TOKEN,
    COOKIE;

    public String value() {
        return name();
    }

    public static SessionType fromValue(String v) {
        return valueOf(v);
    }

}
