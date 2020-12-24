package com.example.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.ProtoUser;
import com.example.myutill.MyUtill;
import com.example.service.UserDetailsServiceImpl;
import com.example.service.UserService;

@Controller
public class ApControler {
	@Autowired
	UserService userService;

	@Autowired
	UserDetailsServiceImpl loginUserService;

	@GetMapping("/apGate")
	String apGate(Model model) {
	   	List<ProtoUser> user = userService.findAll();
	   	model.addAttribute("users", user);
	   	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	   	String Name = auth.getName();
	   	model.addAttribute("Name", Name);
	   	return "gate";
	}

	@GetMapping("/create")
	String create() {
		return "create";
	}


	@PostMapping("join")
	String join(RedirectAttributes redirectAttributes,@RequestParam("username")String name,@RequestParam("password") String pass,@RequestParam("mail") String mail,Model model) {
		if(mail != "" && MyUtill.isMailAddress(mail)==false) {
			model.addAttribute("error", true);
			return "/create";
		}

		loginUserService.insertUser(name,pass,mail);
		return "success";
	}

}
