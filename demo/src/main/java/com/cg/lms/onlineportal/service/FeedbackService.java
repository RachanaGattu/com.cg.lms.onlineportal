package com.cg.lms.onlineportal.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.lms.onlineportal.dao.FeedbackDao;
import com.cg.lms.onlineportal.dto.Feedback;



@Service
public class FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	public List<Feedback> getAllFeedbacks() {
		System.out.println("Feedbacks...");
		
		return feedbackDao.findAll();
		
	}

	public Feedback getFeedbackById(int feedbackid) {
		return feedbackDao.findById(feedbackid).orElse(null);
	}

	public int addFeedback(Feedback feedback){
		if(feedbackDao.existsById(feedback.getId()))
		{
			return 0;
		}
		else {
			return feedbackDao.save(feedback).getId();
		}
	}

	public Feedback updateFeedback(Feedback feedback){
		if(feedbackDao.existsById(feedback.getId()))
		{
			return feedbackDao.save(feedback);
		}
		else
		{
			return new Feedback();
		}
	}
public boolean delete(int id) {
		
		if(feedbackDao.existsById(id))
		{
			feedbackDao.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
}


}

