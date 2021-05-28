package springboot.webservice;
 
import javax.jws.WebService;
 
@WebService(name = "WebService", // 暴露服务名称
    targetNamespace = "http://webservice.springboot/"// 命名空间,一般是接口的包名倒序
)
public interface WebServiceServer {
 
    public String getInfo(String param);
 
}