package com.cg.lms.onlineportal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.onlineportal.dao.SurveyorDao;
import com.cg.lms.onlineportal.dto.Surveyor;
import com.cg.lms.onlineportal.exceptions.SurveyorNotFoundException;




@Service
public class SurveyorService {
	@Autowired
	private SurveyorDao surveyorDao;

	public List<Surveyor> getAllSurveyors() {
		System.out.println("Surveyor...");
		return surveyorDao.findAll();
	}

	public Surveyor getSurveyorById(Long surveyorid) 
	{
	System.out.println("Topic");
    
	Optional<Surveyor>optional= surveyorDao.findById(surveyorid);
    if(!optional.isPresent()){
        throw new SurveyorNotFoundException("order not found for id="+surveyorid);
    }
    else
    return optional.get();
   }
   public Surveyor addSurveyor(Surveyor surveyor)
	{
		System.out.println("Surveyor added.");
		return surveyorDao.save(surveyor);
	}

public Surveyor updateSurveyor(Long surveyorid, Surveyor surveyor) 
{
		System.out.println("Surveyor updated.");
		
		Optional<Surveyor> repSurveyor = surveyorDao.findById(surveyorid);
		if(!repSurveyor.isPresent()) {
			throw new SurveyorNotFoundException("order not found for id="+surveyorid);
}
      
else 
{
            Surveyor surveyorToBeUpdated = repSurveyor.get();
			surveyorToBeUpdated.setNoOfQuestions(surveyor.getNoOfQuestions());
			surveyorToBeUpdated.setQuestion(surveyor.getQuestion());
			surveyorToBeUpdated.setSurveyDate(surveyor.getSurveyDate());
			surveyorToBeUpdated.setSurveyStatus(surveyor.getSurveyStatus());
			return surveyorDao.save(surveyorToBeUpdated);

}
}
	
public String removeSurveyor(Long surveyorid) 
{
		System.out.println("Surveyor removed.");
		

			Optional<Surveyor>optional= surveyorDao.findById(surveyorid);
		    if(!optional.isPresent()){
		        throw new SurveyorNotFoundException("survey not found for id="+surveyorid);
		    }
		    else
		    	surveyorDao.deleteById(surveyorid);
		    return "Topic deleted Sucessfully";
		  
        
}
}
