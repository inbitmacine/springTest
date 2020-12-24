package com.example.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
/*
 * 会議室の情報を保存するクラスです。
 * タイムリーフ君がこれを使っていい感じにデータを表示する(予定)
 */
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