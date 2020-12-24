package com.example.entity;


//import java.time.LocalDate;
//import java.time.LocalTime;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import lombok.Data;


@Entity
@Table(name = "meetbooking")
@Data

public class MeetBooking {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long meetId;

	private String name;

	private String room;

	private int day;

	private int start;

	private int end;

}