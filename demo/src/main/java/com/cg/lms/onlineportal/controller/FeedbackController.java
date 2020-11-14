package com.cg.lms.onlineportal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.onlineportal.dto.Feedback;
import com.cg.lms.onlineportal.exceptions.RecordNotFoundException;
import com.cg.lms.onlineportal.service.FeedbackService;




//connect from postman as http://localhost:1234/feedback/
@RestController
@RequestMapping("/Feedback_details")
public class FeedbackController{


	Logger log = LoggerFactory.getLogger(FeedbackController.class);
	
	@Autowired
	private FeedbackService feedbackService;

@GetMapping(value = {"/"})
public @ResponseBody List<Feedback> getAllFeedback() 
{ 
	
	List<Feedback> feedback = feedbackService.getAllFeedbacks();
	
	return feedback;
}
@GetMapping("/{feedbackid}")
public ResponseEntity<Feedback> getFeedbackById (@PathVariable int feedbackid)
{
	if(feedbackService.getFeedbackById(feedbackid)==null)
	{
		throw new RecordNotFoundException("Record not found with id:"+feedbackid);
	}
	else
	{
		return new ResponseEntity<Feedback>(feedbackService.getFeedbackById(feedbackid),HttpStatus.OK);
	}
}
@PostMapping("/")
public ResponseEntity<Feedback> add(@RequestBody Feedback feedback)
{
	int feedbackid=feedbackService.addFeedback(feedback);
	if(feedbackid!=0)
	{
		return new ResponseEntity<Feedback>(feedbackService.getFeedbackById(feedbackid),HttpStatus.OK);
	}else
	{
		throw new RecordNotFoundException("ID already exists");
	}
}

@PutMapping("/{feedbackid}")
public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback)
{
	if(feedbackService.updateFeedback(feedback).getId()==0)
	{
		throw new RecordNotFoundException("Record not found");
	}
	else {
		return new ResponseEntity<Feedback>(feedbackService.updateFeedback(feedback),HttpStatus.OK);
	}
}

@DeleteMapping("/{feedbackid}")
public ResponseEntity<Feedback> delete(@PathVariable int feedbackid)
{
	Feedback feedback=feedbackService.getFeedbackById(feedbackid);
	if(feedbackService.delete(feedbackid))
	{
		return new ResponseEntity<Feedback>(feedback,HttpStatus.OK);
	}
	else
	{
		System.out.println("No Record is found");
		throw new RecordNotFoundException("Record not found with id:"+feedbackid);
	}
}

}
