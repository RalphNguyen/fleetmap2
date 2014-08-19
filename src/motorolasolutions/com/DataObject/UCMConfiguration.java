/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DataObject;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;
import motorolasolutions.com.DAO.DBValidationDAO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author djfp43
 */
public class UCMConfiguration implements UpdateData {
	private int ucm_id;
	private String activation_status;
	private String radio_user_data_type;
	private String voice_enabled;
	private String interconnect_enabled;
	private String radio_serial_number;
	private String secure_comms_mode;
	private String radio_user_alias;
	private String radio_user_site_access_profile_alias;
	private String ucp;
	private String id_issued_date;
	private String soft_id;
	private int radio_id;
	private int security_group_id;
	private String radio_type;
	private String remedy_id;
	private int zone_id;
	private String zone_name;
	private String entity_name;
	private String sub_entity;
	private int entity_id;
	private int radio_modulation_type_id;
	private int agency_id;
	private String request_no;
	private String emergency_alarm_comments;
	private String data_capabilities;
	private String direct_dial_number;
	private String secure_land_to_mobile_start_mode;
	private String interconnect_secure_key_reference;
	private String ip_address_assignment;
	private String ip_address;
	private String generate_icmp_message;
	private String source_address_checking;
	private int ready_timer;
	private String data_agency_group;
	private String notes;
	private String date_modified;
	private int radio_site_access_profile_id;
	private int radio_user_interconnect_profile_id;
	private int backup_core_access_point_name_id;
	private int primary_core_access_point_name_id;
	private boolean updated;

	// getter and setter methods
	public String getEmergency_alarm_comments() {
		return emergency_alarm_comments;
	}

	public void setEmergency_alarm_comments(String emergency_alarm_comments) {
		this.emergency_alarm_comments = emergency_alarm_comments;
	}

	public String getData_capabilities() {
		return data_capabilities;
	}

	public void setData_capabilities(String data_capabilities) {
		this.data_capabilities = data_capabilities;
	}

	public String getDirect_dial_number() {
		return direct_dial_number;
	}

	public void setDirect_dial_number(String direct_dial_number) {
		this.direct_dial_number = direct_dial_number;
	}

	public String getSecure_land_to_mobile_start_mode() {
		return secure_land_to_mobile_start_mode;
	}

	public void setSecure_land_to_mobile_start_mode(
			String secure_land_to_mobile_start_mode) {
		this.secure_land_to_mobile_start_mode = secure_land_to_mobile_start_mode;
	}

	public String getInterconnect_secure_key_reference() {
		return interconnect_secure_key_reference;
	}

	public void setInterconnect_secure_key_reference(
			String interconnect_secure_key_reference) {
		this.interconnect_secure_key_reference = interconnect_secure_key_reference;
	}

	public String getIp_address_assignment() {
		return ip_address_assignment;
	}

	public void setIp_address_assignment(String ip_address_assignment) {
		this.ip_address_assignment = ip_address_assignment;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getGenerate_icmp_message() {
		return generate_icmp_message;
	}

	public void setGenerate_icmp_message(String generate_icmp_message) {
		this.generate_icmp_message = generate_icmp_message;
	}

	public String getSource_address_checking() {
		return source_address_checking;
	}

	public void setSource_address_checking(String source_address_checking) {
		this.source_address_checking = source_address_checking;
	}

	public int getReady_timer() {
		return ready_timer;
	}

	public void setReady_timer(int ready_timer) {
		this.ready_timer = ready_timer;
	}

	public String getData_agency_group() {
		return data_agency_group;
	}

	public void setData_agency_group(String data_agency_group) {
		this.data_agency_group = data_agency_group;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDate_modified() {
		return date_modified;
	}

	public void setDate_modified(String date_modified) {
		this.date_modified = date_modified;
	}

	public int getRadio_site_access_profile_id() {
		return radio_site_access_profile_id;
	}

	public void setRadio_site_access_profile_id(int radio_site_access_profile_id) {
		this.radio_site_access_profile_id = radio_site_access_profile_id;
	}

	public int getRadio_user_interconnect_profile_id() {
		return radio_user_interconnect_profile_id;
	}

	public void setRadio_user_interconnect_profile_id(
			int radio_user_interconnect_profile_id) {
		this.radio_user_interconnect_profile_id = radio_user_interconnect_profile_id;
	}

	public int getBackup_core_access_point_name_id() {
		return backup_core_access_point_name_id;
	}

	public void setBackup_core_access_point_name_id(
			int backup_core_access_point_name_id) {
		this.backup_core_access_point_name_id = backup_core_access_point_name_id;
	}

	public int getPrimary_core_access_point_name_id() {
		return primary_core_access_point_name_id;
	}

	public void setPrimary_core_access_point_name_id(
			int primary_core_access_point_name_id) {
		this.primary_core_access_point_name_id = primary_core_access_point_name_id;
	}

	public String getSub_entity() {
		return sub_entity;
	}

	public void setSub_entity(String sub_entity) {
		this.sub_entity = sub_entity;
	}

	public String getEntity_name() {
		return entity_name;
	}

	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
	}

	public String getRequest_no() {
		return request_no;
	}

	public void setRequest_no(String request_no) {
		this.request_no = request_no;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public int getAgency_id() {
		return agency_id;
	}

	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}

	public void setRadio_user_data_type(String radio_user_data_type) {
		this.radio_user_data_type = radio_user_data_type;
	}

	public void setVoice_enabled(String voice_enabled) {
		this.voice_enabled = voice_enabled;
	}

	public void setInterconnect_enabled(String interconnect_enabled) {
		this.interconnect_enabled = interconnect_enabled;
	}

	public void setSecure_comms_mode(String secure_comms_mode) {
		this.secure_comms_mode = secure_comms_mode;
	}

	public void setRadio_user_site_access_profile_alias(
			String radio_user_site_access_profile_alias) {
		this.radio_user_site_access_profile_alias = radio_user_site_access_profile_alias;
	}

	public void setId_issued_date(String id_issued_date) {
		this.id_issued_date = id_issued_date;
	}

	public void setSoft_id(String soft_id) {
		this.soft_id = soft_id;
	}

	public void setRadio_type(String radio_type) {
		this.radio_type = radio_type;
	}

	public void setRemedy_id(String remedy_id) {
		this.remedy_id = remedy_id;
	}

	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}

	public void setEntity_id(int entity_id) {
		this.entity_id = entity_id;
	}

	public void setRadio_modulation_type_id(int radio_modulation_type_id) {
		this.radio_modulation_type_id = radio_modulation_type_id;
	}

	public String getActivation_status() {
		return activation_status;
	}

	public String getRadio_user_data_type() {
		return radio_user_data_type;
	}

	public String getVoice_enabled() {
		return voice_enabled;
	}

	public String getInterconnect_enabled() {
		return interconnect_enabled;
	}

	public String getSecure_comms_mode() {
		return secure_comms_mode;
	}

	public String getRadio_user_site_access_profile_alias() {
		return radio_user_site_access_profile_alias;
	}

	public String getUcp() {
		return ucp;
	}

	public String getId_issued_date() {
		return id_issued_date;
	}

	public String getSoft_id() {
		return soft_id;
	}

	public int getSecurity_group_id() {
		return security_group_id;
	}

	public String getRadio_type() {
		return radio_type;
	}

	public String getRemedy_id() {
		return remedy_id;
	}

	public void setActivation_status(String activation_status) {
		this.activation_status = activation_status;
	}

	public void setRadio_serial_number(String radio_serial_number) {
		this.radio_serial_number = radio_serial_number;
	}

	public void setRadio_user_alias(String radio_user_alias) {
		this.radio_user_alias = radio_user_alias;
	}

	public void setUcp(String ucp) {
		this.ucp = ucp;
	}

	public int getUcm_id() {
		return ucm_id;
	}

	public int getRadio_id() {
		return radio_id;
	}

	public void setUcm_id(int ucm_id) {
		this.ucm_id = ucm_id;
	}

	public void setSecurity_group_id(int security_group_id) {
		this.security_group_id = security_group_id;
	}

	public void setRadio_id(int radio_id) {
		this.radio_id = radio_id;
	}

	public int getRadio_modulation_type_id() {
		return radio_modulation_type_id;
	}

	public int getZone_id() {
		return zone_id;
	}

	public int getEntity_id() {
		return entity_id;
	}

	public String getRadio_serial_number() {
		return radio_serial_number;
	}

	public String getRadio_user_alias() {
		return radio_user_alias;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	public UCMConfiguration(String update_search) {
		radio_serial_number = update_search;
		radio_user_alias = update_search;
		// System.out.println(update_search);
		if (update_search.matches("\\d+")) {
			// System.out.println("match");
			radio_id = Integer.parseInt(update_search);
		} else
			// System.out.println("no match");
			radio_id = 00000;
	}

	// creator with user input
	public UCMConfiguration(String remedy_id, String radio_serial_number,
			String radio_type, String radio_user_alias, String ucp,
			String activation_status, int zone_id, int entity_id,
			int agency_id, int radio_modulation_type_id,
			String radio_user_data_type, String voice_enabled,
			String interconnect_enabled) {
		this.remedy_id = remedy_id;
		this.ucp = ucp;
		this.radio_type = radio_type;
		this.radio_user_alias = radio_user_alias;
		this.activation_status = activation_status;
		this.zone_id = zone_id;
		this.entity_id = entity_id;
		this.agency_id = agency_id;
		this.radio_modulation_type_id = radio_modulation_type_id;
		// if P25, add P to the beginning of serial number
		if (radio_modulation_type_id == 3) {
			this.radio_serial_number = "P" + radio_serial_number;
		} else
			this.radio_serial_number = radio_serial_number;
		this.radio_user_data_type = radio_user_data_type;
		this.voice_enabled = voice_enabled;
		this.interconnect_enabled = interconnect_enabled;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date();
		this.id_issued_date = sdfDate.format(now);
	}

	public UCMConfiguration() {
		// TODO Auto-generated constructor stub
	}

	public void setSerialNoAndDate() {
		if (radio_modulation_type_id == 3) {
			radio_serial_number = "P" + radio_serial_number;
		}
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// dd/MM/yyyy
		Date now = new Date();
		id_issued_date = sdfDate.format(now);
		date_modified = id_issued_date;
	}

	// get data for a record from the database
	public void setUCMData(int ucm_id, String activation_status,
			String radio_user_data_type, String voice_enabled,
			String interconnect_enabled, String radio_serial_number,
			String secure_comms_mode, String radio_user_alias,
			String radio_user_site_access_profile_alias, String ucp,
			String id_issued_date, String soft_id, int radio_id,
			int security_group_id, String radio_type, String remedy_id) {
		this.ucm_id = ucm_id;
		this.activation_status = activation_status;
		this.radio_user_data_type = radio_user_data_type;
		this.voice_enabled = voice_enabled;
		this.interconnect_enabled = interconnect_enabled;
		this.radio_serial_number = radio_serial_number;
		this.secure_comms_mode = secure_comms_mode;
		this.radio_user_alias = radio_user_alias;
		this.radio_user_site_access_profile_alias = radio_user_site_access_profile_alias;
		this.ucp = ucp;
		this.id_issued_date = id_issued_date;
		this.soft_id = soft_id;
		this.radio_id = radio_id;
		this.security_group_id = security_group_id;
		this.radio_type = radio_type;
		this.remedy_id = remedy_id;
	}

	// to generate unimportant fields after main fields are identified
	public void generateFields() {
		switch (radio_modulation_type_id) {
		case 1:
			secure_comms_mode = "Clear";
			break;
		case 2:
			secure_comms_mode = "Both";
			break;
		default:
			secure_comms_mode = "Both";
			break;
		}
		if (radio_modulation_type_id == 3) {
			data_capabilities = "P25 Classic Data Service";
			zone_name = "STATEWIDE-P25";
			radio_site_access_profile_id = 11;
			ip_address_assignment = "Dynamic";
			generate_icmp_message = "On";
			source_address_checking = "On";
			ready_timer = 10;
			primary_core_access_point_name_id = 1;
		} else {
			data_capabilities = "No Data Service";
			ip_address_assignment = "N/A";
			generate_icmp_message = "N/A";
			source_address_checking = "N/A";

			switch (zone_id) {
			case 1:
				zone_name = "STATEWIDE-Z1";
				radio_site_access_profile_id = 5;
				break;
			case 2:
				zone_name = "STATEWIDE-Z2";
				radio_site_access_profile_id = 2;
				break;
			default:
				zone_name = "STATEWIDE-Z3";
				radio_site_access_profile_id = 3;
				break;
			}
		}
		voice_enabled = "Yes";
		interconnect_enabled = "No";
		emergency_alarm_comments = "N/A";
		direct_dial_number = "N/A";
		secure_land_to_mobile_start_mode = "Clear";
		ip_address = "0.0.0.0";
		radio_user_interconnect_profile_id = 1;
		notes = "N/A";
		data_agency_group = "N/A";
		interconnect_secure_key_reference = "N/A";

		// get softID
		soft_id = getSoftID();
	}

	// create insert statement
	@Override
	public String toString() {
		String s;
		s = "(" + ucm_id + ",'" + radio_user_data_type + "','"
				+ activation_status + "'," + radio_id + ",'"
				+ radio_serial_number + "','" + radio_user_alias + "','"
				+ voice_enabled + "','" + interconnect_enabled + "','"
				+ emergency_alarm_comments + "','" + secure_comms_mode + "','"
				+ data_capabilities + "','" + direct_dial_number + "','"
				+ secure_land_to_mobile_start_mode + "','"
				+ interconnect_secure_key_reference + "','"
				+ ip_address_assignment + "','" + ip_address + "','"
				+ generate_icmp_message + "','" + source_address_checking
				+ "'," + ready_timer + ",'" + data_agency_group + "','" + notes
				+ "','" + id_issued_date + "','" + date_modified + "','" + ucp
				+ "','" + soft_id + "','" + radio_type + "'," + security_group_id
				+ "," + radio_site_access_profile_id + ",'" + remedy_id + "',"
				+ radio_user_interconnect_profile_id + ","
				+ backup_core_access_point_name_id + ","
				+ primary_core_access_point_name_id + ")";
		return s;
	}
	
	// print CSV to export
	public String getCSV() {
		// TODO Auto-generated method stub
		String s;
		s = ucm_id + "," + radio_user_data_type + "," + activation_status + ","
				+ radio_id + "," + radio_serial_number + "," + radio_user_alias
				+ "," + voice_enabled + "," + interconnect_enabled + ","
				+ emergency_alarm_comments + "," + secure_comms_mode + ","
				+ data_capabilities + "," + direct_dial_number + ","
				+ secure_land_to_mobile_start_mode + ","
				+ interconnect_secure_key_reference + ","
				+ ip_address_assignment + "," + ip_address + ","
				+ generate_icmp_message + "," + source_address_checking + ","
				+ ready_timer + "," + data_agency_group + "," + notes + ","
				+ id_issued_date + "," + date_modified + "," + ucp + ","
				+ soft_id + "," + radio_type + "," + security_group_id + ","
				+ radio_site_access_profile_id + "," + remedy_id + ","
				+ radio_user_interconnect_profile_id + ","
				+ backup_core_access_point_name_id + ","
				+ primary_core_access_point_name_id;
		return s;
	}

	// check Radio Serial Number Duplicate
	public int checkRadioSerialDuplicate() {
		DAOFactory UCMDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.UCMCONFIGURATION);
		DBValidationDAO dbvalidationDAO = UCMDAOFactory.getDBValidationDAO();
		return (dbvalidationDAO.checkDuplicate(this));
	}

	// check Radio User Alias Duplicate
	public int checkRadioUserAliasDuplicate() {
		DAOFactory UCMDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.UCMCONFIGURATION);
		DBValidationDAO dbvalidationDAO = UCMDAOFactory.getDBValidationDAO();
		return (dbvalidationDAO.checkDuplicate2(this));
	}

	// get the available radio ID from the Database
	public int checkRadioIDAvailability() {
		// System.out.println("test");
		DAOFactory UCMDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.UCMCONFIGURATION);
		DBValidationDAO dbValidationDAO = UCMDAOFactory.getDBValidationDAO();
		return (dbValidationDAO.checkDuplicate3(this));
	}

	// get softID by checking serial number of that radio
	private String getSoftID() {
		String s;
		int linked_radio_id;
		if (radio_modulation_type_id == 3) {
			radio_serial_number = radio_serial_number.substring(1,
					radio_serial_number.length());
			linked_radio_id = checkRadioSerialDuplicate();
			radio_serial_number = "P" + radio_serial_number;
		} else {
			radio_serial_number = "P" + radio_serial_number;
			linked_radio_id = checkRadioSerialDuplicate();
			radio_serial_number = radio_serial_number.substring(1,
					radio_serial_number.length());
		}
		s = "SAGRN.VRID." + linked_radio_id;
		return s;
	}

	// to creat then insert a remedy export to the database
	public int insertRemedyExport() {
		RemedyExport remedyExport = new RemedyExport(radio_id, radio_type,
				ucm_id);
		System.out.println(remedyExport);
		return (remedyExport.insertToDatabase());
	}

	@Override
	public int insertToDatabase() {
		DAOFactory ucmDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.UCMCONFIGURATION);
		DBManipulationDAO dBManipulationDAO = ucmDAOFactory
				.getDBManipulationDAO();
		return (dBManipulationDAO.insertObject(this));
	}

	@Override
	public int updateToDatabase() {
		DAOFactory ucmDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.UCMCONFIGURATION);
		DBManipulationDAO dBManipulationDAO = ucmDAOFactory
				.getDBManipulationDAO();
		return (dBManipulationDAO.updateObject(this));
	}

	@Override
	public int removeFromDatabase() {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	// search for a record of UCM configuration data. return null if there is no
	// result
	public Object searchForUpdate() {
		DAOFactory ucmDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.UCMCONFIGURATION);
		DBManipulationDAO dBManipulationDAO = ucmDAOFactory
				.getDBManipulationDAO();
		return dBManipulationDAO.selectObject(this);
	}
}