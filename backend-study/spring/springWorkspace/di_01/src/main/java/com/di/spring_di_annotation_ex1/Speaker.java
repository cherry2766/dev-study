package com.di.spring_di_annotation_ex1;

import org.springframework.stereotype.Service;

@Service
public class Speaker {
	public String volumeUp() {
		return "볼륨을 키웁니다.";
	}
	
	public String volumeDown() {
		return "볼륨을 낮춥니다.";
	}

}
