package com.cg.lms.onlineportal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.onlineportal.dao.SurveyDao;
import com.cg.lms.onlineportal.dto.Survey;

import com.cg.lms.onlineportal.exceptions.SurveyNotFoundException;




@Service
public class SurveyService {
	@Autowired
	private SurveyDao library;

	public List<Survey> getAllSurveys() {
		System.out.println("Topics...");
		return library.findAll();
	}

	public Survey getSurveyById(Long surveyid) 
	{
	System.out.println("Topic");
    
	Optional<Survey>optional= library.findById(surveyid);
    if(!optional.isPresent()){
        throw new SurveyNotFoundException("order not found for id="+surveyid);
    }
    else
    return optional.get();
   }
   public Survey addSurvey(Survey survey)
	{
		System.out.println("Topic added.");
		return library.save(survey);
	}

public Survey updateSurvey(Long surveyid, Survey survey) 
{
		System.out.println("Topic updated.");
		
		Optional<Survey> repSurvey = library.findById(surveyid);
		if(!repSurvey.isPresent()) {
			throw new SurveyNotFoundException("order not found for id="+surveyid);
}
      
else 
{
            Survey surveyToBeUpdated = repSurvey.get();
			surveyToBeUpdated.setNoOfQuestions(survey.getNoOfQuestions());
			surveyToBeUpdated.setTopic(survey.getTopic());
			surveyToBeUpdated.setSurveyDate(survey.getSurveyDate());
			surveyToBeUpdated.setSurveyStatus(survey.getSurveyStatus());
			return library.save(surveyToBeUpdated);

}
}
	
public String removeSurvey(Long surveyid) 
{
		System.out.println("Topic removed.");
		

			Optional<Survey>optional= library.findById(surveyid);
		    if(!optional.isPresent()){
		        throw new SurveyNotFoundException("survey not found for id="+surveyid);
		    }
		    else
		    library.deleteById(surveyid);
		    return "Topic deleted Sucessfully";
		  
        
}
}
