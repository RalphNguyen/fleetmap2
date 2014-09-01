package motorolasolutions.com.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import motorolasolutions.com.DataObject.Radio;
import motorolasolutions.com.DataObject.SecurityGroupForm;
import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.UCMConfigurationForm;
import motorolasolutions.com.DataObject.UCMUpdate;
import motorolasolutions.com.DataObject.UCMUpdateSearchInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("UCMUpdate")
public class UCMUpdateController {

	@Autowired
	@Qualifier("UCMUpdateValidator")
	private Validator validator;

	@InitBinder("UCMUpdate")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	// get UCM update page
	@RequestMapping("/UCMUpdate")
	public String getUcmUpdate(Model model) {
		/*
		 * UCMConfiguration ucm_conf = new UCMConfiguration();
		 * model.addAttribute("UCMUpdate", ucm_conf);
		 */

		UCMUpdateSearchInput ucmUpdateSearchInput = new UCMUpdateSearchInput();
		model.addAttribute("ucmUpdateSearchInput", ucmUpdateSearchInput);

		UCMUpdate ucmUpdate = new UCMUpdate();
		model.addAttribute("UCMUpdate", ucmUpdate);

		model.addAttribute("search_not_found",
				"Input any one of following fields to search for UCM");
		return "UCMUpdate";
	}

	@RequestMapping(value = "/UCMUpdate", method = RequestMethod.POST)
	public String searchUCM(@ModelAttribute("UCMUpdate") UCMUpdate ucmUpdate,
			Model model) {

		// get a lit of UCM fron UCM search input
		UCMConfigurationForm ucmConfigurations = new UCMConfigurationForm();
		ucmConfigurations.getListUCMConfigurationForm(ucmUpdate
				.getUcmUpdateSearchInput());

		if (ucmConfigurations.getUcmConfigurations().isEmpty()) {
			// System.out.println("No corresponding UCMs in the Database, please check your input");
			model.addAttribute("search_not_found",
					"Could not find any UCM, please check your input");
			return "UCMUpdate";
		} else {

			/*
			for (UCMConfiguration ucm_conf : ucmConfigurations
					.getUcmConfigurations()) {
				System.out.println("Search result: " + ucm_conf);
			}

			*/
			ucmUpdate.setUcmConfigurationForm(ucmConfigurations);

			// create security group options
			SecurityGroupForm securityGroupForm = new SecurityGroupForm();
			securityGroupForm.getListSecurityGroupForm();
			model.addAttribute("securityGroupForm", securityGroupForm);

			model.addAttribute("message", "There are "
					+ ucmConfigurations.getUcmConfigurations().size()
					+ " UCM can be updated");
			model.addAttribute("search_not_found",
					"Input any one of following fields to search for UCM");
			// model.addAttribute("UCMUpdate",ucmUpdate);
			return "UCMUpdateSearchResult";
		}
	}

	// get the list of marked to update UCMs, then updated them based on the
	// user's inputs
	@RequestMapping(value = "/submitUpdatedUCM", method = RequestMethod.POST, params = { "approve" })
	public String submitUCMApprove(
			@ModelAttribute("UCMUpdate") @Validated UCMUpdate ucmUpdate,
			BindingResult bindingResult, Model model) {
		// check validate input, in particular: user alias + serial number

		if (bindingResult.hasErrors()) {
			// create security group options
			SecurityGroupForm securityGroupForm = new SecurityGroupForm();
			securityGroupForm.getListSecurityGroupForm();
			model.addAttribute("securityGroupForm", securityGroupForm);

			model.addAttribute("message", "There are "
					+ ucmUpdate.getUcmConfigurationForm()
							.getUcmConfigurations().size()
					+ " UCM can be updated");
			model.addAttribute("search_not_found",
					"Input any one of following fields to search for UCM");
			return "UCMUpdateSearchResult";

		} else {
			// create a list of to be updated ucm_configuration
			List<UCMConfiguration> ucmConfigurations = new ArrayList<UCMConfiguration>();

			for (UCMConfiguration ucm_conf : ucmUpdate
					.getUcmConfigurationForm().getUcmConfigurations()) {
				if (ucm_conf.isUpdated()) {
					ucmConfigurations.add(ucm_conf);

					// release Radio ID when deregitered
					Radio radio = new Radio(ucm_conf.getRadio_id());
					if (ucm_conf.getActivation_status().equals("Deregistered")) {
						radio.removeFromDatabase();
					}
					// else marked as used
					else {
						// radio.updateToDatabase();
					}
					// update modified_date
					SimpleDateFormat sdfDate = new SimpleDateFormat(
							"yyyy/MM/dd HH:mm:ss");// dd/MM/yyyy
					Date now = new Date();
					ucm_conf.setDate_modified(sdfDate.format(now));

					// update UCM to database
					// update to UCM_configuration table
					ucm_conf.updateToDatabase();
				}
			}

			// if there is something was updated
			if (!ucmConfigurations.isEmpty()) {
				ucmUpdate.getUcmConfigurationForm().setUcmConfigurations(
						ucmConfigurations);
				model.addAttribute("message", ucmConfigurations.size()
						+ " UCMs were updated");
			}
			// if nothing was updated
			else {
				model.addAttribute("message", "Nothing was updated");
			}

			// create security group options
			SecurityGroupForm securityGroupForm = new SecurityGroupForm();
			securityGroupForm.getListSecurityGroupForm();
			model.addAttribute("securityGroupForm", securityGroupForm);

			return "UCMUpdateResult";
		}

	}

	// the user wants to back to the main menu
	@RequestMapping(value = "/submitUpdatedUCM", method = RequestMethod.POST, params = { "deny" })
	public String submitUCMDeny(Model model) {
		return getUcmUpdate(model);
	}

	/*
	 * @RequestMapping(value = "/UCMUpdate", method = RequestMethod.POST) public
	 * String searchUCM(
	 * 
	 * @ModelAttribute("UCMUpdate") UCMConfiguration ucm_conf, Model model) {
	 * 
	 * //get a lit of UCM fron UCM search input ucm_conf = getUCMData(ucm_conf);
	 * if (ucm_conf.getUcm_id() == 0) { System.out
	 * .println("No corresponding UCM in the Database, please check your input"
	 * ); model.addAttribute("search_not_found",
	 * "Could not find any UCM, please check your input"); return "UCMUpdate"; }
	 * else { System.out.println("Search result: " + ucm_conf);
	 * SecurityGroupForm securityGroupForm = new SecurityGroupForm();
	 * securityGroupForm.getListSecurityGroupForm();
	 * model.addAttribute("securityGroupForm", securityGroupForm);
	 * model.addAttribute("search_not_found", "Input to update"); return
	 * "UCMUpdateSearchResult"; } }
	 * 
	 * 
	 * @RequestMapping(value = "/submitUpdatedUCM", method = RequestMethod.POST,
	 * params = { "approve" }) public String submitUCMApprove(
	 * 
	 * @ModelAttribute("UCMUpdate") UCMConfiguration ucm_conf, Model model) { //
	 * check validate input, in particular: user alias + serial number String
	 * check_alias_message; String check_serial_message; // check radio serial
	 * duplicate if (ucm_conf.checkRadioSerialDuplicate() == 0) {
	 * check_serial_message = "validated"; } else { check_serial_message =
	 * "duplicate"; } model.addAttribute("check_serial_message",
	 * check_serial_message); // check radio user alias duplicate if
	 * (ucm_conf.checkRadioUserAliasDuplicate() == 0) { check_alias_message =
	 * "validated"; } else { check_alias_message = "duplicate"; }
	 * model.addAttribute("check_alias_message", check_alias_message);
	 * 
	 * // if there is no duplicate in either radio serial or alias if
	 * (check_serial_message.equals("validated") &&
	 * check_alias_message.equals("validated")) { if
	 * (ucm_conf.getActivation_status().equals("Deregistered")) { Radio radio =
	 * new Radio(ucm_conf.getRadio_id()); radio.removeFromDatabase(); } //
	 * update modified_date SimpleDateFormat sdfDate = new SimpleDateFormat(
	 * "yyyy/MM/dd HH:mm:ss");// dd/MM/yyyy Date now = new Date();
	 * ucm_conf.setDate_modified(sdfDate.format(now)); // update to
	 * UCM_configuration table ucm_conf.updateToDatabase();
	 * model.addAttribute("search_not_found", "The UCM is updated"); return
	 * "UCMUpdateResult"; } else { model.addAttribute("search_not_found",
	 * "Duplicate radio serial or alias, please check your input"); return
	 * "UCMUpdateSearchResult"; } }
	 */

}
