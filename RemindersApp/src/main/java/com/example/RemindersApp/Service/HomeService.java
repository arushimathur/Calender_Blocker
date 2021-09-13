package com.example.RemindersApp.Service;

import java.util.List;

import com.example.RemindersApp.DTO.HomeDTO;
import com.example.RemindersApp.Exception.ReminderException;
import com.example.RemindersApp.model.Homepage;

public interface HomeService {

	public void addtask(HomeDTO homedata) throws ReminderException ;

	public List<Homepage> getAllData() throws ReminderException;

	public List<Homepage> gettodaydata() throws ReminderException;

	public void updateTask(HomeDTO homedata) throws ReminderException;

	public void deleteTask(Long taskId) throws ReminderException;

	
}
