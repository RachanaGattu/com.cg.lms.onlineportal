package com.cg.lms.onlineportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.onlineportal.dao.ParticipantDao;
import com.cg.lms.onlineportal.dto.Participant;



@Service
public class ParticipantService {

	@Autowired
	private ParticipantDao participantDao;

	// Participants List
	public List<Participant> getAllParticipants() {

		System.out.println("Participants");
		return participantDao.findAll();
	}

	// get Participants by id
	public Participant getParticipantById(int participantid) {

		return participantDao.findById(participantid).orElse(null);

	}
	// return participantDao.findById(id).orElse(new Participant());

	// Add Participants
	public int addParticipant(Participant participant) {

		if (participantDao.existsById(participant.getId())) {

			return 0;
		} else {

			return participantDao.save(participant).getId();

		}
	}

	// Update Participants
	public Participant updateParticipant(Participant participant) {
		if (participantDao.existsById(participant.getId())) {
			return participantDao.save(participant);

		} else {
			return new Participant();
		}
	}

	// Remove Participants
	public boolean removeParticipantbyId(int id) {
		if (participantDao.existsById(id)) {
			participantDao.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

}
