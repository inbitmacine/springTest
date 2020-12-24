package com.example.first;

/*
 * 最初に作ったコントローラです
 * メイン機能以外はこちらに実装していく予定
 */
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myutill.MyUtill;
@Controller
public class FirstControler {

	@RequestMapping("/index")
	public String index(Model model) {

		return "index";
	}

	@PostMapping("resultCtrl")
	String postResult(@RequestParam("val") String Val, Model model) {
		List<String> ssu = MyUtill.ySplit(Val);
		model.addAttribute("responseVal",ssu);
		return "result";
	}
}
