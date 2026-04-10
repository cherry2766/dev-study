package com.spring_boot_fileupload.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class FileController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/fileUploadForm")
	public String uploadForm() {
		return "upload/fileUploadForm";
	}
	// 업로드 되는 파일 크기 : 기본값이 maxFileSize:1메가(개별파일크기), maxRequestSize:10메가(한번에 전송되는 모든 파일 크기의 합)
	@PostMapping("/fileUpload")
	public String fileUpload(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException {
		// 파일이 서버로 전송될 때 서버는 : 해당 파일의 이름 + UUID 
		String uploadPath = "C:/Users/soooo/Documents/dev/dev-study/backend-study/spring/springbootWorkspace/upload/";
		
		// 원본파일 이름 저장
		String originalFileName = file.getOriginalFilename(); // 전송된 파일의 원본명
		
		// 파일 이름 중복되지 않게 난수(uuid)
		UUID uuid = UUID.randomUUID();
		
		String savedFileName = uuid.toString() + "_" + originalFileName;
		
		File sendFile = new File(uploadPath + savedFileName);
		
		file.transferTo(sendFile);
		
		model.addAttribute("originalFileName", originalFileName);
		
		return "upload/fileUploadResultView";
	}
	
	@PostMapping("/fileUploadMultiple")
	public String fileUploadMultiple(@RequestParam("uploadFileMulti") ArrayList<MultipartFile> files, Model model) throws IOException {
		String uploadPath = "C:/Users/soooo/Documents/dev/dev-study/backend-study/spring/springbootWorkspace/upload/";
		
		ArrayList<String> originalFileNameList = new ArrayList<>();
		
		for(MultipartFile file : files) {
			String originalFileName = file.getOriginalFilename();
			originalFileNameList.add(originalFileName);
			
			UUID uuid = UUID.randomUUID();
			
			String savedFileName = uuid.toString() + "_" + originalFileName;	
			
			File sendFile = new File(uploadPath + savedFileName);
			
			file.transferTo(sendFile);
		}
		
		model.addAttribute("originalFileNameList",originalFileNameList);
		
		return "upload/fileUploadMultipleResultView";
	}
	
	@PostMapping("/fileOriginalNameUpload")
	public String fileOriginalNameUpload(@RequestParam("uploadFileOriginal") MultipartFile file, Model model) throws IOException {
		
		String uploadPath = "C:/Users/soooo/Documents/dev/dev-study/backend-study/spring/springbootWorkspace/upload/product_image/";

		String originalFileName = file.getOriginalFilename(); // 전송된 파일의 원본명
		
		File sendFile = new File(uploadPath + originalFileName);
		
		file.transferTo(sendFile);
		
		model.addAttribute("originalFileName", originalFileName);
		
		return "upload/fileUploadResultView";
	}
	
}
