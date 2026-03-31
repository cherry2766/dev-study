package com.di.spring_di_annotation_ex2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TV tv = context.getBean("tv", TV.class);
		tv.show("볼륨 up");
		tv.show("볼륨 down");
		
		context.close();
	}

}
