package com.sguess.ctrl;

import com.sguess.beans.APIMessage;
import com.sguess.beans.APIRequestdata;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiCtrl {
    @RequestMapping(value = "/fun01", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public APIMessage fun01(@RequestBody @Valid APIRequestdata data, @RequestHeader HttpHeaders header) {
        List<String> authHeaderLists = header.get(HttpHeaders.AUTHORIZATION);
        if (authHeaderLists.size() == 0) {
            return new APIMessage(HttpStatus.UNAUTHORIZED.toString(), "error in auth", "");
        }
        String userName = getUserAccountFromAuthorizationHeader(authHeaderLists.get(0));
        return new APIMessage(HttpStatus.OK.toString(), "Login successful" + userName, "");
    }

    private String getUserAccountFromAuthorizationHeader(String authStr) {
        String baseStr = "Basic ";
        if (!authStr.contains(baseStr)) {
            return "";
        }
        String accountStr = new String(Base64.decodeBase64(authStr.replace(baseStr, "")));
        String[] accountStrArrays = accountStr.split(":");
        if (accountStrArrays.length != 2) {
            return "";
        }
        return accountStrArrays[0];
    }
}
