package com.cg.lms.onlineportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.onlineportal.dto.Participant;


@Repository
public interface ParticipantDao  extends JpaRepository <Participant,Integer> {
	
	List<Participant> findAll();
	void deleteById(int participantid);
	
	

}
