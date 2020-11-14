package com.cg.lms.onlineportal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.lms.onlineportal.dto.Question;
//import com.cg.lms.onlineportal.dto.Topic;
import com.cg.lms.onlineportal.service.QuestionService;
//import com.cg.lms.onlineportal.service.TopicService;

import org.springframework.validation.annotation.Validated;

import java.util.List;

import javax.validation.Valid;
//connect from postman as http://localhost:8080/books/
@Controller
@Validated
@RequestMapping("/question_details")
public class QuestionController{

	
	@Autowired
	private QuestionService topicService;
	


@GetMapping(value = {"/" })
public @ResponseBody List<Question> getLibraryBooks() 
{ 
	
	List<Question> topics = topicService.getAllQuestion();
	return topics;
}
@GetMapping("/{subject}")
public @ResponseBody List<Question> getTopicBySubject(@PathVariable("subject") String subject)
{
	return topicService.searchQuestionBySubject(subject);
}


@PostMapping("/")
public @ResponseBody Question addTopic(@Valid @RequestBody Question topic) 
{
	
		
	return topicService.addQuestion(topic);
}
@PutMapping("/{id}")
public @ResponseBody Question updateTopic(@PathVariable Long id,@RequestBody Question topic) 
{
	return topicService.updateQuestion(id, topic);
}
@DeleteMapping("/{id}")
public @ResponseBody String removeTopic(@PathVariable Long id) 
{
	return topicService.removeTopic(id);
}

}

