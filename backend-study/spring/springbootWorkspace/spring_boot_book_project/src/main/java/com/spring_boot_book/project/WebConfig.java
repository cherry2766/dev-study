package com.spring_boot_book.project;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/book_images/**")
		.addResourceLocations("C:/Users/soooo/Documents/dev/dev-study/backend-study/spring/springbootWorkspace/book_images/");
	}
}
