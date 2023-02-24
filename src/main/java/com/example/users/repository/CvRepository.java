package com.example.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.users.entities.Cv;

public interface CvRepository extends JpaRepository <Cv,Long> {

	Cv findByUserUserid(Long id);
	 @Query("select c from Cv c where c.publiccv = :etat and c.user.username like %:username")
	Cv findpubliccv(@Param("etat") int etat,@Param("username") String username);
	List<Cv> findByUserUsername(String username);

	

}
