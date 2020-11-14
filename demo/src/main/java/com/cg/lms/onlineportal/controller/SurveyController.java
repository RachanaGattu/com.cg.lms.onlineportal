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
import com.cg.lms.onlineportal.dto.Survey;
import com.cg.lms.onlineportal.service.SurveyService;


@Controller
@RequestMapping("/surveys")
public class SurveyController {
Logger log = LoggerFactory.getLogger(SurveyController.class);
	
@Autowired
private SurveyService surveyService;
	
@GetMapping(value = {"/" })
public @ResponseBody List<Survey> getLibraryBooks() 
{ 
	List<Survey> surveys = surveyService.getAllSurveys();
	return surveys;
}

@GetMapping("/{surveyid}")
public @ResponseBody  Survey getSurveyById(@PathVariable Long surveyid) 
{
	return surveyService.getSurveyById(surveyid);
}

@PostMapping("/")
public @ResponseBody Survey addSurvey(@RequestBody Survey survey) 
{
	return surveyService.addSurvey(survey);
}

@PutMapping("/{surveyid}")
public @ResponseBody Survey updateSurvey(@PathVariable Long surveyid,@RequestBody Survey survey) 
{
	return surveyService.updateSurvey(surveyid, survey);
}

@DeleteMapping("/{surveyid}")
public @ResponseBody String removeTopic(@PathVariable Long surveyid) 
{
	return surveyService.removeSurvey(surveyid);
}
}
