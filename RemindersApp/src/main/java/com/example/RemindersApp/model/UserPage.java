package com.example.RemindersApp.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPage {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	private String username;
	private String email;
	private String password;
	
}
