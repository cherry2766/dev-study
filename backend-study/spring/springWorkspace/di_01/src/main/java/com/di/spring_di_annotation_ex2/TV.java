package com.di.spring_di_annotation_ex2;

public class TV {
	private Speaker speaker;
	
	
	public TV() {
		
	}
	
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
