package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.ProtoUser;
import com.example.repository.UserRepository;

@Service
@Transactional(rollbackFor=Exception.class)
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<ProtoUser> findAll() {
		return userRepository.findAll();
	}
}
