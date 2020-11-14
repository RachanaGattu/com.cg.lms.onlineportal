package com.cg.lms.onlineportal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import com.cg.lms.onlineportal.dto.Question;
import com.cg.lms.onlineportal.service.QuestionService;


public class QuestionServiceTest{
QuestionService service=mock(QuestionService.class);
Question question=new Question();
	
	@Test
	void testAdd() {
		
		
		when(service.addQuestion(question)).thenReturn(question);
		assertEquals(question.getId(),service.addQuestion(question));
		
	}

	
	
}
