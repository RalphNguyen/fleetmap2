/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.BusinessLogic;

import motorolasolutions.com.DataObject.Entity;
import motorolasolutions.com.DataObject.Radio;
import motorolasolutions.com.DataObject.Remedy;
import motorolasolutions.com.DataObject.UCMConfiguration;

/**
 *
 * @author djfp43
 */
public class UCMGeneratorLogic {

	// check & insert new UCM
	public static UCMConfiguration getInsertUCMConfiguration(
			UCMConfiguration ucm_conf) {
		Entity entity = new Entity(ucm_conf.getEntity_name());
		// System.out.println("entity: " + entity);
		// set entity id
		ucm_conf.setEntity_id(entity.getEntity_id());
		// get an available Radio ID from the database
		// then create a Radio
		int temp_radio_id = ucm_conf.checkRadioIDAvailability();
		// create entity from user input

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
	
	public static void insertRemedy(Remedy remedy) {
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
	
}
