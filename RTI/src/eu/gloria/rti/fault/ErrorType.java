
package eu.gloria.rti.fault;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para errorType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="errorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unsupported"/>
 *     &lt;enumeration value="General"/>
 *     &lt;enumeration value="InvalidSession"/>
 *     &lt;enumeration value="LoginInvalidUserPassword"/>
 *     &lt;enumeration value="LoginImpossibleAuthenticate"/>
 *     &lt;enumeration value="DeviceCommunication"/>
 *     &lt;enumeration value="DeviceInAlarmState"/>
 *     &lt;enumeration value="DeviceInWrongActivityState"/>
 *     &lt;enumeration value="ExecutorWrongState"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "errorType")
@XmlEnum
public enum ErrorType {

    @XmlEnumValue("Unsupported")
    UNSUPPORTED("Unsupported"),
    @XmlEnumValue("General")
    GENERAL("General"),
    @XmlEnumValue("InvalidSession")
    INVALID_SESSION("InvalidSession"),
    @XmlEnumValue("LoginInvalidUserPassword")
    LOGIN_INVALID_USER_PASSWORD("LoginInvalidUserPassword"),
    @XmlEnumValue("LoginImpossibleAuthenticate")
    LOGIN_IMPOSSIBLE_AUTHENTICATE("LoginImpossibleAuthenticate"),
    @XmlEnumValue("DeviceCommunication")
    DEVICE_COMMUNICATION("DeviceCommunication"),
    @XmlEnumValue("DeviceInAlarmState")
    DEVICE_IN_ALARM_STATE("DeviceInAlarmState"),
    @XmlEnumValue("DeviceInWrongActivityState")
    DEVICE_IN_WRONG_ACTIVITY_STATE("DeviceInWrongActivityState"), @XmlEnumValue("ExecutorWrongState")
    EXECUTOR_WRONG_STATE("ExecutorWrongState");
    private final String value;

    ErrorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ErrorType fromValue(String v) {
        for (ErrorType c: ErrorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
