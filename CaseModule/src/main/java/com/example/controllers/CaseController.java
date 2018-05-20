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

import com.example.models.CaseInfo;
import com.example.models.Client;
import com.example.service.CaseService;


@RestController
public class CaseController {

	@Autowired
	private CaseService caseService;

	@GetMapping("/cases/{caseId}/client")
	public Client retrieveClientForCase(@PathVariable int caseId) {
		return caseService.retrieveClient(caseId);
	}
	
	@GetMapping("/cases/{caseId}/clients/{clientId}")
	public Client retrieveDetailsForCourse(@PathVariable int caseId,
			@PathVariable int clientId) {
		return caseService.retrieveClient(caseId, clientId);
	}
	
	@PostMapping("/cases/{caseId}/clients")
	public ResponseEntity<Void> registerCaseForClient(
			@PathVariable int caseId, @RequestBody Client newClient) {

		Client client = caseService.addClient(caseId, newClient);

		if (client == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(client.getClientId()).toUri();

		return ResponseEntity.created(location).build();
	}
	@PostMapping("/clients/{clientId}/cases")
	public ResponseEntity<Void> registerClientForCase(
			@PathVariable int clientId, @RequestBody CaseInfo newCaseInfo) {

		CaseInfo caseInfo = caseService.addCaseInfo(clientId, newCaseInfo);

		if (caseInfo == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(caseInfo.getCaseId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
