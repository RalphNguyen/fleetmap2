package motorolasolutions.com.DataObject;

public class UCMGeneratorInput {
	private String remedy_id;
	private String radio_type;
	private String radio_user_data_type;
	private String radio_user_alias;
	private String radio_serial_number;
	private String ucp;
	private int zone_id;
	private String entity_name;
	private String request_no;
	private String sub_entity;
	private int radio_modulation_type_id;
	private String activation_status;

	// getter & setter

	public String getRemedy_id() {
		return remedy_id;
	}

	public void setRemedy_id(String remedy_id) {
		this.remedy_id = remedy_id;
	}

	public String getRadio_type() {
		return radio_type;
	}

	public void setRadio_type(String radio_type) {
		this.radio_type = radio_type;
	}

	public String getRadio_user_data_type() {
		return radio_user_data_type;
	}

	public void setRadio_user_data_type(String radio_user_data_type) {
		this.radio_user_data_type = radio_user_data_type;
	}

	public String getRadio_user_alias() {
		return radio_user_alias;
	}

	public void setRadio_user_alias(String radio_user_alias) {
		this.radio_user_alias = radio_user_alias;
	}

	public String getRadio_serial_number() {
		return radio_serial_number;
	}

	public void setRadio_serial_number(String radio_serial_number) {
		this.radio_serial_number = radio_serial_number;
	}

	public String getUcp() {
		return ucp;
	}

	public void setUcp(String ucp) {
		this.ucp = ucp;
	}

	public int getZone_id() {
		return zone_id;
	}

	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}

	public String getEntity_name() {
		return entity_name;
	}

	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
	}

	public String getSub_entity() {
		return sub_entity;
	}

	public void setSub_entity(String sub_entity) {
		this.sub_entity = sub_entity;
	}

	public int getRadio_modulation_type_id() {
		return radio_modulation_type_id;
	}

	public void setRadio_modulation_type_id(int radio_modulation_type_id) {
		this.radio_modulation_type_id = radio_modulation_type_id;
	}

	public String getActivation_status() {
		return activation_status;
	}

	public void setActivation_status(String activation_status) {
		this.activation_status = activation_status;
	}

	public String getRequest_no() {
		return request_no;
	}

	public void setRequest_no(String request_no) {
		this.request_no = request_no;
	}
	
	public String toString() {
		String s;
		s = remedy_id + "," + activation_status + "," + radio_serial_number
				+ "," + radio_user_alias + "," + ucp + ","
				+ radio_modulation_type_id + "," + zone_id + "," + entity_name
				+ "," + request_no + "," + sub_entity + ","
				+ radio_user_data_type + "," + radio_type;
		return s;
	}
}
