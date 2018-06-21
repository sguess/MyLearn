package com.sguess.service.impl;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sguess.beans.Excel;
import com.sguess.service.IPoiService;

@Service
public class PoiServiceImpl implements IPoiService {
	private static final Logger log = LoggerFactory.getLogger(PoiServiceImpl.class);

	@Override
	public List<Excel> parseFile(MultipartFile file) throws IOException {
		System.err.print("-------->Start to parse the file:" + file.getName());
		XSSFWorkbook xbook=new XSSFWorkbook(file.getInputStream());
		Iterator<Sheet> sheetIt = xbook.sheetIterator();
		while(sheetIt.hasNext()) {
			Sheet sheet=sheetIt.next();
			log.info("--------->name: "+sheet.getSheetName());
		}
		return new ArrayList<Excel>();
	}

	/**
	 * SXSSFWorkbook sbook=new SXSSFWorkbook ();
	 * 
	 * XSSFWorkbook xbook=new XSSFWorkbook();
	 * 
	 * HSSFWorkbook hbook=new HSSFWorkbook();
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 */

	@Override
	public List<Excel> parseFile(File file) throws InvalidFormatException, IOException {
		assertTrue("The file should not be null", file != null);
		System.err.print("-------->Start to parse the file:" + file.getName());
		assertTrue("The " + file.getName() + " file exist status is " + file.exists(), file.exists());
		XSSFWorkbook xbook=new XSSFWorkbook(file);
		Iterator<Sheet> sheetIt = xbook.sheetIterator();
		while(sheetIt.hasNext()) {
			Sheet sheet=sheetIt.next();
//			parseSheet(sheet);
			log.info("--------->name: "+sheet.getSheetName());
		}
		
		
		return new ArrayList<Excel>();
	}

	private void parseSheet(Sheet sheet) {
		int lastRowNum = sheet.getLastRowNum();
		for(int i=0;i<lastRowNum;i++) {
			Row row=sheet.getRow(i);
			System.out.println();
			for(int j=0;j<row.getLastCellNum();j++) {
				Cell cell = row.getCell(j);
				String s=cell.getStringCellValue();
				
				System.out.print(s);
			}
		}
		
	}

	public static void main(String[] args) throws InvalidFormatException, IOException {
		PoiServiceImpl service = new PoiServiceImpl();
		String filePath = "C:\\tmp\\upload.xlsx";
		File file = new File(filePath);
		service.parseFile(file);
	}
}
