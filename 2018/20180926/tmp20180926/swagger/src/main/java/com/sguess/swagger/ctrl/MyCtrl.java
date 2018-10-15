package com.sguess.swagger.ctrl;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class MyCtrl {
    @ApiOperation(notes = "Corresponds to the 'notes' field of the operation.", value = "Corresponds to the `summary` field of the operation")
    @ApiImplicitParam(name = "name", value = "API value", required = true, dataType = "String", paramType = "path")
    @GetMapping("get/{name}")
    public String testName(@PathVariable("name") String name) {
        return "Testing " + name;
    }
}
