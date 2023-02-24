package com.example.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.users.dto.PostulerDTO;
import com.example.users.entities.Postuler;

public interface PostulerRepository extends JpaRepository<Postuler, Long> {

	List<Postuler> findByJobJobid(Long id);

	 @Modifying
	    @Query("UPDATE Postuler p SET p.etat = 0 WHERE p.postulerid IN (:ids)")
	    void updateByIds(@Param("ids") List<Long> ids);

	List<PostulerDTO> findByUserUsername(String username);

}
