package motorolasolutions.com.Controller;

import motorolasolutions.com.DataObject.CoreAccessPointForm;
import motorolasolutions.com.DataObject.Entity;
import motorolasolutions.com.DataObject.EntityForm;
import motorolasolutions.com.DataObject.Radio;
import motorolasolutions.com.DataObject.Remedy;
import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.Zone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("UCMConfiguration")
public class UCMGeneratorController {

	@RequestMapping(value = "/generateUCM", method = RequestMethod.POST)
	public String generateUCM(
			@ModelAttribute("UCMConfiguration") UCMConfiguration ucm_conf,
			Model model) {
		String check_alias_message;
		String check_serial_message;
		// check radio serial duplicate
		ucm_conf.setSerialNoAndDate();
		
		if (ucm_conf.checkRadioSerialDuplicate() == 0) {
			check_serial_message = "validated";
		} else {
			check_serial_message = "duplicate";
		}
		model.addAttribute("check_serial_message", check_serial_message);
		// check radio user alias duplicate
		if (ucm_conf.checkRadioUserAliasDuplicate() == 0) {
			check_alias_message = "validated";
		} else {
			check_alias_message = "duplicate";
		}
		model.addAttribute("check_alias_message", check_alias_message);

		// if there is no duplicate with radio alias & serial number, allocate radio ID and return result
		if (check_serial_message.equals("validated")
				&& check_alias_message.equals("validated")) {
			System.out.println("no radio serial & alias duplicate");
			System.out.println("input: " + ucm_conf);

			// create entity from user input
			Entity entity = new Entity(ucm_conf.getEntity_name());
			System.out.println("entity: " + entity);
			ucm_conf.setEntity_id(entity.getEntity_id());
			// create zone from user input
			Zone zone = new Zone(ucm_conf.getZone_id());

			// insert remedy
			Remedy remedy = new Remedy(ucm_conf.getRemedy_id(),
					ucm_conf.getRequest_no(), ucm_conf.getSub_entity());
			insertRemedy(remedy);

			// insert UCM
			ucm_conf = getInsertUCMConfiguration(ucm_conf, entity, zone);
			System.out.println("-----\nUCM generator end.");

			model.addAttribute("UCMConfiguration", ucm_conf);
			return "UCMGeneratorResult";
		} 
		// if there is duplicate in radio serial number or alias, return it
		else {
			System.out.println("radio serial & alias duplicate");
			if(ucm_conf.getRadio_modulation_type_id()==3){
				ucm_conf.setRadio_serial_number(ucm_conf.getRadio_serial_number().substring(1, ucm_conf.getRadio_serial_number().length()));
			}
			return "UCMGenerator";
		}		
	}

	@RequestMapping("/UCMGenerator")
	public String ucmConfiguration(Model model) {
		EntityForm entityForm = new EntityForm();
		entityForm.getListEntityForm();
		CoreAccessPointForm coreAccessPointForm = new CoreAccessPointForm();
		coreAccessPointForm.getListCoreAccessPointForm();
		
		UCMConfiguration ucm_conf = new UCMConfiguration();
		ucm_conf.setEntityForm(entityForm);
		ucm_conf.setCoreAccessPointForm(coreAccessPointForm);

		model.addAttribute("UCMConfiguration", ucm_conf);
		return "UCMGenerator";
	}

	@RequestMapping(value = "/saveUCM", method = RequestMethod.POST)
	public String saveUCM(
			@ModelAttribute("UCMConfiguration") UCMConfiguration ucm_conf,
			Model model) {
		// insert to UCM_configuration table
		ucm_conf.setUcm_id(ucm_conf.insertToDatabase());
		System.out.println("test2 " + ucm_conf);
		// create then insert remedy_export
		ucm_conf.insertRemedyExport();
		// model.addAttribute("UCMConfiguration",ucm_conf);
		return "UCMGeneratorSubmit";
	}

	// check & insert new Remedy
	private void insertRemedy(Remedy remedy) {
		System.out.println("Remedy: " + remedy);
		System.out.println("check duplicate remedy...");
		if (remedy.checkRemedyDuplicate() == 1) {
			System.out
					.println("remedy already exists, no need to insert to our Database");
		} else {
			System.out.println("insert new Remedy with ID = "
					+ remedy.getRemedy_id() + " to our Database:" + remedy);
			remedy.insertToDatabase();
		}
	}

	// check & insert new UCM
	private UCMConfiguration getInsertUCMConfiguration(
			UCMConfiguration ucm_conf, Entity entity, Zone zone) {
		System.out.println(ucm_conf);
		// remedy.insertToDatabase();
		System.out.println("check duplicate radio serial number");

		// get an available Radio ID from the database
		// then create a Radio
		int temp_radio_id = ucm_conf.checkRadioIDAvailability();
		if (temp_radio_id == 0) {
			System.out
					.println("There is no available Radio ID, please check the database");
		} else {
			Radio radio = new Radio(temp_radio_id, "Yes",
					ucm_conf.getRadio_modulation_type_id(),
					ucm_conf.getZone_id());
			System.out.println(radio);
			// update used_flag of the radio to the database
			radio.updateToDatabase();
			// get softID
			ucm_conf.setRadio_id(radio.getRadio_id());
			ucm_conf.setSecurity_group_id(entity.getSecurity_group_id());
			ucm_conf.generateFields();
			System.out.println(ucm_conf);
		}
		return ucm_conf;
	}

}