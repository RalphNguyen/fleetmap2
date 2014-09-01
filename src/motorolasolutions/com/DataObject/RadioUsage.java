package motorolasolutions.com.DataObject;

public class RadioUsage {
	private int zone_id;
	private String zone_name;
	private int radio_modulation_type_id;
	private String radio_modulation_type;
	private String used_flag;
	private int used_radio;
	private int available_radio;
	private int entity_id;
	private String entity_name;

	//getters & setters
	public int getZone_id() {
		return zone_id;
	}

	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public int getRadio_modulation_type_id() {
		return radio_modulation_type_id;
	}

	public void setRadio_modulation_type_id(int radio_modulation_type_id) {
		this.radio_modulation_type_id = radio_modulation_type_id;
	}

	public String getRadio_modulation_type() {
		return radio_modulation_type;
	}

	public void setRadio_modulation_type(String radio_modulation_type) {
		this.radio_modulation_type = radio_modulation_type;
	}

	public String getUsed_flag() {
		return used_flag;
	}

	public void setUsed_flag(String used_flag) {
		this.used_flag = used_flag;
	}

	public int getUsed_radio() {
		return used_radio;
	}

	public void setUsed_radio(int used_radio) {
		this.used_radio = used_radio;
	}

	public int getAvailable_radio() {
		return available_radio;
	}

	public void setAvailable_radio(int available_radio) {
		this.available_radio = available_radio;
	}

	public int getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(int entity_id) {
		this.entity_id = entity_id;
	}

	public String getEntity_name() {
		return entity_name;
	}

	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
	}

	public String toString(){
		String s;
		s= "Zone ID: "+zone_id+",Modulation Type: "+radio_modulation_type_id+",Used: "+used_flag+",Number of Radio: "+used_radio;
		return s;	
	}
	
	// return csv string to export from dashboard
	public String getCSV(){
		String s;
		s = entity_name+","+used_radio+","+zone_id;
		return s;
	}
}
