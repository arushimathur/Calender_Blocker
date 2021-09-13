package com.example.RemindersApp;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.RemindersApp.DTO.HomeDTO;
import com.example.RemindersApp.Service.HomeService;

@SpringBootApplication
public class RemindersAppApplication implements CommandLineRunner {
	@Autowired
	private HomeService homeservice;

	public static void main(String[] args) {
		SpringApplication.run(RemindersAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*LocalTime newTimeObj = LocalTime.of(12, 45, 59); 
		LocalTime newTimeObj2 = LocalTime.of(18, 45, 59); 

		HomeDTO hdto=new HomeDTO();
		hdto.setName("Exam");
		hdto.setStart(newTimeObj);
		hdto.setEnd(newTimeObj2);
		hdto.setTaskstartdate(LocalDate.of(2021, 9, 20));
		hdto.setFreq("daily");
		homeservice.addtask(hdto);
		*/
	}

}
