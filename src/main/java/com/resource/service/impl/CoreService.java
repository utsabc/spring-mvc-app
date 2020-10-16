package com.resource.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resource.dao.MongoDAO;
import com.resource.model.IDocumentModel;
import com.resource.model.impl.WorkFlow;
import com.resource.service.ICoreService;
import com.resource.service.search.SearchParameter;
import com.resource.util.AppConstants;

@Service
public class CoreService implements ICoreService{
	
	@Autowired
	MongoDAO mongoDAO;

	@Override
	public IDocumentModel save(IDocumentModel doc) {
		doc.setEntityId(generateEntityID(AppConstants.MongoApi.mongoDBCollection));
		mongoDAO.insert(doc);
		return doc;
	}
	@Override
	public IDocumentModel update(IDocumentModel doc) {
		if(null == doc.getEntityId() || doc.getEntityId() <= 0) {
			throw new RuntimeException("Invalid document for update");
		}
		Query query = new Query();
		query.addCriteria(Criteria.where("entityId").is(doc.getEntityId()));
		mongoDAO.update(query.getQueryObject().toString(), doc);
		return doc;
	}
	@Override
	public Collection<IDocumentModel> search(SearchParameter searchparam) {
		Collection<IDocumentModel> result= new LinkedHashSet<IDocumentModel>();
		List<String> queryParts = new LinkedList<>();
		Query query = new Query();
		String finalQuery = StringUtils.EMPTY;
		List<String> qAnd = new LinkedList<String>();
		List<String> qOr = new LinkedList<String>();
		query.addCriteria(Criteria.where("isActive").is(searchparam.isActive()));
		queryParts.add(query.getQueryObject().toString());
		if(null != searchparam.getEntityId())
			qAnd.add("'entityId':'"+searchparam.getEntityId()+"'");
		if(!StringUtils.isEmpty(searchparam.getStatus()))
			qAnd.add("'status':'"+searchparam.getStatus()+"'");
		if(!StringUtils.isEmpty(searchparam.getTitle()))
			qAnd.add("'title': {$regex: /^"+searchparam.getTitle()+"/}");
		if(!StringUtils.isEmpty(searchparam.getPriority()))
			qAnd.add("'priority':{$regex: /^"+searchparam.getPriority()+"/}");
		if(!StringUtils.isEmpty(searchparam.getProject()))
			qAnd.add("'project':'"+searchparam.getProject()+"'");
		
		StringBuilder finalAnd = new StringBuilder(" { $and: [");
		 qAnd.stream().map(q ->"{"+q+"}").forEach(qc->{
			 finalAnd.append(qc);
		});
		 finalAnd.append("] }");
		 queryParts.add(finalAnd.toString());
		 finalQuery = "{$and:["+queryParts.stream().map(String::toString).collect(Collectors.joining(","))+"]}";
		 result = mongoDAO.find(finalQuery);
		 return result;
	}

	private Long generateEntityID(String collectionName) {
		Long entityId;
		entityId = mongoDAO.getDocumentCount(collectionName);
		if(null == entityId)
			throw new RuntimeException("Unable to generate document ID");
		else
			entityId++;
		return entityId;
	}

}
