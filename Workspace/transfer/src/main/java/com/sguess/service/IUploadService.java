package com.sguess.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

	String uploadFile(MultipartFile file);
	
	String downloadFile(File file);

}
