package com.example.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.models.Hearing;
 
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 

 
@RepositoryRestResource(collectionResourceRel = "hearing", path = "hearing")
public interface HearingRepository extends PagingAndSortingRepository<Hearing, Integer> {
}