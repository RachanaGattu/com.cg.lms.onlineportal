package com.cg.lms.onlineportal.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Feedback_details")
public class Feedback {

       @Id
       @GeneratedValue
    private int id;

    private String Feedback;

	public Feedback() {
		super();
	}

	public Feedback(int id, String feedback) {
		super();
		this.id = id;
		Feedback = feedback;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedback() {
		return Feedback;
	}

	public void setFeedback(String feedback) {
		Feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", Feedback=" + Feedback + "]";
	}

}

   