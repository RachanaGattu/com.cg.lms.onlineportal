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

import com.cg.lms.onlineportal.dto.Participant;
import com.cg.lms.onlineportal.service.ParticipantService;




public class ParticipantServiceTest{
ParticipantService service=mock(ParticipantService.class);
Participant participant=new Participant();
@Test
void testAdd() {
	
	
	when(service.addParticipant(participant)).thenReturn(participant.getId());
	assertEquals(participant.getId(),service.addParticipant(participant));
	
}

@Test
void testUpdate() {
	when(service.updateParticipant(participant)).thenReturn(participant);
	assertEquals(participant,service.updateParticipant(participant));
}

@Test
void testDelete() {
	when(service.removeParticipantbyId(participant.getId())).thenReturn(true);
	assertTrue(service.removeParticipantbyId(participant.getId()));
	
	when(service.removeParticipantbyId(participant.getId())).thenReturn(false);
	assertFalse(service.removeParticipantbyId(participant.getId()));
}

}
