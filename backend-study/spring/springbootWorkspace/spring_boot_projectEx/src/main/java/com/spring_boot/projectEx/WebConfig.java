package com.spring_boot.projectEx;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/prd_images/**")
				.addResourceLocations("file:///C:/Users/soooo/Documents/dev/dev-study/backend-study/spring/springbootWorkspace/product_images/");
	}

}
