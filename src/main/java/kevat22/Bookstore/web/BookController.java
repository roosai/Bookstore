package kevat22.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	@GetMapping("/index")
	public String showIndex() {
		return "This is the index page";
	}

}
