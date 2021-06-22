package springboot.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import springboot.util.JsonResponseBody;
import springboot.util.ResponseResult;


@Controller
public class TestController {
	
	@Autowired
	ApplicationContext applicationContext;

	
	
	@RequestMapping("testC1")
	public @JsonResponseBody ResponseResult testC1() {
		ResponseResult rs = new ResponseResult();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("123");
		rs.setList(arrayList);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1","abc");
		rs.setMap(map);
		System.out.println(rs.toString());
		
//		org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter

		
		
		return rs;
	}
	@RequestMapping("testC2")
	public @ResponseBody String testC2() {
		
		RequestMappingHandlerAdapter bean = (RequestMappingHandlerAdapter) applicationContext.getBean("requestMappingHandlerAdapter");
		
		List<HandlerMethodReturnValueHandler> HandlerMethodReturnValueHandler = bean.getCustomReturnValueHandlers();
//		System.out.println(HandlerMethodReturnValueHandler.get(0).getClass().getName());
		
		
		
    	Foo bean1 = SpringUtil.getBean(Foo.class);
    	Method[] declaredMethods = Foo.class.getDeclaredMethods();
    	for (int i = 0; i < declaredMethods.length; i++) {
			Method method = declaredMethods[i];
			String name = method.getName();
			System.out.println("name: "+name);
			if(name.equals("getStudents")) {
				System.out.println(method);
			}
		}
		System.out.println("bean+++++++++++: "+bean1.name);
		
		
		String[] beanDefinitionNames = SpringUtil.getApplicationContext().getBeanDefinitionNames();
		for (int i = 0; i < beanDefinitionNames.length; i++) {
			
			System.out.println("beanDefinitionNames: "+beanDefinitionNames[i]);
		}
		
		return HandlerMethodReturnValueHandler.getClass().getName();
	}
	
	
}
