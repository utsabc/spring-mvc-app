package com.resource.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api("Sample controller")
public class BaseController {

    private final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ApiOperation("Test for get api")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> index() {
		return ResponseEntity.ok("Hello World");
       

    }

    private String getMessage() {
        return "Hello World";
    }


}
