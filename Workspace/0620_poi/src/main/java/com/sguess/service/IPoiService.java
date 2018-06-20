package com.sguess.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sguess.beans.Excel;

public interface IPoiService {

	List<Excel> parseFile(MultipartFile file);

}
