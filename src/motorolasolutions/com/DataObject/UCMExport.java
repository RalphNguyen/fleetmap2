package motorolasolutions.com.DataObject;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;

public class UCMExport implements ExportFile {
	private int ucm_id;
	private String radio_user_data_type;
	private String activation_status;
	private int radio_id;
	private String radio_serial_number;
	private String radio_user_alias;
	private String voice_enabled;
	private String interconnect_enabled;
	private String emergency_alarm_comments;
	private String secure_comms_mode;
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
	private String id_issued_date;
	private String date_modified;
	private String ucp;
	private String soft_id;
	private String radio_type;
	private int security_group_id;
	private int radio_site_access_profile_id;
	private String remedy_id;
	private int radio_user_interconnect_profile_id;
	private int backup_core_access_point_name_id;
	private int primary_core_access_point_name_id;
	private String interconnect_subsystem;
	private String talkgroup_alias;
	private String radio_capabilities_profile_id;

	// getter and setter
	public int getUcm_id() {
		return ucm_id;
	}

	public void setUcm_id(int ucm_id) {
		this.ucm_id = ucm_id;
	}

	public String getRadio_user_data_type() {
		return radio_user_data_type;
	}

	public void setRadio_user_data_type(String radio_user_data_type) {
		this.radio_user_data_type = radio_user_data_type;
	}

	public String getActivation_status() {
		return activation_status;
	}

	public void setActivation_status(String activation_status) {
		this.activation_status = activation_status;
	}

	public int getRadio_id() {
		return radio_id;
	}

	public void setRadio_id(int radio_id) {
		this.radio_id = radio_id;
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

	public String getVoice_enabled() {
		return voice_enabled;
	}

	public void setVoice_enabled(String voice_enabled) {
		this.voice_enabled = voice_enabled;
	}

	public String getInterconnect_enabled() {
		return interconnect_enabled;
	}

	public void setInterconnect_enabled(String interconnect_enabled) {
		this.interconnect_enabled = interconnect_enabled;
	}

	public String getEmergency_alarm_comments() {
		return emergency_alarm_comments;
	}

	public void setEmergency_alarm_comments(String emergency_alarm_comments) {
		this.emergency_alarm_comments = emergency_alarm_comments;
	}

	public String getSecure_comms_mode() {
		return secure_comms_mode;
	}

	public void setSecure_comms_mode(String secure_comms_mode) {
		this.secure_comms_mode = secure_comms_mode;
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

	public String getId_issued_date() {
		return id_issued_date;
	}

	public void setId_issued_date(String id_issued_date) {
		this.id_issued_date = id_issued_date;
	}

	public String getDate_modified() {
		return date_modified;
	}

	public void setDate_modified(String date_modified) {
		this.date_modified = date_modified;
	}

	public String getUcp() {
		return ucp;
	}

	public void setUcp(String ucp) {
		this.ucp = ucp;
	}

	public String getSoft_id() {
		return soft_id;
	}

	public void setSoft_id(String soft_id) {
		this.soft_id = soft_id;
	}

	public String getRadio_type() {
		return radio_type;
	}

	public void setRadio_type(String radio_type) {
		this.radio_type = radio_type;
	}

	public int getSecurity_group_id() {
		return security_group_id;
	}

	public void setSecurity_group_id(int security_group_id) {
		this.security_group_id = security_group_id;
	}

	public int getRadio_site_access_profile_id() {
		return radio_site_access_profile_id;
	}

	public void setRadio_site_access_profile_id(int radio_site_access_profile_id) {
		this.radio_site_access_profile_id = radio_site_access_profile_id;
	}

	public String getRemedy_id() {
		return remedy_id;
	}

	public void setRemedy_id(String remedy_id) {
		this.remedy_id = remedy_id;
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

	public String getInterconnect_subsystem() {
		return interconnect_subsystem;
	}

	public void setInterconnect_subsystem(String interconnect_subsystem) {
		this.interconnect_subsystem = interconnect_subsystem;
	}

	public String getTalkgroup_alias() {
		return talkgroup_alias;
	}

	public void setTalkgroup_alias(String talkgroup_alias) {
		this.talkgroup_alias = talkgroup_alias;
	}

	public String getRadio_capabilities_profile_id() {
		return radio_capabilities_profile_id;
	}

	public void setRadio_capabilities_profile_id(
			String radio_capabilities_profile_id) {
		this.radio_capabilities_profile_id = radio_capabilities_profile_id;
	}

	@Override
	public String getCSV() {
		DAOFactory ucmDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.UCMEXPORT);
		DBManipulationDAO dBManipulationDAO = ucmDAOFactory
				.getDBManipulationDAO();
		dBManipulationDAO.getCSVObject(this);
		String s;
		s = radio_id+","+radio_serial_number+","+radio_user_alias+","+security_group_id+","
				+radio_capabilities_profile_id+","+radio_site_access_profile_id+","+talkgroup_alias+","
				+voice_enabled+","+interconnect_enabled+","+emergency_alarm_comments+","+secure_comms_mode+","
				+data_capabilities+","+direct_dial_number+","+secure_land_to_mobile_start_mode+","+interconnect_subsystem+","
				+radio_user_interconnect_profile_id+","+interconnect_secure_key_reference+","+ip_address_assignment+","
				+ip_address+","+generate_icmp_message+","+source_address_checking+","+ready_timer+","+data_agency_group+","
				+primary_core_access_point_name_id+","+backup_core_access_point_name_id+","+notes+","+date_modified;
		return s;
	}
	
	@Override
	public String toString(){
		return "("+getCSV()+")";
	}

}
