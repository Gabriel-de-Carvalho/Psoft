package controllers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(@RequestParam(name="name", required=false,defaultValue="world") String nome, Model model) {
		model.addAttribute("name", nome);
		return "hello";
	}
}
