package com.cg.lms.onlineportal.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.onlineportal.dao.TopicDao;
import com.cg.lms.onlineportal.dto.Topic;


@Service
public class TopicService {

	@Autowired
	private TopicDao topicrep;

	public List<Topic> getAllTopics() {
		System.out.println("Topics...");
		return topicrep.findAll();
	}

	public List<Topic> getTopicByTopicName(String topicName) {
		List<Topic> topics=new ArrayList<Topic>();
		topicrep.findAll().forEach(topic1->topics.add(topic1));
		List<Topic> topicNameBasedtopics=new ArrayList<Topic>();
		for(Topic m:topics)
		{
			if(m.getTopicName().equals(topicName))
				topicNameBasedtopics.add(m);	
		}
		return topicNameBasedtopics;
	}

	public Topic addTopic(Topic topic) {
		try
		{
			return topicrep.save(topic);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Topic is not added.");
			e.printStackTrace();
			return null;
		}
		//System.out.println("Topic added.");
		//return topicrep.save(topic);

	}

	public Topic updateTopic(Topic topic) {
		try
		{
			return topicrep.save(topic);	
		}
	//	return topicrep.save(topic);
		catch(IllegalArgumentException e)
		{
			System.out.println("Topic is not added");
			e.printStackTrace();
			return null;
		}

	}

	public String removeTopic(long id) {
		System.out.println("Topic removed.");

		topicrep.deleteById(id);
		return "Topic deleted Sucessfully";
	}

}
