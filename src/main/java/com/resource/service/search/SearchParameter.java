package com.resource.service.search;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.resource.model.impl.User;
import com.resource.util.DateSerializer;

public class SearchParameter {
	private Long entityId;
	private String project;
	private String title;
	private String description;
	private String priority;
	private String assigneeId;
	@JsonSerialize(using = DateSerializer.class)
	private Date dueDate;
	@JsonSerialize(using = DateSerializer.class)
	private Date createdDate;
	@JsonSerialize(using = DateSerializer.class)
	private Date updatedDate;
	private String status;
	private boolean isActive;
	public Long getEntityId() {
		return entityId;
	}
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAssigneeId() {
		return assigneeId;
	}
	public void setAssigneeId(String assigneeId) {
		this.assigneeId = assigneeId;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}
