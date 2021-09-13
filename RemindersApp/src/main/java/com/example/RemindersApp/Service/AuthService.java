package com.example.RemindersApp.Service;

import org.springframework.http.ResponseEntity;

import com.example.RemindersApp.DTO.LoginDTO;
import com.example.RemindersApp.DTO.LoginRequest;
import com.example.RemindersApp.Exception.ReminderException;

public interface AuthService {

	public void signup(LoginDTO loginDTO) throws ReminderException;

	public boolean login(LoginRequest loginRequest) throws ReminderException;
	
}
