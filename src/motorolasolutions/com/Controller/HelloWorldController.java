package motorolasolutions.com.Controller;

import java.util.ArrayList;
import java.util.List;

import motorolasolutions.com.DataObject.Entity;
import motorolasolutions.com.DataObject.EntityForm;
import motorolasolutions.com.DataObject.ZoneForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"testForm1","testForm2"})
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {

		String message = "Hello World, Spring 3.0!";
		return new ModelAndView("hello", "message", message);
	}

	private static List<Entity> entities = new ArrayList<Entity>();

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Model model) {
		EntityForm entityForm = new EntityForm();
		entityForm.getListEntityForm();
		// EntityForm.setEntities(entities);
		//return new ModelAndView("addEntity2", "EntityForm", EntityForm);
		ZoneForm zoneForm = new ZoneForm();
		zoneForm.getListEntityForm();
		model.addAttribute("testForm1",zoneForm);
		model.addAttribute("testForm2",entityForm);
		//model.addAttribute("testForm",zoneForm);
		return "addEntity3";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(
			@ModelAttribute("contactForm") EntityForm EntityForm) {
		System.out.println(EntityForm);
		System.out.println(EntityForm.getEntities());
		List<Entity> entities = EntityForm.getEntities();

		if (null != entities && entities.size() > 0) {
			this.entities = entities;
			for (Entity entity : entities) {
				System.out.printf("\n", entity.getEntity_name());
			}
		}

		return new ModelAndView("showEntity", "EntityForm", EntityForm);
	}
}
