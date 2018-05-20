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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.models.Client;
import com.example.service.HearingService;


@RestController
public class HearingController {

	@Autowired
	private HearingService hearingService;

	@GetMapping("/hearings/{hearingId}/clients")
	public Set<Client> retrieveClientsForHearing(@PathVariable int hearingId) {
		return hearingService.retrieveClients(hearingId);
	}
	
	@GetMapping("/hearings/{hearingId}/clients/{clientId}")
	public Client retrieveDetailsForCourse(@PathVariable int hearingId,
			@PathVariable int clientId) {
		return hearingService.retrieveClient(hearingId, clientId);
	}
	
	@PostMapping("/hearings/{hearingId}/clients")
	public ResponseEntity<Void> registerHearingForClient(
			@PathVariable int hearingId, @RequestBody Client newClient) {

		Client client = hearingService.addClient(hearingId, newClient);

		if (client == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(client.getClientId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
