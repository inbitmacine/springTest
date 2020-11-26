package com.example.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.service.UserService;

@ComponentScan("com.example.*")
@Controller
public class ApControler {
	@Autowired
	UserService userService;

	@RequestMapping("/apGate")
	String apGate(Model model) {
	   	List<User> users = userService.findAll();
	   	model.addAttribute("users", users);
	   	return "gate";
	}
}
