package fr.lamaud;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/welcome")
public class HelloController {

	   // inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Hello World";

		@RequestMapping("/welcome")
		public String welcome(Map<String, Object> model) {
			model.put("message", this.message);
			return "welcome";
		}
	
}
