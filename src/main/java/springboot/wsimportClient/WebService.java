
package springboot.wsimportClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@javax.jws.WebService(name = "WebService", targetNamespace = "http://webservice.springboot/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getInfo", targetNamespace = "http://webservice.springboot/", className = "com.soft.test.wsimportClient.GetInfo")
    @ResponseWrapper(localName = "getInfoResponse", targetNamespace = "http://webservice.springboot/", className = "com.soft.test.wsimportClient.GetInfoResponse")
    public String getInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
