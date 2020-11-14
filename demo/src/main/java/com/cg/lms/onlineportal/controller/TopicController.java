package com.cg.lms.onlineportal.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.cg.lms.onlineportal.dto.Topic;
import com.cg.lms.onlineportal.service.TopicService;




//connect from postman as http://localhost:8080/movies/
@Controller
@RequestMapping("/topics")
class TopicController{

	Logger log = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private TopicService topicService;
	


@GetMapping(value = {"/" })
public @ResponseBody List<Topic> getAllTopics() 
{ 
	
	List<Topic> topics = topicService.getAllTopics();
	

	
	return topics;
}

@GetMapping("/{topicName}")
public @ResponseBody  List<Topic> getTopicByTopicName(@PathVariable String topicName) 
{
	
	return topicService.getTopicByTopicName(topicName);
}



@PostMapping("/")
public @ResponseBody Topic addTopic(@RequestBody Topic topic) 
{
	return topicService.addTopic(topic);
}

@PutMapping("/")
public @ResponseBody Topic updateTopic(@RequestBody Topic topic) 
{
	
	return topicService.updateTopic(topic);
}

@DeleteMapping("/{id}")
public @ResponseBody String removeTopic(@PathVariable Long id) 
{
	return topicService.removeTopic(id);
}


}
