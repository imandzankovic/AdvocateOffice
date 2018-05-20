package com.example.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Client;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 

 
@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {
}