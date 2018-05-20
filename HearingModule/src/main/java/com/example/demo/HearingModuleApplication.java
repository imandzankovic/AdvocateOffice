package com.example.demo;


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
import com.example.models.Hearing;
import com.example.repository.HearingRepository;

@EnableDiscoveryClient
@EntityScan("com.example.models")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class HearingModuleApplication implements CommandLineRunner {
//public class HearingModuleApplication {
	
	@Autowired
	HearingRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(HearingModuleApplication.class, args);
	}
	
	/* java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	//Date date2 = new GregorianCalendar(2015, Calendar.MARCH, 5).getTime();
	
	//Date date3 = new GregorianCalendar(2015, Calendar.JUNE, 10).getTime();
	//Date date4 = new GregorianCalendar(2015, Calendar.JULY, 11).getTime();
	//Date date5 = new GregorianCalendar(2015, Calendar.SEPTEMBER, 12).getTime();
	
	@Override
	public void run(String... args) throws Exception {
		//repository.save(new Task(d,"zadatak1", "desc1"));
		repository.save(new Hearing(sqlDate,"SUD123"));
		//repository.save(new Hearing(date3,"Drzavni sud"));
		//repository.save(new Hearing(date4,"Drzavni sud"));
		//repository.save(new Hearing(date5,"Federalni sud"));
		
	}*/
	@Transactional
	@Override
	public void run(String... arg0) throws Exception {
		
		// delete all tables
		repository.deleteAll();
		
		Hearing hearing1 = new Hearing("Hearing Place1");
		Hearing hearing2 = new Hearing("Peter 123");
		
		Client cli1 = new Client("Zeljko Jovanovic");
		Client cli2 = new Client("Zeljko Tomic");
		
		Set<Client> clients = new HashSet<Client>();
		clients.add(cli1);
		clients.add(cli2);
		
		hearing1.setClients(clients);
		hearing2.setClients(clients);
		
		repository.save(hearing1);
		repository.save(hearing2);
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
