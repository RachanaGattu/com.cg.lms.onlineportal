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

import com.cg.lms.onlineportal.dto.Surveyor;

import com.cg.lms.onlineportal.service.SurveyorService;


@Controller
@RequestMapping("/surveyor_details")
public class SurveyorController {
Logger log = LoggerFactory.getLogger(SurveyorController.class);
	
@Autowired
private SurveyorService surveyorService;
	
@GetMapping(value = {"/" })
public @ResponseBody List<Surveyor> getLibraryBooks() 
{ 
	List<Surveyor> surveyor = surveyorService.getAllSurveyors();
	return surveyor;
}

@GetMapping("/{surveyorid}")
public @ResponseBody  Surveyor getSurveyorById(@PathVariable Long surveyorid) 
{
	return surveyorService.getSurveyorById(surveyorid);
}

@PostMapping("/")
public @ResponseBody Surveyor addSurveyor(@RequestBody Surveyor surveyor) 
{
	return surveyorService.addSurveyor(surveyor);
}

@PutMapping("/{surveyorid}")
public @ResponseBody Surveyor updateSurveyor(@PathVariable Long surveyorid,@RequestBody Surveyor surveyor) 
{
	return surveyorService.updateSurveyor(surveyorid, surveyor);
}

@DeleteMapping("/{surveyorid}")
public @ResponseBody String removeSurveyor(@PathVariable Long surveyorid) 
{
	return surveyorService.removeSurveyor(surveyorid);
}
}
