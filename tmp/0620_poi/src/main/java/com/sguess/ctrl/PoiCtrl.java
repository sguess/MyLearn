package com.sguess.ctrl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sguess.beans.Excel;
import com.sguess.service.IPoiService;

@Controller
public class PoiCtrl {
    @Autowired
    IPoiService service;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("file_data") MultipartFile file) throws IOException {
        service.parseFile(file);
        System.out.println("start to upload file" + file.getName());
        String jsonStr = null;
        ObjectMapper objMpper = new ObjectMapper();
        List<Excel> rstList = service.parseFile(file);
        System.out.println("--->:" + rstList.size());
        return new ResponseEntity<>(rstList, HttpStatus.OK);
    }
}
