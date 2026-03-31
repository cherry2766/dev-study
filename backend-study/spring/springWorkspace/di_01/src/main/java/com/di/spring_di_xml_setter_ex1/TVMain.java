package com.di.spring_di_xml_setter_ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		//AbstractApplicationContext context = new GenericXmlApplicationContext("application-context2_1.xml");
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-context2_2.xml");
		
		TVController controller = context.getBean("tvController", TVController.class);
		controller.show("볼륨 up");
		controller.show("볼륨 down");
		
		context.close();
	}

}
