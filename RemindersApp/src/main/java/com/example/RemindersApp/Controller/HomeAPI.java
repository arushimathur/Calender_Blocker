package com.example.RemindersApp.Controller;

import java.util.List;

//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RemindersApp.DTO.HomeDTO;
import com.example.RemindersApp.DTO.LoginDTO;
import com.example.RemindersApp.DTO.LoginRequest;
import com.example.RemindersApp.Exception.ReminderException;
import com.example.RemindersApp.Service.AuthService;
import com.example.RemindersApp.Service.HomeService;
import com.example.RemindersApp.model.Homepage;

@RestController
@RequestMapping(value="/api")
public class HomeAPI {

	@Autowired
	private HomeService homeService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private AuthService authService;
	
	@PostMapping(value="/add")
	public ResponseEntity<String> addtask(@RequestBody HomeDTO homedata) throws ReminderException
	{
		homeService.addtask(homedata);
		String successMessage ="API.INSERT_SUCCESS";
		return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
		
	}
	
	@PostMapping(value="/signup")
	public ResponseEntity<String> signup(@RequestBody LoginDTO loginDTO) throws ReminderException
	{
		authService.signup(loginDTO);
        return new ResponseEntity<>("User Registration Successful",HttpStatus.OK);
		
	}
	
	 @PostMapping(value="/login")
	    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) throws ReminderException {
	        if(authService.login(loginRequest))
	        	return new ResponseEntity<>("User Login Successful",HttpStatus.OK);
			return new ResponseEntity<>("Invalid User",HttpStatus.BAD_REQUEST);
	    }
 
	@GetMapping(value="/Homepage")
	public ResponseEntity<List<Homepage>> getalldata() throws ReminderException
	{
		List<Homepage> hdto=homeService.getAllData();
		return new ResponseEntity<>(hdto,HttpStatus.OK);
		
	}
	 
	@GetMapping(value="/Homepage/today")
	public ResponseEntity<List<Homepage>> gettodaydata() throws ReminderException
	{		
		List<Homepage> hdto=homeService.gettodaydata();
		if(hdto.isEmpty()==false)
		return new ResponseEntity<>(hdto,HttpStatus.OK);
		
		return new ResponseEntity<>(hdto,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<String> updatetask(@RequestBody HomeDTO homedata) throws ReminderException
	{
		homeService.updateTask(homedata);
		String successMessage =environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping(value="/delete/{taskId}")
	public ResponseEntity<String> deletetask(@PathVariable Long taskId) throws ReminderException
	{
		homeService.deleteTask(taskId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
	
}
