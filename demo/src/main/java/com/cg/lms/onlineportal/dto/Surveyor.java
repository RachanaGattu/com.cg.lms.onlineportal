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
public class Surveyor
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Long surveyid;
	public Long getSurveyid() {
		return surveyid;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="questionid")
	private Question question;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Participantid")
	private Participant participant;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="feedbackid")
	private Survey survey;
	
	int noOfQuestions;
	@CreationTimestamp
	Date surveyDate;
	String surveyStatus;
	public Surveyor()
	{
		
	}
	public Surveyor(int noOfQuestions,Question question, String surveyStatus) 
	{
		super();
		this.noOfQuestions = noOfQuestions;
		this.question=question;
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
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Topic{");
		sb.append("id:").append(surveyid).append(",");
		sb.append("Topic").append(question);
		sb.append("No Of Questions:").append(noOfQuestions).append(",");
		sb.append("date:").append(surveyDate).append(",");
		sb.append("Survey Status:").append(surveyStatus).append(",");
		sb.append("}");
		return sb.toString();
}
}
