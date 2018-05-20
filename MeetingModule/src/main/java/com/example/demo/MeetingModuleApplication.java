package com.example.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Client;

import com.example.models.Meeting;

import com.example.repository.MeetingRepository;

@EnableDiscoveryClient
@EntityScan("com.example.models")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class MeetingModuleApplication  implements CommandLineRunner{


	@Autowired
	MeetingRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(MeetingModuleApplication.class, args);
	}
	 java.util.Date utilDate = new java.util.Date();
	/*    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    
	    @Override
		public void run(String... args) throws Exception {
			//repository.save(new Task(d,"zadatak1", "desc1"));
			repository.save(new Meeting(sqlDate,"Meeting1","Drzavni sud"));
			//repository.save(new Hearing(date3,"Drzavni sud"));
			//repository.save(new Hearing(date4,"Drzavni sud"));
			//repository.save(new Hearing(date5,"Federalni sud"));
			
		}*/
	 @Transactional
		@Override
		public void run(String... arg0) throws Exception {
			
			// delete all tables
			repository.deleteAll();
			
			Meeting meeting1 = new Meeting("Meeting1","Meeting Place1");
			Meeting meeting2 = new Meeting("Meetings2","Meeting Place 123");
			
			Client cli1 = new Client("Zeljko Stasic");
			Client cli2 = new Client("Ana Tomic");
			
			Set<Client> clients = new HashSet<Client>();
			clients.add(cli1);
			clients.add(cli2);
			
			meeting1.setClients(clients);
			meeting2.setClients(clients);
			
			repository.save(meeting1);
			repository.save(meeting2);
		}
	 @RestController
		class ServiceInstanceRestController {

		    @Autowired
		    private DiscoveryClient discoveryClient;

		    @RequestMapping("/service-instances/{applicationName}")
		    public List<ServiceInstance> serviceInstancesByApplicationName(
		            @PathVariable String applicationName) {
		        return this.discoveryClient.getInstances(applicationName);
		    }
	}
}
