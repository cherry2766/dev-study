package com.di.spring_di_xml_setter_ex1;

import org.springframework.beans.factory.annotation.Autowired;

public class TVController {
	private SpeakerService speakerService;
	
	@Autowired
	public void setSpeakerService(SpeakerService speakerService) {
		this.speakerService = speakerService;
	}
	
	public void show(String volumeControl) {
		if(volumeControl.equals("볼륨 up")) {
			System.out.println(speakerService.volumeUp());
		}else if(volumeControl.equals("볼륨 down")) {
			System.out.println(speakerService.volumeDown());
		}
	}

}
