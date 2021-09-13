package com.example.RemindersApp.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.RemindersApp.model.Homepage;


public interface HomeRepository extends JpaRepository<Homepage,Long> {

	//@Query("SELECT h FROM homepage h WHERE h.taskstartdate = :today")
	List<Homepage> findBytoday(@Param("today") LocalDate today);

	Homepage findByName(@Param("name") String name);
	
	
}
