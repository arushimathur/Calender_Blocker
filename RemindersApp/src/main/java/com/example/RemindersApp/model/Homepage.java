package com.example.RemindersApp.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

//import com.example.CalendarBlocker.model.Homepage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="homepage")
@NamedQuery(name = "Homepage.findBytoday",
query = "SELECT h FROM Homepage h WHERE h.taskstartdate = ?1")
@NamedQuery(name = "Homepage.findByName",
query = "SELECT h FROM Homepage h WHERE h.name = ?1")
public class Homepage {

	@Id
    @GeneratedValue(strategy = IDENTITY)
	private Long taskid;
	
	private String name;
	
	private LocalTime start;
	
	private LocalTime end;
	
	private LocalDate taskstartdate;
	
	private String freq;
	
}
