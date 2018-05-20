package com.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.models.Client;
 

 
@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {
}