package com.example.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@ComponentScan("com.example.*")
@Controller
public class ApControler {
	@Autowired
	CustomerService customerService;

	@RequestMapping("/apGate")
	String apGate(Model model) {
	   	List<Customer> customers = customerService.findAll();
	   	model.addAttribute("users", customers);
	   	return "gate";
	}
}
