package com.resource.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.resource.dao.MongoDAO;
import com.resource.model.IDocumentModel;
import com.resource.model.impl.WorkFlow;
import com.resource.service.impl.CoreService;
import com.resource.service.search.SearchParameter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api("Sample controller")
@RequestMapping("api/base")
public class BaseController {
	
	@Autowired
	MongoDAO mongoDAO;
	
	@Autowired
	CoreService service;

    private final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ApiOperation("Search APi for Workflow")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<Collection<IDocumentModel>> search(@RequestBody SearchParameter searchParams) {
    	return ResponseEntity.ok(service.search(searchParams));
    }
    
    @ApiOperation("Save APi for saving WorkFlow")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<IDocumentModel> save(@RequestBody WorkFlow doc) {
    	return ResponseEntity.ok(service.save(doc));
    }


}
