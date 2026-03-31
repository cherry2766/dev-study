package com.di.spring_di_annotation_ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TV {
	private Speaker speaker;
	
	@Autowired
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void show(String volumeControl) {
		if(volumeControl.equals("볼륨 up")) {
			System.out.println(speaker.volumeUp());
		}else if(volumeControl.equals("볼륨 down")) {
			System.out.println(speaker.volumeDown());
		}
	}

}
