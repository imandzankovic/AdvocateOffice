package com.example.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Category;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 

 
@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}