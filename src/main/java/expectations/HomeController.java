package expectations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping(value = "/expect")
public class HomeController {

	@GetMapping()
	public String goHome() {
		System.out.println("Hello HomePage!");
		return "homepage";
	}
}
