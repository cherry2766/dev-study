package com.di.spring_di_annotation_ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-config4.xml");
		
		TV controller = context.getBean("TV", TV.class);
		controller.show("볼륨 up");
		controller.show("볼륨 down");
		
		context.close();
	}

}
