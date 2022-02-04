package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileController {

	
	//파일업로드 폼
	@RequestMapping("/form")
	public String form() {
		System.out.println("FileController.form()");
		
		return "fileupload/form";
	}
	
	
	//파일업로드 처리
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		System.out.println("FileController.upload()");
		System.out.println(file);
		
		
		return "fileupload/result";
	}
	
	
	
}
