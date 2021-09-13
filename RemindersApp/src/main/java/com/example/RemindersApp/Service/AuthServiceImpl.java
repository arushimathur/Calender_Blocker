package com.example.RemindersApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RemindersApp.DTO.LoginDTO;
import com.example.RemindersApp.DTO.LoginRequest;
import com.example.RemindersApp.Exception.ReminderException;
import com.example.RemindersApp.Repository.UserRepository;
import com.example.RemindersApp.model.UserPage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void signup(LoginDTO loginDTO) throws ReminderException {
		// TODO -generated method stub
		UserPage usp=new UserPage();
		usp.setUsername(loginDTO.getUsername());
		usp.setEmail(loginDTO.getEmail());
		usp.setPassword(loginDTO.getPassword());
		userRepo.save(usp);
		
	}

	@Override
	public boolean login(LoginRequest loginRequest) throws ReminderException {
		// TODO Auto-generated method stub
		List<UserPage> lst=new ArrayList<>();
		lst=getAllUsers();
		for(UserPage x:lst)
		{
			if(loginRequest.getEmail().equals(x.getEmail()) && loginRequest.getPassword().equals(x.getPassword()))
				return true;
		}
		return false;
	}

	private List<UserPage> getAllUsers() throws ReminderException {
		List<UserPage> usp=new ArrayList<>();
		usp=userRepo.findAll();
		
		if(usp.isEmpty())
		throw new ReminderException("Service.USERS_NOT_FOUND");
		
		return usp;
	}

}
