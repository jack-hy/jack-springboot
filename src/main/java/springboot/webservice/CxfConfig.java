package springboot.webservice;
 
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;
 
@Configuration
public class CxfConfig {
 
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(),"/springboot-ws/*");
    }
 
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
    	
    	//dev 修改
        return new SpringBus();
    }
 
    @Bean
    public WebServiceServer webService() {
        return new WebServiceServerImpl();
    }
 
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), webService());
        endpoint.publish("/api");
        return endpoint;
    }
 
}