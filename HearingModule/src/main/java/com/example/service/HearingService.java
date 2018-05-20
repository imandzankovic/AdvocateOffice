package com.example.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.models.Client;
import com.example.models.Hearing;

import com.example.repository.HearingRepository;

@Component
public class HearingService {

	//private static List<Hearing> hearings = new ArrayList<>();
	private HearingRepository repo;

	
	
	private  List<Hearing> hearings = (List<Hearing>) repo.findAll();
	/*static {
		//Initialize Data
		Hearing hearing1 = new Hearing("Hearing Place1");
		Hearing hearing2 = new Hearing("Peter 123");
		
		Client cli1 = new Client("Zeljko Jovanovic");
		Client cli2 = new Client("Zeljko Tomic");
		
		Set<Client> clients = new HashSet<Client>();
		clients.add(cli1);
		clients.add(cli2);
		
		hearing1.setClients(clients);
		hearing2.setClients(clients);
		
		hearings.add(hearing1);
		hearings.add(hearing2);
	}*/

	public List<Hearing> retrieveAllHearings() {
		return hearings;
	}

	public Hearing retrieveHearing(int HearingId) {
		for (Hearing hearing : hearings) {
			int id=hearing.getHearingId();
			if (id==HearingId) {
				return hearing;
			}
		}
		return null;
	}

	public Set<Client> retrieveClients(int HearingId) {
		Hearing Hearing = retrieveHearing(HearingId);

		if (Hearing == null) {
			return null;
		}

		return Hearing.getClients();
	}

	public Client retrieveClient(int HearingId, int ClientId) {
		Hearing hearing = retrieveHearing(HearingId);

		if (hearing == null) {
			return null;
		}

		for (Client client : hearing.getClients()) {
			int id=client.getClientId();
			if (id==ClientId) {
				return client;
			}
		}

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public Client addClient(int HearingId, Client client) {
		Hearing hearing = retrieveHearing(HearingId);

		if (hearing == null) {
			return null;
		}

		int randomId = new BigInteger(130, random).intValue();
		client.setClientId(randomId);

		hearing.getClients().add(client);

		return client;
	}
}