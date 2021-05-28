package springboot.webservice;

import java.util.Date;

import javax.jws.WebService;

@WebService(name = "WebService", // 暴露服务名称
targetNamespace = "http://webservice.springboot/"// 命名空间,一般是接口的包名倒序
)
public class WebServiceServerImpl implements WebServiceServer{

	@Override
	public String getInfo(String param) {
		String os = System.getProperty("os.name");
		return "param: "+ param +"os.name: " + os + " time: " + new Date().getTime();
	}

}
