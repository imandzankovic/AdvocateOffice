package com.example.demo;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestClientException;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import com.example.controllers.ConsumerControllerClient;
import com.example.models.CaseInfo;
import com.example.models.Category;
import com.example.models.Client;
import com.example.repository.CategoryRepository;
import com.example.repository.ClientRepository;

@EnableEurekaServer
@EntityScan("com.example.models")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class CaseModuleApplication {
	
	//@Autowired
	//ClientRepository clientRepository;
	//@Autowired
	//CategoryRepository categoryRepository;



		public static void main(String[] args) throws RestClientException, IOException
		{ApplicationContext ctx = SpringApplication.run(
				CaseModuleApplication.class, args);
		ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
		System.out.println(consumerControllerClient);
		consumerControllerClient.getTask();
	}
	
	
	/*@Override
	public void run(String... args) throws Exception {*/
		/*
		 * Apple Category & CaseInfos
		 */
		// initial Category and CaseInfos 
		/*CaseInfo case1 = new CaseInfo("Federalni sud");
		CaseInfo case2 = new CaseInfo("Federalni sud");
		
		Set<CaseInfo> appleCaseInfos = Stream.of(case1, case2).collect(Collectors.toSet());
		
		Category apple = new Category("Terorizam", appleCaseInfos);
		
		case1.setCategory(apple);
		case2.setCategory(apple);
		//Client client1=new Client("Denis Tahic",appleCaseInfos);
		//Client client2=new Client("Damir Tadic",appleCaseInfos);
		
		//case1.setClient(client1);
		//case2.setClient(client1);
		// send message to ActiveMQ
		//clientRepository.save(client1);
		//categoryRepository.save(apple);
        
        /*
         * Samsung Category and CaseInfos
         */
		/*CaseInfo case4 = new CaseInfo("Federalni sud");
		CaseInfo case5 = new CaseInfo("BIH Sud");
		
	Set<CaseInfo> samsungCaseInfos = Stream.of(case4, case5).collect(Collectors.toSet());
		
		//Category samsung = new Category("Terorizam", samsungCaseInfos);
		//case4.setCategory(samsung);
		//case5.setCategory(samsung);
		
		Client c1=new Client("Amir Hamzic",samsungCaseInfos);
		case4.setClient(c1);
		case5.setClient(c1);
         
		clientRepository.save(c1);
	}*/
	@Bean
	public  ConsumerControllerClient  consumerControllerClient()
	{
		return  new ConsumerControllerClient();
	}
}

