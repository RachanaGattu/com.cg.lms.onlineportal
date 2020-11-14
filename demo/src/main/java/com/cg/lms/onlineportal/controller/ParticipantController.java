package com.cg.lms.onlineportal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.onlineportal.dto.Participant;
import com.cg.lms.onlineportal.exceptions.RecordNotFoundException;
import com.cg.lms.onlineportal.service.ParticipantService;





//connect from postman as http://localhost:5555/participant/
@RestController
@RequestMapping("/Participant_details")
public class ParticipantController{


	Logger log = LoggerFactory.getLogger(ParticipantController.class);
	
	@Autowired
	private ParticipantService participantService;
	


@GetMapping(value = {"/" })
public @ResponseBody List<Participant> getAllParticipant() 
{ 
	
	List<Participant> participant = participantService.getAllParticipants();
	
	return participant;
}

@GetMapping("/{participantid}")
public  ResponseEntity<Participant> getParticipantById(@PathVariable int participantid) {
if(participantService.getParticipantById(participantid)==null)
{
	throw new RecordNotFoundException("Record not found with id:"+participantid);
}
else
{
	return new ResponseEntity<Participant>(participantService.getParticipantById(participantid),HttpStatus.OK);
}
}



@PostMapping("/")
public ResponseEntity<Participant> add(@RequestBody Participant participant)
{
	int participantid=participantService.addParticipant(participant);
	if(participantid!=0)
	{
		return new ResponseEntity<Participant>(participantService.getParticipantById(participantid),HttpStatus.OK);
	}
	else
	{
		throw new RecordNotFoundException("ID already exists");
	}
}
@PutMapping("/{participantid}")
public  ResponseEntity<Participant> updateParticipant(@RequestBody Participant participant) 
{
	if(participantService.updateParticipant(participant).getId()==0)
	{
		throw new RecordNotFoundException("Record not found");
	}
	else {
		return new ResponseEntity<Participant>(participantService.updateParticipant(participant),HttpStatus.OK);
	}
}

@DeleteMapping("/{participantid}")
public  ResponseEntity<Participant> removeParticipant(@PathVariable int participantid) 
{
	Participant participant=participantService.getParticipantById(participantid);
	if(participantService.removeParticipantbyId(participantid))
	{
		return new ResponseEntity<Participant>(participant,HttpStatus.OK);
	}
	else
	{
		System.out.println("No Record is found");
		throw new RecordNotFoundException("Record not found with id:"+participantid);
	}
}


}
