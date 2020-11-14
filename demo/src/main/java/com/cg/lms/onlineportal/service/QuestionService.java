package com.cg.lms.onlineportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.onlineportal.dao.QuestionDao;
//import com.cg.lms.onlineportal.dao.TopicDao;
import com.cg.lms.onlineportal.dto.Question;
import com.cg.lms.onlineportal.exceptions.QuestionNotFoundException;
//import com.cg.lms.onlineportal.dto.Topic;
//import com.cg.lms.onlineportal.exceptions.TopicNotFoundException;


@Service
public class QuestionService {

	@Autowired
	private QuestionDao library;

	public List<Question> getAllQuestion() {
		System.out.println("Questions...");
		return library.findAll();
	}
		public Question addQuestion(Question question) {
		System.out.println("Question added.");
		return library.save(question);
	}

	public Question updateQuestion(Long id, Question question)
	{
		System.out.println("Question updated.");
		

		Optional<Question> repTopic = library.findById(id);
		if (!repTopic.isPresent()) 
		{
			throw new QuestionNotFoundException("Topic Not Found With the given id"+id);
		}

		else 
		{

			Question topicToBeUpdated = repTopic.get();
			topicToBeUpdated.setTitle(question.getTitle());
			topicToBeUpdated.setSubject(question.getSubject());
		    topicToBeUpdated.setAuthor(question.getAuthor());
			topicToBeUpdated.setPublisher(question.getPublisher());
			topicToBeUpdated.setPublishedYear(question.getPublishedYear());
		//	topicToBeUpdated.setIsbn_code(question.getIsbn_code());
			topicToBeUpdated.setNoOfQuestions(question.getNoOfQuestions());
			topicToBeUpdated.setTopicDescription(question.getTopicDescription());
			
			return library.save(topicToBeUpdated);
		}

    }
        public String removeTopic(Long topicId)
        {
		System.out.println("Topic removed.");

	
			Optional<Question>optional= library.findById(topicId);
		    if(!optional.isPresent()){
		        throw new QuestionNotFoundException("book not found for id="+topicId);
		    }
		    else
		    library.deleteById(topicId);
		    return "Topic deleted Sucessfully";
		    }
		    
         public List<Question> searchQuestionBySubject(String subject)
        {
        
        	List<Question> topic=new ArrayList<Question>();
    		library.findAll().forEach(topic1->topic.add(topic1));
    		List<Question> genreBasedMovies=new ArrayList<Question>();
    		for(Question m:topic)
    		{
    			if(m.getSubject().equals(subject))
    				genreBasedMovies.add(m);	
    		}
    		return genreBasedMovies;
        	

    	}
       
        
          
}


