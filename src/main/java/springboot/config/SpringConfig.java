package springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

public class SpringConfig {
	@Configuration
	@ImportResource(locations= {"classpath:annotationContent.xml"})
	public class annotationContent {
	 
	}

}
