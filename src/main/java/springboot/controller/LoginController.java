package springboot.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.redis.RedisUtil;
import springboot.util.JsonResponseBody;
import springboot.util.ResponseResult;

@RestController
public class LoginController {

	@Resource
	RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping(value = "/login")
	public @JsonResponseBody ResponseResult login(HttpServletRequest request, HttpServletResponse response, String name, String pwd) {
		ResponseResult rr = new ResponseResult();
		
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html;charset=utf-8");
		
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Entry<String,String[]>> entrySet = parameterMap.entrySet();
		for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<String, String[]> entry = (Entry<String, String[]>) iterator.next();
			System.out.println("entry.getKey(): "+entry.getKey() +" ++ entry.getValue(): "+entry.getValue()[0]);
			
		}
		
		
		for (int i = 0; i < cookies.length; i++) {
			System.out.println("getName: "+cookies[i].getName() + " getValue: "+cookies[i].getValue());
		}
		
		
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		// 模拟db校验密码
		
		
		ClusterOperations<String, Object> opsForCluster = redisTemplate.opsForCluster();
		
//		opsForCluster.
		
		String p_name = request.getParameter("name");
		String p_pwd = request.getParameter("pwd");
		String object = (String)opsForValue.get(""+p_name+"");
		if(p_name != null && p_pwd.equals(object)) {
			System.out.println(p_name + " 登录成功");
			rr.setMessage("登录成功");
			
			return rr;
		}
		
		opsForValue.set("jack", "123");
		
		System.out.println(opsForValue.get("jack") + " 登录成功opsForValue");
//		opsForValue.
		
//		RedisUtil.
		//将token写入cookie
        Cookie cookie = null;
		try {
			cookie = new Cookie(URLEncoder.encode("cookie", "utf-8"), "这是cookie");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String string = UUID.randomUUID().toString();
//		opsForValue.set(string, "UUID.randomUUID().toString()");
		cookie.setValue(string);
        cookie.setMaxAge(100 + 8 * 3600);
        cookie.setPath("/");
        response.addCookie(cookie);
		String pathInfo = request.getPathInfo();
		System.out.println(pathInfo);
		rr.setMessage(pathInfo + name + "+的风格_+" + pwd);
		return rr;
	}
	
}
