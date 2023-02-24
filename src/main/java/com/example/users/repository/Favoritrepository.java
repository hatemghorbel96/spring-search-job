package com.example.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.users.dto.FavoritDTO;
import com.example.users.entities.Favorit;


public interface Favoritrepository extends JpaRepository<Favorit, Long> {
	
	 @Query("select f from Favorit f where f.user.username = :username and f.job.jobid = :id" )	 
	 
	 FavoritDTO finduserjob(@Param("username") String username,@Param("id") Long id);
	 @Query("select f from Favorit f " )
	List<FavoritDTO> findAlldto();
	List<FavoritDTO> findByUserUsername(String username);

}
