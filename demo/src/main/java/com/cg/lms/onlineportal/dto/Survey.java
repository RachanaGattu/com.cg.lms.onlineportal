package com.cg.lms.onlineportal.dto;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table
public class Survey 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Long surveyid;
	public Long getSurveyid() {
		return surveyid;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="topicid")
	private Topic topic;
	int noOfQuestions;
	@CreationTimestamp
	Date surveyDate;
	String surveyStatus;
	public Survey()
	{
		
	}
	public Survey(int noOfQuestions,Topic topic, String surveyStatus) 
	{
		super();
		this.noOfQuestions = noOfQuestions;
		this.topic=topic;
		this.surveyStatus=surveyStatus;
		this.surveyDate = new Date();
	}
	
	public void setSurveyid(Long surveyid) {
		this.surveyid = surveyid;
	}
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public Date getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}
	public String getSurveyStatus() {
		return surveyStatus;
	}
	public void setSurveyStatus(String surveyStatus) {
		this.surveyStatus = surveyStatus;
	}
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Topic{");
		sb.append("id:").append(surveyid).append(",");
		sb.append("Topic").append(topic);
		sb.append("No Of Questions:").append(noOfQuestions).append(",");
		sb.append("date:").append(surveyDate).append(",");
		sb.append("Survey Status:").append(surveyStatus).append(",");
		sb.append("}");
		return sb.toString();
}
}
