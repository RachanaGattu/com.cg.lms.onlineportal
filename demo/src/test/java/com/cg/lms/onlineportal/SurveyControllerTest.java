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

//import com.cg.lms.onlineportal.controller.SurveyController;
import com.cg.lms.onlineportal.controller.SurveyorController;
import com.cg.lms.onlineportal.dto.Surveyor;
//import com.cg.lms.onlineportal.dto.Survey;
//import com.cg.lms.onlineportal.service.SurveyService;
import com.cg.lms.onlineportal.service.SurveyorService;




@ExtendWith(MockitoExtension.class)
public class SurveyControllerTest {
	@Mock
    SurveyorService surveyservice;
	@InjectMocks
	SurveyorController surveycontroller;

	@Test
	public void testPlaceSurvey()
	       {
		        Surveyor survey=new Surveyor();
		        Mockito.when(surveycontroller.addSurveyor(survey)).thenReturn(survey);
		        assertEquals(survey,surveycontroller.addSurveyor(survey));
		    }
	
	@Test
	public void testupdateSurvey() {
		
		Surveyor survey=new Surveyor();
		Long id=156787L;
		Mockito.when(surveycontroller.updateSurveyor(id, survey)).thenReturn(survey);
         assertEquals(survey,surveycontroller.updateSurveyor(id, survey));
		    }
	
	 @Test
	 public void testSurveyById() {
		Surveyor survey=new Surveyor();
		 Long id=1234L;
		 Mockito.when(surveycontroller.getSurveyorById(id)).thenReturn(survey);
	        assertEquals(survey,surveycontroller.getSurveyorById(id));
	        }
	 
	 @Test
	 public void testviewSurveyList() {
		 List<Surveyor> survey=new ArrayList<Surveyor>();
	       Mockito.when(surveycontroller.getLibraryBooks()).thenReturn(survey);
	        assertEquals(survey,surveycontroller.getLibraryBooks());
	 }
	 
	@Test
	 public void testRemoveSurvey()
	 { 
	    Long id=1234L;
		 Mockito.when(surveycontroller.removeSurveyor(id)).thenReturn("Topic deleted Sucessfully");
	        assertEquals("Topic deleted Sucessfully",surveycontroller.removeSurveyor(id));
		 
	 }


	
}
