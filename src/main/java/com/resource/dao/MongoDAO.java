package com.resource.dao;

import java.util.Collection;
import java.util.LinkedList;

import javax.annotation.PostConstruct;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.resource.config.RepositoryConfiguration;
import com.resource.model.IDocumentModel;
import com.resource.model.impl.WorkFlow;
import com.resource.util.AppConstants;

@Repository
public class MongoDAO {
	private DB db;
	private Jongo jongo;
	
	@Autowired
	private RepositoryConfiguration repository;
	
	@Autowired
	private Environment env;
	
	@PostConstruct
	private void init() {
		repository.MongoConnector(env.getProperty("mongo.host"), Integer.parseInt(env.getProperty("mongo.port")), 
		env.getProperty("mongo.userid"), env.getProperty("mongo.password"));
		this.db = repository.connectToDB(AppConstants.MongoApi.mongoDB);
		this.jongo = new Jongo(db);
	}
	
	public void insert(IDocumentModel document) {
		MongoCollection  refData  = jongo.getCollection(AppConstants.MongoApi.mongoDBCollection);
		refData.save(document);
	}
	
	public void update(String query,IDocumentModel document) {
		MongoCollection  refData = jongo.getCollection(AppConstants.MongoApi.mongoDBCollection);
		refData.update(query, document);
	}
	
	public Collection<IDocumentModel> find(String query) {
		Collection<IDocumentModel> payload = new LinkedList<>();
		MongoCollection  refData = jongo.getCollection(AppConstants.MongoApi.mongoDBCollection);
		MongoCursor<WorkFlow> cursor = refData.find(query).as(WorkFlow.class);
		while(cursor.hasNext()) {
			payload.add(cursor.next());
		}
		return payload;
	}
	public Long getDocumentCount(String collectionName) {
		MongoCollection  collection  = jongo.getCollection(collectionName);
		return collection.count();
	}
	
	
}
