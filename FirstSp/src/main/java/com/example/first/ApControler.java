package com.example.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.UserService;

@Controller
public class ApControler {
	@Autowired
	UserService userService;

	@RequestMapping("/apGate")
	String apGate(Model model) {
	   	List<User> user = userService.findAll();
	   	model.addAttribute("users", user);
	   	return "gate";
	}
}
