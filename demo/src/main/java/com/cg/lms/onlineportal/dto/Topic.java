package com.cg.lms.onlineportal.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Topic {
	@Id
	@GeneratedValue
	Long id;
	String topicName;
	double rating;
	String description;
	
	public Topic() {
		super();
	}
	public Topic(Long id, String topicName, double rating, String description) {
		super();
		this.id = id;
		this.topicName = topicName;
		this.rating = rating;
		this.description = description;
	}
	public Topic(String topicName, double rating, String description) {
		super();
		this.topicName = topicName;
		this.rating = rating;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Topic{");
		sb.append("Id:").append(id).append(",");
		sb.append("TopicName:").append(topicName).append(",");
		sb.append("Rating:").append(rating).append(",");
		sb.append("descripition:").append(description).append("");
		sb.append("}");
		return sb.toString();
	}
	
}
