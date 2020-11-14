package com.cg.lms.onlineportal;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.lms.onlineportal.controller.QuestionController;
import com.cg.lms.onlineportal.dto.Question;
import com.cg.lms.onlineportal.service.QuestionService;
@ExtendWith(MockitoExtension.class)
public class TopicControllerTest {
	@Mock
    QuestionService topicservice;
	@InjectMocks
	QuestionController topiccontroller;
     @Test
	public void testaddTopic() 
          {
    	 Question topic=new Question();
		 Mockito.when(topiccontroller.addTopic(topic)).thenReturn(topic);
		 assertEquals(topic,topiccontroller.addTopic(topic));
		  }
	@Test
	public void testupdateTopic() {
		
		Question topic=new Question();
		Long id=156787L;
		Mockito.when(topiccontroller.updateTopic(id, topic)).thenReturn(topic);
         assertEquals(topic,topiccontroller.updateTopic(id, topic));
		    }
	
	 @Test
	 public void testviewTopicBySubject() 
	 {
		List<Question> topic=new ArrayList<Question>();
		String subject="john";
		Mockito.when(topiccontroller.getTopicBySubject(subject)).thenReturn(topic);
	    assertEquals(topic,topiccontroller.getTopicBySubject(subject));
    }
	@Test
	 public void testviewTopicList() 
	 {
		   List<Question> topic=new ArrayList<Question>();
	       Mockito.when(topiccontroller.getLibraryBooks()).thenReturn(topic);
	       assertEquals(topic,topiccontroller.getLibraryBooks());
	 }
	@Test
	 public void testRemoveTopic()
	 { 
	    Long id=1234L;
		 Mockito.when(topiccontroller.removeTopic(id)).thenReturn("Topic deleted Sucessfully");
	        assertEquals("Topic deleted Sucessfully",topiccontroller.removeTopic(id));
		 
	 }


	
}
