/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DataObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;

/**
 *
 * @author djfp43
 */
public class RemedyExport implements UpdateData {
	private String ci_id;
	private String ci_name;
	private String ci_company;
	private String ci_description;
	private String product_categorization_tier_1;
	private String product_categorization_tier_2;
	private String product_categorization_tier_3;
	private String allocated_company;
	private String additional_information;
	private String warning_message;
	private String status;
	private String logical_id;
	private String data_updated_note;
	private int ucm_id;
	private String entity_name;
	private String radio_serial_number;
	private String radio_user_alias;
	private int radio_id;
	private String ucp;
	private String activation_status;
	private String radio_type;
	private String security_group;
	private String interconnect_enabled;
	private int zone_id;
	private String soft_id;
	private String remedy_id;

	public String getCi_id() {
		return ci_id;
	}

	public void setCi_id(String ci_id) {
		this.ci_id = ci_id;
	}

	public String getCi_name() {
		return ci_name;
	}

	public void setCi_name(String ci_name) {
		this.ci_name = ci_name;
	}

	public String getCi_company() {
		return ci_company;
	}

	public void setCi_company(String ci_company) {
		this.ci_company = ci_company;
	}

	public String getCi_description() {
		return ci_description;
	}

	public void setCi_description(String ci_description) {
		this.ci_description = ci_description;
	}

	public String getProduct_categorization_tier_1() {
		return product_categorization_tier_1;
	}

	public void setProduct_categorization_tier_1(
			String product_categorization_tier_1) {
		this.product_categorization_tier_1 = product_categorization_tier_1;
	}

	public String getProduct_categorization_tier_2() {
		return product_categorization_tier_2;
	}

	public void setProduct_categorization_tier_2(
			String product_categorization_tier_2) {
		this.product_categorization_tier_2 = product_categorization_tier_2;
	}

	public String getProduct_categorization_tier_3() {
		return product_categorization_tier_3;
	}

	public void setProduct_categorization_tier_3(
			String product_categorization_tier_3) {
		this.product_categorization_tier_3 = product_categorization_tier_3;
	}

	public String getAllocated_company() {
		return allocated_company;
	}

	public void setAllocated_company(String allocated_company) {
		this.allocated_company = allocated_company;
	}

	public String getAdditional_information() {
		return additional_information;
	}

	public void setAdditional_information(String additional_information) {
		this.additional_information = additional_information;
	}

	public String getWarning_message() {
		return warning_message;
	}

	public void setWarning_message(String warning_message) {
		this.warning_message = warning_message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogical_id() {
		return logical_id;
	}

	public void setLogical_id(String logical_id) {
		this.logical_id = logical_id;
	}

	public String getData_updated_note() {
		return data_updated_note;
	}

	public void setData_updated_note(String data_updated_note) {
		this.data_updated_note = data_updated_note;
	}

	public int getUcm_id() {
		return ucm_id;
	}

	public void setUcm_id(int ucm_id) {
		this.ucm_id = ucm_id;
	}

	public String getEntity_name() {
		return entity_name;
	}

	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
	}

	public String getRadio_serial_number() {
		return radio_serial_number;
	}

	public void setRadio_serial_number(String radio_serial_number) {
		this.radio_serial_number = radio_serial_number;
	}

	public String getRadio_user_alias() {
		return radio_user_alias;
	}

	public void setRadio_user_alias(String radio_user_alias) {
		this.radio_user_alias = radio_user_alias;
	}

	public int getRadio_id() {
		return radio_id;
	}

	public void setRadio_id(int radio_id) {
		this.radio_id = radio_id;
	}

	public String getUcp() {
		return ucp;
	}

	public void setUcp(String ucp) {
		this.ucp = ucp;
	}

	public String getActivation_status() {
		return activation_status;
	}

	public void setActivation_status(String activation_status) {
		this.activation_status = activation_status;
	}

	public String getRadio_type() {
		return radio_type;
	}

	public void setRadio_type(String radio_type) {
		this.radio_type = radio_type;
	}

	public String getSecurity_group() {
		return security_group;
	}

	public void setSecurity_group(String security_group) {
		this.security_group = security_group;
	}

	public String getInterconnect_enabled() {
		return interconnect_enabled;
	}

	public void setInterconnect_enabled(String interconnect_enabled) {
		this.interconnect_enabled = interconnect_enabled;
	}

	public int getZone_id() {
		return zone_id;
	}

	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}

	public String getSoft_id() {
		return soft_id;
	}

	public void setSoft_id(String soft_id) {
		this.soft_id = soft_id;
	}

	public String getRemedy_id() {
		return remedy_id;
	}

	public void setRemedy_id(String remedy_id) {
		this.remedy_id = remedy_id;
	}

	// create a remedyExport
	public RemedyExport(int radio_id, String radio_type, int ucm_id) {
		ci_company = "SA GRN";
		ci_id = "SAGRN.VRID." + radio_id;
		ci_name = ci_id;
		if (radio_type.equals("Radio")) {
			ci_description = "SAGRN Radio ID";
			product_categorization_tier_3 = "Radio ID";
		} else {
			ci_description = "SAGRN Centracom ID";
			product_categorization_tier_3 = "Centracom ID";
		}
		product_categorization_tier_1 = "Terminal ID";
		product_categorization_tier_2 = "Radio";
		allocated_company = "SA GRN";
		additional_information = "";
		warning_message = "";
		logical_id = "";
		data_updated_note = "";
		status = "Deployed";
		this.ucm_id = ucm_id;
	}

	@Override
	public String toString() {
		String s;
		s = "('" + ci_id + "','" + ci_name + "','" + ci_company + "','"
				+ ci_description + "','" + product_categorization_tier_1
				+ "','" + product_categorization_tier_2 + "','"
				+ product_categorization_tier_3 + "','" + allocated_company
				+ "','" + additional_information + "','" + warning_message
				+ "','" + status + "','" + logical_id + "','"
				+ data_updated_note + "'," + ucm_id + ")";
		return s;
	}

	@Override
	public int insertToDatabase() {
		DAOFactory remedyExportDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.REMEDYEXPORT);
		DBManipulationDAO dBManipulationDAO = remedyExportDAOFactory
				.getDBManipulationDAO();
		return (dBManipulationDAO.insertObject(this));
	}

	@Override
	public int updateToDatabase() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int removeFromDatabase() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	// print csv to export
	public String getCSV() {
		String s;
		DAOFactory remedyExportDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.REMEDYEXPORT);
		DBManipulationDAO dBManipulationDAO = remedyExportDAOFactory
				.getDBManipulationDAO();
		dBManipulationDAO.getCSVObject(this);
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");// dd/MM/yyyy
		Date now = new Date();	 
		data_updated_note = "New Radio-TRP-"+remedy_id+"-"+sdfDate.format(now);
		s = ci_company + "," + ci_id + "," + ci_name + "," + ci_description
				+ "," + product_categorization_tier_1 + ","
				+ product_categorization_tier_2 + ","
				+ product_categorization_tier_3 + "," + allocated_company + ","
				+ entity_name + "," + entity_name + "," + radio_serial_number
				+ "," + radio_id + "," + ucp + "," + radio_user_alias + ","
				+ additional_information + "," + warning_message + "," + status
				+ "," + activation_status + "," + radio_type+"," + security_group
				+ "," + interconnect_enabled + "," + zone_id + "," + soft_id
				+ "," + logical_id + "," + data_updated_note;
		return s;
	}
}
