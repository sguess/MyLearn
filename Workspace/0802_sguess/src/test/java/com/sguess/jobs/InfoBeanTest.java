package com.sguess.jobs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.boot.json.GsonJsonParser;

import java.io.IOException;

import static org.junit.Assert.*;

public class InfoBeanTest {
    @Test
    public void test() throws IOException {
        InfoBean bean = new InfoBean("code", "name", 123);
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(bean);
        System.out.println(str);

        String jsonStr = "{\"id\":0,\"code\":\"code\",\"name\":\"name\",\"value\":123}";
        InfoBean newBean = objectMapper.readValue(jsonStr, InfoBean.class);
        System.out.println(newBean.toString());
//
//
//        jsonStr = "{\"code\":\"code\",\"name\":\"name\",\"value\":123}";
//        newBean = objectMapper.readValue(jsonStr, InfoBean.class);
//        System.out.println(newBean.toString());
//        jsonStr = "{\"code\":\"code\",\"name\":\"name\",\"value\":123,\"temp\":\"Tmp\"}";
//        newBean = objectMapper.readValue(jsonStr, InfoBean.class);
//        System.out.println(newBean.toString());
    }
}