package springboot.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

 public class JsonsResponseBodyMethodPro implements HandlerMethodReturnValueHandler
 {

 
 public JsonsResponseBodyMethodPro (java.util.ArrayList shmc) {

}
  
 	@Override
 	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

     HttpServletResponse response = (HttpServletResponse)webRequest.getNativeResponse(HttpServletResponse.class);
     HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest(HttpServletRequest.class);
     response.setContentType("text/html;charset=UTF-8");

     mavContainer.setRequestHandled(true);
 
     
     try {
       if (returnValue == null) {
         response.getWriter().print("");
         response.getWriter().close();
      } else if (returnValue instanceof String) {
         response.getWriter().print(returnValue);
         response.getWriter().close();
       } else if (returnValue instanceof ResponseResult) {
         ResponseResult resResult = (ResponseResult)returnValue;
         System.out.println(resResult.toString());
         response.getWriter().print(resResult.toString());
         response.getWriter().close();
       }
     } catch (Exception e) {
       throw new Exception(e.getMessage());
     } 
   }
   

   

@Override
public boolean supportsReturnType(MethodParameter returnType) {
	JsonResponseBody methodAnnotation = returnType.getMethodAnnotation(springboot.util.JsonResponseBody.class);
//	String string = methodAnnotation.toString();
//	System.out.println("supportsReturnType:" + string);
//	System.out.println("supportsReturnType:" +  (returnType.getMethodAnnotation(JsonResponseBody.class) != null));
	 return  (returnType.getMethodAnnotation(JsonResponseBody.class) != null); 
//	return false;
} }

