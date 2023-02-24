package com.example.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.users.dto.JobDTO;
import com.example.users.entities.Job;


public interface JobRepository extends JpaRepository<Job, Long>{
	
	 @Query("select j from Job j where j.minsalary <= :minprix and j.maxsalary >= :maxprod or j.minsalary <= :maxprod and j.minsalary >= :minprix ")
	List<Job> findMaxPrix(@Param("maxprod") Integer maxprod,@Param("minprix") Integer minprix);

	 List<Job> findByUserUsername(String username);
	 @Query("select j from Job j " )
	 List<JobDTO> findAlldto();


}
