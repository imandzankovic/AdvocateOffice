package com.example.repository;


/*import java.util.Date;

/*import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.models.*;

@RepositoryRestResource(path="tasks",collectionResourceRel="tasks")
public interface TaskRepository extends CrudRepository<Task, Long>{
	Task findById(@Param("id") long id);
	
	//vraca sve taskove koje je postavio user sa datim id-em
	@Query("select t from Task t, User u where t.user=ru and u.id=:id")
	public List<Task> getAllUserTasks(@Param("id") long id);
	
	@Query("select t from Task t")
	public List<Task> getAllTasks();
	
}*/

/*import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.models.Task;
 

 
@RepositoryRestResource(collectionResourceRel = "task", path = "task")
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
	
	List<Task> findByTitle(@Param("title") String title);
	
	
	
}*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}