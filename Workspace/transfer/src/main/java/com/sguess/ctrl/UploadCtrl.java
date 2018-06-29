package com.sguess.ctrl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sguess.service.IUploadService;

@Controller
public class UploadCtrl {
	private static final Logger LOG = LoggerFactory.getLogger(UploadCtrl.class);
	@Autowired
	IUploadService service;

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam("file_data") MultipartFile file) throws IOException {
		String result = service.uploadFile(file);
		System.out.println("start to upload file" + file.getName());
		ResponseEntity<String> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
		LOG.info("upload successfull."+responseEntity.getBody());
		return result;
	}
	@RequestMapping(value = "/uploadFileBak", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFileBak(@RequestParam("file_data") MultipartFile file) throws IOException {
		String result = service.uploadFile(file);
		System.out.println("start to upload file" + file.getName());
		ResponseEntity<String> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
		LOG.info("upload successfull."+responseEntity.getBody());
		return responseEntity;
	}

}
