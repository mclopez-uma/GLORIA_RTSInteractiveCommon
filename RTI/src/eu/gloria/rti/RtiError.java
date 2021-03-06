
package eu.gloria.rti;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.1
 * 2014-04-23T10:01:14.584+02:00
 * Generated source version: 2.6.1
 */

@WebFault(name = "errorDetail", targetNamespace = "http://gloria.eu/rti/fault")
public class RtiError extends Exception {
    
    private eu.gloria.rti.fault.ErrorDetail errorDetail;

    public RtiError() {
        super();
    }
    
    public RtiError(String message) {
        super(message);
    }
    
    public RtiError(String message, Throwable cause) {
        super(message, cause);
    }

    public RtiError(String message, eu.gloria.rti.fault.ErrorDetail errorDetail) {
        super(message);
        this.errorDetail = errorDetail;
    }

    public RtiError(String message, eu.gloria.rti.fault.ErrorDetail errorDetail, Throwable cause) {
        super(message, cause);
        this.errorDetail = errorDetail;
    }

    public eu.gloria.rti.fault.ErrorDetail getFaultInfo() {
        return this.errorDetail;
    }
}
