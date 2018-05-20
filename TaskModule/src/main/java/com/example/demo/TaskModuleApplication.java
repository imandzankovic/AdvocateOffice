package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.example.models.Task;
import com.example.repository.TaskRepository;



import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@EnableDiscoveryClient
@EntityScan("com.example.models")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class TaskModuleApplication implements CommandLineRunner {

	@Autowired
	TaskRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(TaskModuleApplication.class, args);
	}
	
	
     
     
	
	Date date2 = new GregorianCalendar(2015, Calendar.MARCH, 5).getTime();
	
	Date date3 = new GregorianCalendar(2015, Calendar.JUNE, 10).getTime();
	Date date4 = new GregorianCalendar(2015, Calendar.JULY, 11).getTime();
	Date date5 = new GregorianCalendar(2015, Calendar.SEPTEMBER, 12).getTime();
	
	@Override
	public void run(String... args) throws Exception {
		//repository.save(new Task(d,"zadatak1", "desc1"));
		repository.save(new Task(date2,"zadatak2", "desc2"));
		repository.save(new Task(date3,"zadatak3", "desc3"));
		repository.save(new Task(date4,"zadatak4", "desc4"));
		repository.save(new Task(date5,"zadatak5", "desc5"));
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
