package com.ap.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ap.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadFile(MultipartFile file, String path) {

		String originalFilename = file.getOriginalFilename();
		String filename = UUID.randomUUID().toString();
		String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
		String filenameWithExtension = filename + extension;
		String fullPathWithFileName = path + File.separator + filenameWithExtension;

		if (extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".jpg")
				|| extension.equalsIgnoreCase(".jpeg")) {

			File folder = new File(path);
			if (!folder.exists()) {

				folder.mkdirs();
			}
			try {
				Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			throw new RuntimeException("file with this etension " + extension + " not allowed ... ");
		}

		return filenameWithExtension;
	}

	@Override
	public InputStream getResource(String path, String name) {
		
		String fullPath=path+File.separator+name;
		InputStream inputStream=null;
		try {
			 inputStream=new FileInputStream(fullPath);
			 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return inputStream;
	}

}
