package com.example.RemindersApp.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.RemindersApp.DTO.HomeDTO;
import com.example.RemindersApp.Exception.ReminderException;
import com.example.RemindersApp.Repository.HomeRepository;
import com.example.RemindersApp.model.Homepage;

@Service(value="homeService")
@Transactional
public class HomeServiceImpl implements HomeService {

	@Autowired
	public HomeRepository homeRepo;
	
	@Override
	public void addtask(@RequestBody HomeDTO homedata) throws ReminderException {
		// TODO Auto-generated method stub
		Homepage ht=new Homepage();
		ht.setName(homedata.getName());
		ht.setStart(homedata.getStart());
		ht.setEnd(homedata.getEnd());
		ht.setTaskstartdate(homedata.getTaskstartdate());
		ht.setFreq(homedata.getFreq());
		homeRepo.save(ht);
		
	}

	@Override
	public List<Homepage> getAllData() throws ReminderException {
		// TODO Auto-generated method stub
		List<Homepage> hdto=new ArrayList<>();
		hdto=homeRepo.findAll();
		if(hdto.isEmpty())
			throw new ReminderException("Service.TASKS_NOT_FOUND");
		return hdto;
	}

	@Override
	public List<Homepage> gettodaydata() throws ReminderException {
		// TODO Auto-generated method stub
		List<Homepage> hdto1=new ArrayList<>();
		LocalDate today=LocalDate.now();
		hdto1=homeRepo.findBytoday(today);
		if(hdto1.isEmpty())
			throw new ReminderException("Service.TASK_TODAY_NOT_FOUND");
		return hdto1;
	}

	@Override
	public void updateTask(HomeDTO homedata) throws ReminderException {
		// TODO Auto-generated method stub
		Optional<Homepage> hpto=Optional.of(homeRepo.findByName(homedata.getName()));
	Homepage hpto1=hpto.orElseThrow(()->new ReminderException("Service.TASK_NOT_FOUND"));
	Homepage ht=new Homepage();
	ht.setTaskid(hpto1.getTaskid());
	ht.setName(hpto1.getName());
	ht.setStart(hpto1.getStart());
	ht.setEnd(hpto1.getEnd());
	ht.setTaskstartdate(hpto1.getTaskstartdate());
	ht.setFreq(hpto1.getFreq());
	
	}

	@Override
	public void deleteTask(Long taskId) throws ReminderException {
		// TODO Auto-generated method stub
		Optional<Homepage> hp=homeRepo.findById(taskId);
		hp.orElseThrow(()->new ReminderException("Service.TASK_NOT_FOUND"));
		homeRepo.deleteById(taskId);
	}

}
