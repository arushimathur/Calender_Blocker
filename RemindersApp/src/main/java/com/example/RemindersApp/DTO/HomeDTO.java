package com.example.RemindersApp.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

import com.example.RemindersApp.model.Homepage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@AllArgsConstructor
@NoArgsConstructor
public class HomeDTO {

	private String name;
	private LocalTime start;
	private LocalTime end;
	private LocalDate taskstartdate;
	private String freq;

}
