package com.resource.model.impl;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.resource.util.DateSerializer;

public class Comment {
	
	private Long commentId;
	private String commentText;
	@JsonSerialize(using = DateSerializer.class)
	private Date commentDate;
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
	

}
