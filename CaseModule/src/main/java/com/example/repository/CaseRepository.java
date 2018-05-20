package com.example.repository;


import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.models.CaseInfo;


/*@Repository
public interface CaseRepository extends CrudRepository<CaseInfo, Long> {
	
	Collection<CaseInfo> findAll();

}

	
	//List<Case> findByCourt(@Param("court") String court);
	//List<Case> findByCourtNumber(@Param("courtNumber") int courtNumber);
	//List<Case> findByJudge(@Param("judge") String judge);
	
*/
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 

 
@RepositoryRestResource(collectionResourceRel = "caseinfo", path = "caseinfo")
public interface CaseRepository extends PagingAndSortingRepository<CaseInfo, Integer> {
}