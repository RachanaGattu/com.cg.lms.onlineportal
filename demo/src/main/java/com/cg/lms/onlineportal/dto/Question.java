package com.cg.lms.onlineportal.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;



@Validated
@Entity
@Table
public class Question{
	
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Long id;

	public Long getId() {
		return id;
	}
	@NotNull(message=" Name is required")
    String title;
	String subject;
	@NotBlank
	@Size(min=2, max=20)
	@Pattern(regexp="^[a-zA-Z]{3,}$",message="Name of author is required")
	String author;
	@NotBlank
	@Size(min=2, max=20)
	@Pattern(regexp="^[a-zA-Z]{3,}$",message="Name of author is required")
	String publisher;
	int publishedYear;
	@NotEmpty
	@Pattern(regexp="^[9]{1}[0-9]{12}$",message=" ISBN is required")
	String isbn_code;
	int noOfQuestions;
	String topicDescription;
    public Question() 
    {
		
	}
public Question(String title, String subject, String author, String publisher, int publishedYear,
			String isbn_code, int noOfQuestions, String topicDescription) {
		super();
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
		this.isbn_code = isbn_code;
		this.noOfQuestions = noOfQuestions;
		this.topicDescription = topicDescription;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getPublishedYear() {
		return publishedYear;
	}


	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}


	public String getIsbn_code() {
		return isbn_code;
	}


	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}
   
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public String getTopicDescription() {
		return topicDescription;
	}
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Topic{");
		sb.append("id:").append(id).append(",");
		sb.append("title:").append(title).append(",");
		sb.append("subject:").append(subject).append(",");
		sb.append("publisher").append(publisher).append(",");
		sb.append("publishYear:").append(publishedYear).append(",");
		sb.append("isbn_code:").append(isbn_code).append(",");
		sb.append("No Of Questions:").append(noOfQuestions).append(",");
		sb.append("Topic Description:").append(topicDescription);
		sb.append("}");
		
		return sb.toString();
	}
	
	
	
	
	
	
	
	


}
	
