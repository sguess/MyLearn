package com.sguess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sguess.beans.Excel;
import com.sguess.service.IPoiService;

@Service
public class PoiServiceImpl implements IPoiService {

	@Override
	public List<Excel> parseFile(MultipartFile file) {
		return new ArrayList<Excel>();
	}

}
