package motorolasolutions.com.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import motorolasolutions.com.DataObject.Entity;
import motorolasolutions.com.DataObject.EntityForm;
import motorolasolutions.com.DataObject.Radio;
import motorolasolutions.com.DataObject.Remedy;
import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.UCMConfigurationForm;
import motorolasolutions.com.DataObject.UCMExport;
import motorolasolutions.com.DataObject.UCMGeneratorInput;
import motorolasolutions.com.DataObject.UCMGeneratorInputForm;
import motorolasolutions.com.DataObject.Zone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

@Controller
public class UCMGeneratorListController {

    @Autowired
    @Qualifier("UCMInputValidator")
    private Validator validator;
 
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(value = "/UCMGeneratorList", method = RequestMethod.GET)
	public String getUploadPage(Model model) {
		return "UCMGeneratorListHome";
	}

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/UCMGeneratorList", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file, Model model) {

		if (!file.isEmpty()) {
			try {
				UCMGeneratorInputForm ucmGeneratorInputForm = parseCSVtoBean(multipartToFile(file));

				// create a list of UCMConfiguration
				List<UCMConfiguration> ucmConfigurationList = new ArrayList();
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
					ucm_conf.setRadio_modulation_type_id(ucmGeneratorInput
							.getRadio_modulation_type_id());
					ucm_conf.setActivation_status(ucmGeneratorInput
							.getActivation_status());
					ucmConfigurationList.add(ucm_conf);
				}

				UCMConfigurationForm ucmConfigurationForm = new UCMConfigurationForm();
				ucmConfigurationForm.setUcmConfigurations(ucmConfigurationList);
				model.addAttribute("inputList", ucmGeneratorInputForm);
				EntityForm entityForm = new EntityForm();
				entityForm.getListEntityForm();
				model.addAttribute("entityList", entityForm);
				model.addAttribute("UCMConfigurationForm", ucmConfigurationForm);
				for (UCMConfiguration ucm_conf : ucmConfigurationForm
						.getUcmConfigurations()) {
					System.out.println(ucm_conf.getRemedy_id());
				}
				// return "You successfully uploaded file=" + name;
				return "result2";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody String uploadMultipleFileHandler(
			@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				message = message + "You successfully uploaded file=" + name
						+ "<br />";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
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
			for (UCMGeneratorInput input : ucmGeneratorInputList) {
				System.out.println(input);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return ucmGeneratorForm;
	}

	private UCMConfiguration generateUCM(UCMConfiguration ucm_conf) {
		String check_alias_message;
		String check_serial_message;
		// check radio serial duplicate
		ucm_conf.setSerialNoAndDate();

		if (ucm_conf.checkRadioSerialDuplicate() == 0) {
			check_serial_message = "validated";
		} else {
			check_serial_message = "duplicate";
			ucm_conf.setRadio_serial_number(ucm_conf.getRadio_serial_number()+"(duplicate)");
		}
		//model.addAttribute("check_serial_message", check_serial_message);
		// check radio user alias duplicate
		if (ucm_conf.checkRadioUserAliasDuplicate() == 0) {
			check_alias_message = "validated";
		} else {
			check_alias_message = "duplicate";
			ucm_conf.setRadio_user_alias(ucm_conf.getRadio_user_alias()+"(duplicated)");
		}
		//model.addAttribute("check_alias_message", check_alias_message);

		// if there is no duplicate with radio alias & serial number, allocate
		// radio ID and return result
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
			return ucm_conf;

			//model.addAttribute("UCMConfiguration", ucm_conf);
			//return "UCMGeneratorResult";
		}
		// if there is duplicate in radio serial number or alias, return it
		else {
			System.out.println("radio serial & alias duplicate");
			if (ucm_conf.getRadio_modulation_type_id() == 3) {
				ucm_conf.setRadio_serial_number(ucm_conf
						.getRadio_serial_number().substring(1,
								ucm_conf.getRadio_serial_number().length()));
			}
			return ucm_conf;
			//return "UCMGenerator";
		}
	}
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
