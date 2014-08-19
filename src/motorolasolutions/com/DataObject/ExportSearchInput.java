package motorolasolutions.com.DataObject;

public class ExportSearchInput {
	private String startDate;
	private String endDate;
	private String entity_name;
	private int zone_id;
	private String remedy_id;
	private String radio_serial_number;
	private String activation_status;
	private int radio_id;
	private boolean searchByIdIssuedDate;
	private boolean searchByEntity;
	private boolean searchByZoneId;
	private boolean searchByRemedyId;
	private boolean searchByRadioSerialNumber;
	private boolean searchByStatus;
	private boolean searchByRadioId;

	// getter & setter
	public String getEntity_name() {
		return entity_name;
	}

	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getZone_id() {
		return zone_id;
	}

	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}

	public String getRemedy_id() {
		return remedy_id;
	}

	public void setRemedy_id(String remedy_id) {
		this.remedy_id = remedy_id;
	}

	public String getRadio_serial_number() {
		return radio_serial_number;
	}

	public void setRadio_serial_number(String radio_serial_number) {
		this.radio_serial_number = radio_serial_number;
	}

	public String getActivation_status() {
		return activation_status;
	}

	public void setActivation_status(String activation_status) {
		this.activation_status = activation_status;
	}

	public boolean isSearchByIdIssuedDate() {
		return searchByIdIssuedDate;
	}

	public void setSearchByIdIssuedDate(boolean searchByIdIssuedDate) {
		this.searchByIdIssuedDate = searchByIdIssuedDate;
	}

	public boolean isSearchByEntity() {
		return searchByEntity;
	}

	public void setSearchByEntity(boolean searchByEntity) {
		this.searchByEntity = searchByEntity;
	}

	public boolean isSearchByZoneId() {
		return searchByZoneId;
	}

	public void setSearchByZoneId(boolean searchByZoneId) {
		this.searchByZoneId = searchByZoneId;
	}

	public boolean isSearchByRemedyId() {
		return searchByRemedyId;
	}

	public void setSearchByRemedyId(boolean searchByRemedyId) {
		this.searchByRemedyId = searchByRemedyId;
	}

	public boolean isSearchByRadioSerialNumber() {
		return searchByRadioSerialNumber;
	}

	public void setSearchByRadioSerialNumber(boolean searchByRadioSerialNumber) {
		this.searchByRadioSerialNumber = searchByRadioSerialNumber;
	}

	public boolean isSearchByStatus() {
		return searchByStatus;
	}

	public void setSearchByStatus(boolean searchByStatus) {
		this.searchByStatus = searchByStatus;
	}

	public boolean isSearchByRadioId() {
		return searchByRadioId;
	}

	public void setSearchByRadioId(boolean searchByRadioId) {
		this.searchByRadioId = searchByRadioId;
	}

	public int getRadio_id() {
		return radio_id;
	}

	public void setRadio_id(int radio_id) {
		this.radio_id = radio_id;
	}

	@Override
	public String toString() {
		String s;
		s = "(" + searchByIdIssuedDate + ",'" + startDate + "','" + endDate
				+ "'," + searchByEntity + ",'" + entity_name + "',"
				+ searchByRadioId + "," + radio_id + ","
				+ searchByRadioSerialNumber + ",'" + radio_serial_number + "',"
				+ searchByZoneId + "," + zone_id + "," + searchByStatus + ",'"
				+ activation_status + "'," + searchByRemedyId + ",'"
				+ remedy_id + "')";
		return s;
	}
}
