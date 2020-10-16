package com.resource.model.impl;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.resource.model.IDocumentModel;
import com.resource.util.DateSerializer;

@Document
public class WorkFlow implements IDocumentModel{

	@JsonIgnore
	private Long entityId;
	private String project;
	private String title;
	@Indexed
	private String description;
	private String priority;
	private String assigneeId;
	private Collection<String>  watcherIdList;
	@JsonIgnore
	@Transient
	private Collection<User>  watcherList;
	@JsonSerialize(using = DateSerializer.class)
	private Date dueDate;
	@JsonSerialize(using = DateSerializer.class)
	private Date createdDate;
	@JsonSerialize(using = DateSerializer.class)
	private Date updatedDate;
	private Collection<String> tags;
	private String status;
	
	@JsonIgnore
	private boolean isActive = true;
	private Collection<String> commentIds;
	@JsonIgnore
	@Transient
	private Collection<Comment> comments;
	
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
	public Collection<String> getWatcherIdList() {
		return watcherIdList;
	}
	public void setWatcherIdList(Collection<String> watcherIdList) {
		this.watcherIdList = watcherIdList;
	}
	public Collection<User> getWatcherList() {
		return watcherList;
	}
	public void setWatcherList(Collection<User> watcherList) {
		this.watcherList = watcherList;
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
	public Collection<String> getTags() {
		return tags;
	}
	public void setTags(Collection<String> tags) {
		this.tags = tags;
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
	public Collection<String> getCommentIds() {
		return commentIds;
	}
	public void setCommentIds(Collection<String> commentIds) {
		this.commentIds = commentIds;
	}
	public Collection<Comment> getComments() {
		return comments;
	}
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
		
	}
	@Override
	public Long getEntityId() {
		return this.entityId;
	}
	
	
}
