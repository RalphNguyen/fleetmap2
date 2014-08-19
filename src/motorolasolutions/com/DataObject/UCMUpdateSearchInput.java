package motorolasolutions.com.DataObject;

public class UCMUpdateSearchInput {
	private String radio_user_alias;
	private String radio_serial_number;
	private int radio_id;
	private boolean searchByRadioUserAlias;
	private boolean searchByRadioSerialNumber;
	private boolean searchByRadioID;

	//getters & setters
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

	public int getRadio_id() {
		return radio_id;
	}

	public void setRadio_id(int radio_id) {
		this.radio_id = radio_id;
	}

	public boolean isSearchByRadioUserAlias() {
		return searchByRadioUserAlias;
	}

	public void setSearchByRadioUserAlias(boolean searchByRadioUserAlias) {
		this.searchByRadioUserAlias = searchByRadioUserAlias;
	}

	public boolean isSearchByRadioSerialNumber() {
		return searchByRadioSerialNumber;
	}

	public void setSearchByRadioSerialNumber(boolean searchByRadioSerialNumber) {
		this.searchByRadioSerialNumber = searchByRadioSerialNumber;
	}

	public boolean isSearchByRadioID() {
		return searchByRadioID;
	}

	public void setSearchByRadioID(boolean searchByRadioID) {
		this.searchByRadioID = searchByRadioID;
	}

}
