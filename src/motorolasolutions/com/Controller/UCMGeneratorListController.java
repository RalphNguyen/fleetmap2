package motorolasolutions.com.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motorolasolutions.com.BusinessLogic.UCMExportLogic;
import motorolasolutions.com.BusinessLogic.UCMGeneratorLogic;
import motorolasolutions.com.DataObject.CoreAccessPointForm;
import motorolasolutions.com.DataObject.EntityForm;
import motorolasolutions.com.DataObject.Remedy;
import motorolasolutions.com.DataObject.RemedyExport;
import motorolasolutions.com.DataObject.RemedyExportForm;
import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.UCMConfigurationForm;
import motorolasolutions.com.DataObject.UCMGeneratorInput;
import motorolasolutions.com.DataObject.UCMGeneratorInputForm;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

@Controller
@SessionAttributes("UCMConfigurationForm")
public class UCMGeneratorListController {

	@Autowired
	@Qualifier("UCMListInputValidator")
	private Validator validator;

	@InitBinder("UCMConfigurationForm")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	// generate view to upload file
	@RequestMapping(value = "/UCMGeneratorList", method = RequestMethod.GET)
	public String getUCMUploadPage(Model model) {
		// remove radio with "Temp" tag
		UCMGeneratorLogic.removeRadioTempTag();
		return "UCMGeneratorListHome";
	}

	// to read a CVS file containing inputs for a list of UCM, return errors if
	// the file is not well formatted
	@RequestMapping(value = "/UCMGeneratorList", method = RequestMethod.POST)
	public String uploadUCMFileHandler(
			@RequestParam("file") MultipartFile file, Model model) {

		if (!file.isEmpty()) {
			try {
				UCMGeneratorInputForm ucmGeneratorInputForm = parseCSVtoBean(multipartToFile(file));

				// create a list of UCMConfiguration
				List<UCMConfiguration> ucmConfigurationList = new ArrayList<UCMConfiguration>();
				for (UCMGeneratorInput ucmGeneratorInput : ucmGeneratorInputForm
						.getUcmGeneratorInputs()) {
					UCMConfiguration ucm_conf = new UCMConfiguration();
					ucm_conf.setRemedy_id(ucmGeneratorInput.getRemedy_id());
					ucm_conf.setActivation_status(ucmGeneratorInput
							.getActivation_status());
					ucm_conf.setRadio_type(ucmGeneratorInput.getRadio_type());
					ucm_conf.setRadio_user_alias(ucmGeneratorInput
							.getRadio_user_alias());
					ucm_conf.setRadio_serial_number(ucmGeneratorInput
							.getRadio_serial_number());
					ucm_conf.setUcp(ucmGeneratorInput.getUcp());
					ucm_conf.setZone_id(ucmGeneratorInput.getZone_id());
					ucm_conf.setEntity_name(ucmGeneratorInput.getEntity_name());
					ucm_conf.setSub_entity(ucmGeneratorInput.getSub_entity());
					ucm_conf.setRequest_no(ucmGeneratorInput.getRequest_no());
					ucm_conf.setRadio_modulation_type_id(ucmGeneratorInput
							.getRadio_modulation_type_id());
					ucm_conf.setActivation_status(ucmGeneratorInput
							.getActivation_status());
					ucm_conf.setRadio_user_data_type(ucmGeneratorInput
							.getRadio_user_data_type());
					ucmConfigurationList.add(ucm_conf);
				}

				UCMConfigurationForm ucmConfigurationForm = new UCMConfigurationForm();
				ucmConfigurationForm.setUcmConfigurations(ucmConfigurationList);
				model.addAttribute("inputList", ucmGeneratorInputForm);
				EntityForm entityForm = new EntityForm();
				entityForm.getListEntityForm();
				model.addAttribute("entityList", entityForm);
				model.addAttribute("UCMConfigurationForm", ucmConfigurationForm);
				model.addAttribute("noOfUcm", ucmConfigurationForm
						.getUcmConfigurations().size());
				// return "You successfully uploaded file=" + name;
				// need to add exceptions here when the file is not well
				// formatted
				return "UCMGeneratorList";
			} catch (Exception e) {
				return "You failed to upload => " + e.getMessage();
			}
		} else {
			model.addAttribute("message",
					"You failed to upload because the file was empty.");
			return "UCMGeneratorListHome";
		}
	}

	@RequestMapping(value = "/generateUCMConfigurationList", method = RequestMethod.POST, params = { "approve" })
	public String generateUCMConfigurationList(
			@ModelAttribute("UCMConfigurationForm") @Validated UCMConfigurationForm ucmConfigurationForm,
			BindingResult bindingResult, Model model) {

		List<UCMConfiguration> ucmConfigurations = new ArrayList<UCMConfiguration>();
		for (UCMConfiguration ucm_conf : ucmConfigurationForm
				.getUcmConfigurations()) {
			if (ucm_conf.isUpdated()) {
				ucmConfigurations.add(ucm_conf);
			}
		}
		ucmConfigurationForm.setUcmConfigurations(ucmConfigurations);
		if (bindingResult.hasErrors()) {
			EntityForm entityForm = new EntityForm();
			entityForm.getListEntityForm();
			model.addAttribute("entityList", entityForm);
			model.addAttribute("noOfUcm", ucmConfigurationForm
					.getUcmConfigurations().size());
			return "UCMGeneratorList";
		} else {
			for (UCMConfiguration ucm_conf : ucmConfigurationForm
					.getUcmConfigurations()) {
				// set ucm radio serial and date issued
				ucm_conf.setSerialNoAndDate();

				// insert remedy
				Remedy remedy = new Remedy(ucm_conf.getRemedy_id(),
						ucm_conf.getRequest_no(), ucm_conf.getSub_entity());

				// insert remedy to DB
				UCMGeneratorLogic.insertRemedy(remedy);
				// get the insert information
				// if there is no available radio id, need to prompt an error
				// message here. but how?
				UCMGeneratorLogic.getInsertUCMConfiguration(ucm_conf);
			}
			/*
			 * for (UCMConfiguration ucm_conf : ucmConfigurationForm
			 * .getUcmConfigurations()) { System.out.println("pre insert: " +
			 * ucm_conf); }
			 */
			model.addAttribute("noOfUcm", ucmConfigurationForm
					.getUcmConfigurations().size());
			// create core access point list to choose for input
			CoreAccessPointForm coreAccessPointForm = new CoreAccessPointForm();
			coreAccessPointForm.getListCoreAccessPointForm();
			model.addAttribute("coreAccessPointForm", coreAccessPointForm);
			return "UCMGeneratorListResult";
		}
	}

	@RequestMapping(value = "/generateUCMConfigurationList", method = RequestMethod.POST, params = { "deny" })
	public String backtoUCMUploadPage(Model model) {
		// remove radio with "Temp" tag
		UCMGeneratorLogic.removeRadioTempTag();
		return "UCMGeneratorListHome";
	}

	// insert UCM to the database, and create remedy export
	@RequestMapping(value = "/UCMGeneratorListSubmission", method = RequestMethod.POST, params = { "approve" })
	public String saveUCMList(
			@ModelAttribute("UCMConfigurationForm") UCMConfigurationForm ucmConfigurationForm,
			Model model) {
		for (UCMConfiguration ucm_conf : ucmConfigurationForm
				.getUcmConfigurations()) {
			// System.out.println("insert: " + ucm_conf);
			// insert to UCM_configuration table
			int remedy_id = ucm_conf.insertToDatabase();
			ucm_conf.setUcm_id(remedy_id);
			// ucm_conf.setUcm_id(ucm_conf.insertToDatabase());
			// change used_tag of radio from Temp to "Yes"
			UCMGeneratorLogic.updateRadioUsedTag(ucm_conf);
			// System.out.println("after insert " + ucm_conf);
			// create then insert remedy_export
			ucm_conf.insertRemedyExport();
		}
		model.addAttribute("noOfUcm", ucmConfigurationForm
				.getUcmConfigurations().size());
		return "UCMGeneratorListExport";
	}

	@RequestMapping(value = "/UCMGeneratorListSubmission", method = RequestMethod.POST, params = { "deny" })
	public String backToGenerateUCMConfigurationList(
			@ModelAttribute("UCMConfigurationForm") UCMConfigurationForm ucmConfigurationForm,
			Model model) {
		// remove radio with "Temp" tag
		UCMGeneratorLogic.removeRadioTempTag();
		EntityForm entityForm = new EntityForm();
		entityForm.getListEntityForm();
		model.addAttribute("entityList", entityForm);
		model.addAttribute("noOfUcm", ucmConfigurationForm
				.getUcmConfigurations().size());
		return "UCMGeneratorList";
	}

	// export UCM
	@RequestMapping(value = "/UCMGeneratorListExport", method = RequestMethod.POST, params = { "ucm" })
	public void exportUCM(
			@ModelAttribute("UCMConfigurationForm") UCMConfigurationForm ucmConfigurationForm,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		File downloadFile = UCMExportLogic.ucmListFileWriter("ucmListFlaw",
				ucmConfigurationForm);
		UCMExportLogic.generateResponseFile(request, response, downloadFile);
	}

	// export remedy
	@RequestMapping(value = "/UCMGeneratorListExport", method = RequestMethod.POST, params = { "remedy" })
	public void exportRemedy(
			@ModelAttribute("UCMConfigurationForm") UCMConfigurationForm ucmConfigurationForm,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		RemedyExportForm remedyExportForm = new RemedyExportForm();
		List<RemedyExport> remedyExports = new ArrayList<RemedyExport>();
		for (UCMConfiguration ucm_conf : ucmConfigurationForm
				.getUcmConfigurations()) {
			RemedyExport remedyExport = new RemedyExport(
					ucm_conf.getRadio_id(), ucm_conf.getRadio_type(),
					ucm_conf.getUcm_id());
			remedyExports.add(remedyExport);
		}
		remedyExportForm.setRemedyExports(remedyExports);
		File downloadFile = UCMExportLogic.ucmListFileWriter("remedyList",
				remedyExportForm);
		UCMExportLogic.generateResponseFile(request, response, downloadFile);
	}

	// back to UCM List generator
	@RequestMapping(value = "/UCMGeneratorListExport", method = RequestMethod.POST, params = { "back" })
	public String backToUCMGenerator(Model model) {
		return getUCMUploadPage(model);
	}

	// to convert Multipart File to File which is parsed to Java Bean later by
	// OpenCSV
	private File multipartToFile(MultipartFile multipart)
			throws IllegalStateException, IOException {
		File tmpFile = File.createTempFile("temp", "csv");
		multipart.transferTo(tmpFile);
		return tmpFile;
	}

	// parse csv to a list of ucm inputs
	private UCMGeneratorInputForm parseCSVtoBean(File file) {
		UCMGeneratorInputForm ucmGeneratorForm = new UCMGeneratorInputForm();
		try {
			// To ignore Processing of 1st row
			CSVReader reader = new CSVReader(new FileReader(file), ',', '\"', 1);

			ColumnPositionMappingStrategy<UCMGeneratorInput> mappingStrategy = new ColumnPositionMappingStrategy<UCMGeneratorInput>();
			mappingStrategy.setType(UCMGeneratorInput.class);

			// the fields to bind do in your JavaBean
			String[] columns = new String[] { "remedy_id", "activation_status",
					"radio_serial_number", "radio_user_alias", "ucp",
					"radio_modulation_type_id", "zone_id", "entity_name",
					"request_no", "sub_entity", "radio_user_data_type",
					"radio_type" };
			mappingStrategy.setColumnMapping(columns);
			CsvToBean<UCMGeneratorInput> csv = new CsvToBean<UCMGeneratorInput>();
			List<UCMGeneratorInput> ucmGeneratorInputList = csv.parse(
					mappingStrategy, reader);
			ucmGeneratorForm.setUcmGeneratorInputs(ucmGeneratorInputList);
			/*
			 * for (UCMGeneratorInput input : ucmGeneratorInputList) {
			 * System.out.println(input); }
			 */
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return ucmGeneratorForm;
	}
}
