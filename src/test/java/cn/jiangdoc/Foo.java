package cn.jiangdoc;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import springboot.wsimportClient.WebService;
import springboot.wsimportClient.WebServiceServerImplService;

/**
 * @author gk
 *
 */
/**
 * @author gk
 *
 */
/**
 * @author gk
 *
 */
public class Foo {
	
	/**
	 * Apache CXF 是开源的WebService框架，实现ws客户端0，动态工厂实现ws客户端
	 */	
	@Test
	public void getApacheCXF () throws Exception {	
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://localhost:18080/springboot/springboot-ws/api?wsdl");
		QName qName = new QName("http://webservice.springboot/", "getInfo");
        //调用方法传参0		
		Object[] result = client.invoke(qName,new Object[] { "admin_123456" });
		System.out.println(result[0]);
		
        //调用方法传参1
//        Object[] result = client.invoke("getInfo", " info ");  
//        //打印回值
//        System.out.println(result[0]);  
		
		
		

	}

	
	/**
	 * Apache CXF 是开源的WebService框架，实现ws客户端1，客户端指定接口
	 */
//	@Test
//	public void getApacheCXF2 () throws Exception {	
//		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//		factory.setServiceClass(WebServiceServer.class);
//		factory.setAddress("http://localhost:18080/springboot/springboot-ws/api?wsdl");
//		// 需要服务接口文件
//		WebServiceServer client2 = (WebServiceServer) factory.create();
//		String result2 = client2.getInfo("admin123456");
//		System.out.println(result2);
//		
//	}
	
	
	/**
	 * .使用jdk原生wsimport命令生成客户端代码后，ws客户端
	 */
	@Test
	public void getWS () {	
		WebServiceServerImplService implService = new WebServiceServerImplService();
		WebService service = implService.getWebServicePort();
		String info = service.getInfo("info");
		System.out.println(info);
	}
	
	
	
	@Test
	public void getSystemInfo () {
//		Properties properties = System.getProperties();
//		System.out.println(properties);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterdate = c.getTime();
		// 前一天的日期
		String yesterday = new SimpleDateFormat().format(yesterdate);
		
		
		System.out.println(yesterday);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Students s = new Students();
		s.setAlias("学生");
		s.setName("Jack");
		s.setId(123);
		HashMap h = new HashMap();
		h.put("key", "这是个Map的value");
		s.setMap(h);
		ArrayList a = new ArrayList();
		a.add("这是一个list");
		s.setList(a);
		
		FileOutputStream fos = new FileOutputStream("out.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.close();
		
		FileInputStream fis = new FileInputStream("out.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Students ss = (Students)ois.readObject();
		System.out.println(ss);
		
		
	}
	
	public static Students getStudents() {
		Students s = new Students();
		s.setAlias("学生");
		s.setName("Jack");
		s.setId(123);
		HashMap<String, String> h = new HashMap<String, String>();
		h.put("key", "这是个Map的value");
		s.setMap(h);
		ArrayList<String> a = new ArrayList<String>();
		a.add("这是一个list");
		s.setList(a);
		return s;
	}
}
