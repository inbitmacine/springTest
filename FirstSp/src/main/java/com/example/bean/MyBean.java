package com.example.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class MyBean implements Serializable {
	private int myNumber;
	private int myString;
	private Long meetId;
	private String name;
	private String room;
	private LocalDate day;
	private LocalTime start;
	private LocalTime end;

}