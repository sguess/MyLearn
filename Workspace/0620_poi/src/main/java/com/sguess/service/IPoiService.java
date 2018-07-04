package com.sguess.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.sguess.beans.Excel;

public interface IPoiService {

    List<Excel> parseFile(MultipartFile file) throws IOException;

    List<Excel> parseFile(File file) throws InvalidFormatException, IOException;

}
