package com.ap.service;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	
	String uploadFile(MultipartFile file,String path);
	
	InputStream getResource(String path,String name);

}
