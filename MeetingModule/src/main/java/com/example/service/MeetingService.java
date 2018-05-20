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
import com.example.models.Meeting;
import com.example.repository.MeetingRepository;


@Component
public class MeetingService {
	private MeetingRepository repo;

	//private static List<Meeting> meetings = new ArrayList<>();
	
	private  List<Meeting> meetings = (List<Meeting>) repo.findAll();

	/*static {
		//Initialize Data
		Meeting meeting1 = new Meeting("MeetingTitle","Meeting Place1");
		Meeting meeting2 = new Meeting("MeetingTitle2","Peter 123");
		
		Client cli1 = new Client("Zeljko Jovanovic");
		Client cli2 = new Client("Zeljko Tomic");
		
		Set<Client> clients = new HashSet<Client>();
		clients.add(cli1);
		clients.add(cli2);
		
		meeting1.setClients(clients);
		meeting2.setClients(clients);
		
		meetings.add(meeting1);
		meetings.add(meeting2);
	}*/

	public List<Meeting> retrieveAllMeetings() {
		return meetings;
	}

	public Meeting retrieveMeeting(int meetingId) {
		for (Meeting meeting : meetings) {
			int id=meeting.getMeetingId();
			if (id==meetingId) {
				return meeting;
			}
		}
		return null;
	}

	public Set<Client> retrieveClients(int meetingId) {
		Meeting meeting = retrieveMeeting(meetingId);

		if (meeting == null) {
			return null;
		}

		return meeting.getClients();
	}

	public Client retrieveClient(int meetingId, int clientId) {
		Meeting meeting = retrieveMeeting(meetingId);

		if (meeting == null) {
			return null;
		}

		for (Client client : meeting.getClients()) {
			int id=client.getClientId();
			if (id==clientId) {
				return client;
			}
		}

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public Client addClient(int meetingId, Client client) {
		Meeting meeting = retrieveMeeting(meetingId);

		if (meeting == null) {
			return null;
		}

		int randomId = new BigInteger(130, random).intValue();
		client.setClientId(randomId);

		meeting.getClients().add(client);

		return client;
	}
}