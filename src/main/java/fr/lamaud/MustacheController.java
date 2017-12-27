package fr.lamaud;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mustache")
public class MustacheController {

	@Value("${welcome.message}")
	private String MESSAGE = "";
	
	@Value("${welcome.title}")
	private String TITLE = "";
	
	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("title", TITLE);
		model.put("message", MESSAGE);
		return "mustache";
	}
	
	@RequestMapping("/5xx")
	public String ServiceUnavailable() {
		throw new RuntimeException("ABC");
	}
}
