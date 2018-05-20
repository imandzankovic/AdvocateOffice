package com.example.controllers;


import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.models.Client;
import com.example.models.Meeting;
import com.example.repository.MeetingRepository;
import com.example.service.MeetingService;

//@RequestMapping("meeting")
@RestController
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	/*@Autowired
	private MeetingRepository mr;
*/
	@GetMapping("/meetings/{meetingId}/clients")
	public Set<Client> retrieveClientsForMeeting(@PathVariable int meetingId) {
		return meetingService.retrieveClients(meetingId);
	}
	
	@GetMapping("/meetings/{meetingId}/clients/{clientId}")
	public Client retrieveDetailsForCourse(@PathVariable int meetingId,
			@PathVariable int clientId) {
		return meetingService.retrieveClient(meetingId, clientId);
	}

/*	@RequestMapping("/getTMeetings")
	public List<Meeting> getMeetings(){
		List<Meeting> m;
		
		m=(List<Meeting>) mr.findAll();
		
		return m;
	}*/
	@PostMapping("/meetings/{meetingId}/clients")
	public ResponseEntity<Void> registerMeetingForClient(
			@PathVariable int meetingId, @RequestBody Client newClient) {

		Client client = meetingService.addClient(meetingId, newClient);

		if (client == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(client.getClientId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
