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
import com.example.models.CaseInfo;

import com.example.repository.CaseRepository;

@Component
public class CaseService {

	//private static List<Case> cases = new ArrayList<>();
	private CaseRepository repo;

	
	
	private  List<CaseInfo> cases = (List<CaseInfo>) repo.findAll();
	/*static {
		//Initialize Data
		Case case1 = new Case("Case Place1");
		Case case2 = new Case("Peter 123");
		
		Client cli1 = new Client("Zeljko Jovanovic");
		Client cli2 = new Client("Zeljko Tomic");
		
		Set<Client> clients = new HashSet<Client>();
		clients.add(cli1);
		clients.add(cli2);
		
		case1.setClients(clients);
		case2.setClients(clients);
		
		cases.add(case1);
		cases.add(case2);
	}*/

	public List<CaseInfo> retrieveAllCases() {
		return cases;
	}

	public CaseInfo retrieveCase(int caseId) {
		for (CaseInfo caseInfo : cases) {
			int id=caseInfo.getCaseId();
			if (id==caseId) {
				return caseInfo;
			}
		}
		return null;
	}

	 public Client retrieveClient(int caseId) {
		CaseInfo caseInfo = retrieveCase(caseId);

		if (caseInfo == null) {
			return null;
		}
		
		return caseInfo.getClient();
		
	}

	public Client retrieveClient(int caseId, int clientId) {
		CaseInfo caseInfo = retrieveCase(caseId);

		if (caseInfo == null) {
			return null;
		}

		Client client=caseInfo.getClient(); 
			int id=client.getClientId();
			if (id==clientId) {
				return client;
			}
		

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public Client addClient(int caseId, Client client) {
		CaseInfo caseInfo = retrieveCase(caseId);

		if (caseInfo == null) {
			return null;
		}

		int randomId = new BigInteger(130, random).intValue();
		client.setClientId(randomId);

		caseInfo.setClient(client);

		return client;
	}

	public CaseInfo addCaseInfo(int clientId, CaseInfo caseInfo) {
		// TODO Auto-generated method stub
		Client client = retrieveClient(clientId);

		if (client == null) {
			return null;
		}

		int randomId = new BigInteger(130, random).intValue();
				caseInfo.setCaseId(randomId);

				caseInfo.setClient(client);

		return caseInfo;
		
	}
}