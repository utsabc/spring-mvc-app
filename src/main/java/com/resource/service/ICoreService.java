package com.resource.service;

import java.util.Collection;

import com.resource.model.IDocumentModel;
import com.resource.model.impl.WorkFlow;
import com.resource.service.search.SearchParameter;

public interface ICoreService {
	
	Collection<IDocumentModel> search(SearchParameter searchparam);

	IDocumentModel save(IDocumentModel doc);

	IDocumentModel update(IDocumentModel doc);
}
