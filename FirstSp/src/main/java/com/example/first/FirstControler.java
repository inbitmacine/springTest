package com.example.first;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class FirstControler {
	@Autowired
	protected ResourceLoader resourceLoader;
	@RequestMapping("/index")
	public String index(Model model) {
		
		return "index";
	}

	@PostMapping("resultCtrl")
	String postResult(@RequestParam("val") String Val, Model model) {
		List<String> ssu = YoroSplit.ySplit(Val);
		model.addAttribute("responseVal",ssu);
		return "result";
	}
}
