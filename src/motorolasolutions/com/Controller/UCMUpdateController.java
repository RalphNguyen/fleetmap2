package motorolasolutions.com.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import motorolasolutions.com.DataObject.Radio;
import motorolasolutions.com.DataObject.SecurityGroupForm;
import motorolasolutions.com.DataObject.UCMConfiguration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("UCMUpdate")
public class UCMUpdateController {

	@RequestMapping("/UCMUpdate")
	public String ucmUpdate(Model model) {
		UCMConfiguration ucm_conf = new UCMConfiguration();
		model.addAttribute("UCMUpdate", ucm_conf);
		model.addAttribute("search_not_found",
				"Input any one of following fields to search for UCM");
		return "UCMUpdate";
	}

	@RequestMapping(value = "/searchUCM", method = RequestMethod.POST)
	public String searchUCM(
			@ModelAttribute("UCMUpdate") UCMConfiguration ucm_conf, Model model) {
		ucm_conf = getUCMData(ucm_conf);
		if (ucm_conf.getUcm_id() == 0) {
			System.out
					.println("No corresponding UCM in the Database, please check your input");
			model.addAttribute("search_not_found",
					"Could not find any UCM, please check your input");
			return "UCMUpdate";
		} else {
			System.out.println("Search result: " + ucm_conf);
			SecurityGroupForm securityGroupForm = new SecurityGroupForm();
			securityGroupForm.getListSecurityGroupForm();
			model.addAttribute("search_not_found", "Input to update");
			return "UCMSearchResult";
		}
	}

	@RequestMapping(value = "/submitUpdatedUCM", method = RequestMethod.POST, params = { "approve" })
	public String submitUCMApprove(
			@ModelAttribute("UCMUpdate") UCMConfiguration ucm_conf, Model model) {
		// check validate input, in particular: user alias + serial number
		String check_alias_message;
		String check_serial_message;
		// check radio serial duplicate
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

		// if there is no duplicate in either radio serial or alias
		if (check_serial_message.equals("validated")
				&& check_alias_message.equals("validated")) {
			if (ucm_conf.getActivation_status().equals("Deregistered")) {
				Radio radio = new Radio(ucm_conf.getRadio_id());
				radio.removeFromDatabase();
			}
			// update modified_date
			SimpleDateFormat sdfDate = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm:ss");// dd/MM/yyyy
			Date now = new Date();
			ucm_conf.setDate_modified(sdfDate.format(now));
			// update to UCM_configuration table
			ucm_conf.updateToDatabase();
			model.addAttribute("search_not_found", "The UCM is updated");
			return "UCMUpdateResult";
		} else {
			model.addAttribute("search_not_found",
					"Duplicate radio serial or alias, please check your input");
			return "UCMSearchResult";
		}
	}

	@RequestMapping(value = "/submitUpdatedUCM", method = RequestMethod.POST, params = { "deny" })
	public String submitUCMDeny(Model model) {	
		return ucmUpdate(model);
	}

	private UCMConfiguration getUCMData(UCMConfiguration ucm_conf) {
		System.out.println("Search/Get UCM data");
		UCMConfiguration ucm_conf_searchResult = (UCMConfiguration) ucm_conf
				.searchForUpdate();
		return ucm_conf_searchResult;
	}

}
