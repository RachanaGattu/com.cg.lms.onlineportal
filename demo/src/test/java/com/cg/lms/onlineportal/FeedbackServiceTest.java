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

import com.cg.lms.onlineportal.dto.Feedback;
import com.cg.lms.onlineportal.service.FeedbackService;



public class FeedbackServiceTest{
FeedbackService service=mock(FeedbackService.class);
Feedback feedback=new Feedback();
	
	@Test
	void testAdd() {
		
		
		when(service.addFeedback(feedback)).thenReturn(feedback.getId());
		assertEquals(feedback.getId(),service.addFeedback(feedback));
		
	}

	@Test
	void testUpdate() {
		when(service.updateFeedback(feedback)).thenReturn(feedback);
		assertEquals(feedback,service.updateFeedback(feedback));
	}

	@Test
	void testDelete() {
		when(service.delete(feedback.getId())).thenReturn(true);
		assertTrue(service.delete(feedback.getId()));
		
		when(service.delete(feedback.getId())).thenReturn(false);
		assertFalse(service.delete(feedback.getId()));
	}


}
