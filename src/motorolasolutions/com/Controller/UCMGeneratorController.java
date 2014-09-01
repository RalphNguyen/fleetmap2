package motorolasolutions.com.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motorolasolutions.com.BusinessLogic.UCMExportLogic;
import motorolasolutions.com.BusinessLogic.UCMGeneratorLogic;
import motorolasolutions.com.DataObject.CoreAccessPointForm;
import motorolasolutions.com.DataObject.EntityForm;
import motorolasolutions.com.DataObject.Remedy;
import motorolasolutions.com.DataObject.RemedyExport;
import motorolasolutions.com.DataObject.UCMConfiguration;

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
@SessionAttributes("UCMConfiguration")
public class UCMGeneratorController {

	@Autowired
	@Qualifier("UCMInputValidator")
	private Validator validator;

	@InitBinder("UCMConfiguration")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	// call UCM generator
	@RequestMapping(value = "/UCMGenerator")
	public String getUCMGenerator(Model model) {
		// remove radio with "Temp" tag
		UCMGeneratorLogic.removeRadioTempTag();
		// create Entity list to choose for input
		EntityForm entityForm = new EntityForm();
		entityForm.getListEntityForm();
		model.addAttribute("entityForm", entityForm);

		// create UCM configuration object to get input
		UCMConfiguration ucm_conf = new UCMConfiguration();
		model.addAttribute("UCMConfiguration", ucm_conf);
		return "UCMGenerator";
	}

	@RequestMapping(value = "/UCMGenerator", method = RequestMethod.POST)
	public String generateUCM(
			@ModelAttribute("UCMConfiguration") @Validated UCMConfiguration ucm_conf,
			BindingResult bindingResult, Model model) {

		// check duplicate radio alias & serial number
		// if there is duplicate
		if (bindingResult.hasErrors()) {
			// create Entity list to choose for input
			EntityForm entityForm = new EntityForm();
			entityForm.getListEntityForm();
			model.addAttribute("entityForm", entityForm);
			return "UCMGenerator";
		}
		// if there is no duplicate
		else {
			// set ucm radio serial and date issued
			ucm_conf.setSerialNoAndDate();
			//System.out.println("input: " + ucm_conf);

			// insert remedy
			Remedy remedy = new Remedy(ucm_conf.getRemedy_id(),
					ucm_conf.getRequest_no(), ucm_conf.getSub_entity());

			// insert remedy to DB
			UCMGeneratorLogic.insertRemedy(remedy);
			
			// get the insert information, including Radio ID, return 0 if there is no avaliable radio_id
			int flag= UCMGeneratorLogic.getInsertUCMConfiguration(ucm_conf);
			if(flag==0){
				model.addAttribute("message","No available radio ID-");
				return getUCMGenerator(model);
			}
			else{
				//System.out.println("pre insert: " + ucm_conf);

				// create core access point list to choose for input
				CoreAccessPointForm coreAccessPointForm = new CoreAccessPointForm();
				coreAccessPointForm.getListCoreAccessPointForm();
				model.addAttribute("coreAccessPointForm", coreAccessPointForm);
				model.addAttribute("UCMConfiguration", ucm_conf);

				// return UCM data
				return "UCMGeneratorResult";
			}
		}
	}

	// insert UCM to the database, and create remedy export
	@RequestMapping(value = "/UCMGeneratorSubmission", method = RequestMethod.POST, params = { "save" })
	public String saveUCM(
			@ModelAttribute("UCMConfiguration") UCMConfiguration ucm_conf,
			Model model) {
		//System.out.println("insert: " + ucm_conf);
		// insert to UCM_configuration table
		int ucm_id = ucm_conf.insertToDatabase();
		ucm_conf.setUcm_id(ucm_id);
		//System.out.println("after insert " + ucm_conf);
		// create then insert remedy_export
		ucm_conf.insertRemedyExport();
		// change used_tag of radio from Temp to "Yes"
		UCMGeneratorLogic.updateRadioUsedTag(ucm_conf);
		model.addAttribute("message",
				"One UCM record was added to the database");
		model.addAttribute("UCMConfiguration", ucm_conf);
		return "UCMGeneratorExport";
	}

	// insert UCM to the database, and create remedy export
	@RequestMapping(value = "/UCMGeneratorSubmission", method = RequestMethod.POST, params = { "back" })
	public String backUCM(
			@ModelAttribute("UCMConfiguration") UCMConfiguration ucm_conf,
			Model model) {
		return getUCMGenerator(model);
	}

	// export UCM
	@RequestMapping(value = "/UCMGeneratorExport", method = RequestMethod.POST, params = { "ucm" })
	public void exportUCM(
			@ModelAttribute("UCMConfiguration") UCMConfiguration ucm_conf,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		File downloadFile = UCMExportLogic.ucmListFileWriter("ucm", ucm_conf);
		UCMExportLogic.generateResponseFile(request, response, downloadFile);
	}

	// export remedy
	@RequestMapping(value = "/UCMGeneratorExport", method = RequestMethod.POST, params = { "remedy" })
	public void exportRemedy(
			@ModelAttribute("UCMConfiguration") UCMConfiguration ucm_conf,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		RemedyExport remedyExport = new RemedyExport(ucm_conf.getRadio_id(),
				ucm_conf.getRadio_type(), ucm_conf.getUcm_id());
		File downloadFile = UCMExportLogic.ucmListFileWriter("remedy",
				remedyExport);
		UCMExportLogic.generateResponseFile(request, response, downloadFile);
	}

	// back to UCM generator
	@RequestMapping(value = "/UCMGeneratorExport", method = RequestMethod.POST, params = { "back" })
	public String backToUCMGenerator(
			@ModelAttribute("UCMConfiguration") UCMConfiguration ucm_conf,
			Model model) {
		return getUCMGenerator(model);
	}
}