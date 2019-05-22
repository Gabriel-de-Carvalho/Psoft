package com.example.demo;
import java.time.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(@RequestParam(name="name", required=false, defaultValue="world") String name, Model model) {
		LocalTime time = LocalTime.now();
		int tempo = time.getHour();
		String msg = "";
		if(tempo >= 12) {
			msg = "boa tarde";
		} else {
			msg = "bom dia";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("name", name);
		return "hello";
	}
	
	@GetMapping("time")
	public String time(Model model) {
		String tempo = LocalTime.now().toString();
		model.addAttribute("tempo", tempo);
		return "time";
	}
}
