package com.example.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.models.Meeting;
 

 
@RepositoryRestResource(collectionResourceRel = "meeting", path = "meeting")
public interface MeetingRepository extends PagingAndSortingRepository<Meeting, Integer> {
	List<Meeting> findByDateOfMeeting(@Param("dateOMeeting") Date dateOfMeeting);
	List<Meeting> findByMeetingPlace(@Param("meetingPlace") String meetingPlace);
}
/*import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.models.Client;
 
*/
 
/*@RepositoryRestResource(collectionResourceRel = "meeting", path = "meeting")
public interface MeetingRepository extends PagingAndSortingRepository<Meeting, Integer> {

	@Modifying
	@Transactional
@Query("select count(i) from meeting i where i.client_id:client_id")
public List<Meeting>(@Param("client_id") int client_id);
}*/