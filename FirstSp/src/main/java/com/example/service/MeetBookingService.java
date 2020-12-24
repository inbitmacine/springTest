package com.example.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.MeetBooking;
import com.example.repository.LoginUserRepository;
import com.example.repository.MeetBookingRepository;

@Service
public class MeetBookingService {
	@Autowired
	LoginUserRepository userRepository;
	@Autowired
	MeetBookingRepository meetRepository;

	@Transactional
	public void insertUser(Long meetId,String name,String room,
			  				  LocalDate day,LocalTime start,LocalTime end)
	{
		MeetBooking meet = new MeetBooking();
		meet.setMeetId(meetId);
		meet.setName(name);
		meet.setRoom(room);
		meet.setDay(day);
		meet.setStart(start);
		meet.setEnd(end);

		meetRepository.save(meet);
	}
}
