package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "loginuser")
@Data
public class LoginUser {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	@Id
	private Long userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "mail")
	private String mail;




}