package motorolasolutions.com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("DashBoard")
public class DashBoardController {
	
	@RequestMapping("/home")
	public String homeGenerator(Model model) {
		return "homepage";
	}
}
