package com.cg.lms.onlineportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.onlineportal.dto.Feedback;





@Repository
public interface FeedbackDao  extends JpaRepository <Feedback,Integer> {
	
	List<Feedback> findAll();
	void deleteById(int feedbackid);
	

}
