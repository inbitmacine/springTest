package com.example.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.ProtoUser;
import com.example.service.UserService;

@Controller
public class ApControler {
	@Autowired
	UserService userService;

	@GetMapping("/apGate")
	String apGate(Model model) {
	   	List<ProtoUser> user = userService.findAll();
	   	model.addAttribute("users", user);
	   	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	   	String Name = auth.getName();
	   	model.addAttribute("Name", Name);
	   	return "gate";
	}
}
