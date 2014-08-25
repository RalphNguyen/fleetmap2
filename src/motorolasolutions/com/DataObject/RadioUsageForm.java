package motorolasolutions.com.DataObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import motorolasolutions.com.DAO.DashboardDAO;

public class RadioUsageForm {
	private List<RadioUsage> smartZoneRadioUsages;
	private List<RadioUsage> p25RadioUsages;
	private List<RadioUsage> allRadioUsages;

	public List<RadioUsage> getAllRadioUsages() {
		return allRadioUsages;
	}

	public void setAllRadioUsages(List<RadioUsage> allRadioUsages) {
		this.allRadioUsages = allRadioUsages;
	}

	public List<RadioUsage> getP25RadioUsages() {
		return p25RadioUsages;
	}

	public void setP25RadioUsages(List<RadioUsage> p25RadioUsages) {
		this.p25RadioUsages = p25RadioUsages;
	}

	public List<RadioUsage> getRadioUsages() {
		return smartZoneRadioUsages;
	}

	public void setRadioUsages(List<RadioUsage> radioUsages) {
		this.smartZoneRadioUsages = radioUsages;
	}

	// get the usage of SmartZone Radio
	public void getSmartZoneRadioUsageList() throws SQLException {
		DashboardDAO dashboardDAO = new DashboardDAO();
		this.smartZoneRadioUsages = (List<RadioUsage>) dashboardDAO
				.getSmartZoneUsage();
	}

	public void getP25RadioUsageList() throws SQLException {
		DashboardDAO dashboardDAO = new DashboardDAO();
		this.p25RadioUsages = (List<RadioUsage>) dashboardDAO.getP25Usage();
	}

	public void getAllRadioUsageList() throws SQLException {
		DashboardDAO dashboardDAO = new DashboardDAO();
		this.allRadioUsages = (List<RadioUsage>) dashboardDAO.getAllUsage();
	}

	// get a JSON string of smartzone radio usage to plot to the dashboard
	public String getJSONSmartZoneUsage() {
		int smartZone1ActivatedRadio = 0;
		int smartZone2ActivatedRadio = 0;
		int smartZone3ActivatedRadio = 0;
		int smartZone1DeactivatedRadio = 0;
		int smartZone2DeactivatedRadio = 0;
		int smartZone3DeactivatedRadio = 0;
		int smartZone1UnassignedRadio = 0;
		int smartZone2UnassignedRadio = 0;
		int smartZone3UnassignedRadio = 0;

		List<Integer> smartZoneYes = new ArrayList();
		List<Integer> smartZoneNo = new ArrayList();
		List<Integer> smartZoneNever = new ArrayList();
		List<Integer> smartZone1 = new ArrayList();
		List<Integer> smartZone2 = new ArrayList();
		List<Integer> smartZone3 = new ArrayList();

		for (RadioUsage radioUsage : smartZoneRadioUsages) {
			switch (radioUsage.getZone_id()) {
			case 1:
				if (radioUsage.getUsed_flag().equals("Yes")) {
					smartZoneYes.add(radioUsage.getUsed_radio());
					smartZone1ActivatedRadio += radioUsage.getUsed_radio();
				} else {
					if (radioUsage.getUsed_flag().equals("No")) {
						smartZoneNo.add(radioUsage.getUsed_radio());
						smartZone1DeactivatedRadio += radioUsage
								.getUsed_radio();
					} else {
						smartZoneNever.add(radioUsage.getUsed_radio());
						smartZone1UnassignedRadio += radioUsage.getUsed_radio();
					}
				}
				break;
			case 2:
				if (radioUsage.getUsed_flag().equals("Yes")) {
					smartZoneYes.add(radioUsage.getUsed_radio());
					smartZone2ActivatedRadio += radioUsage.getUsed_radio();
				} else {
					if (radioUsage.getUsed_flag().equals("No")) {
						smartZoneNo.add(radioUsage.getUsed_radio());
						smartZone2DeactivatedRadio += radioUsage
								.getUsed_radio();
					} else {
						smartZoneNever.add(radioUsage.getUsed_radio());
						smartZone2UnassignedRadio += radioUsage.getUsed_radio();
					}
				}
				break;
			case 3:
				if (radioUsage.getUsed_flag().equals("Yes")) {
					smartZoneYes.add(radioUsage.getUsed_radio());
					smartZone3ActivatedRadio += radioUsage.getUsed_radio();
				} else {
					if (radioUsage.getUsed_flag().equals("No")) {
						smartZoneNo.add(radioUsage.getUsed_radio());
						smartZone3DeactivatedRadio += radioUsage
								.getUsed_radio();
					} else {
						smartZoneNever.add(radioUsage.getUsed_radio());
						smartZone3UnassignedRadio += radioUsage.getUsed_radio();
					}
				}
				break;
			}
		}
		smartZone1.add(smartZone1ActivatedRadio);
		smartZone1.add(smartZone1DeactivatedRadio);
		smartZone1.add(smartZone1UnassignedRadio);
		smartZone2.add(smartZone2ActivatedRadio);
		smartZone2.add(smartZone2DeactivatedRadio);
		smartZone2.add(smartZone2UnassignedRadio);
		smartZone3.add(smartZone3ActivatedRadio);
		smartZone3.add(smartZone3DeactivatedRadio);
		smartZone3.add(smartZone3UnassignedRadio);

		return "{\"datasets\":{\"smartZoneActivatedRadios\":"
				+ smartZoneYes.toString() + ",\"smartZoneDeactivatedRadios\":"
				+ smartZoneNo.toString() + ",\"smartZoneUnassignedRadios\":"
				+ smartZoneNever.toString() + ",\"smartZone1\":"
				+ smartZone1.toString() + ",\"smartZone2\":"
				+ smartZone2.toString() + ",\"smartZone3\":"
				+ smartZone3.toString() + "}}";
	}

	// get a JSON string of smartzone radio usage to plot to the dashboard
	public String getJSONP25Usage() {
		int p25Zone1ActivatedRadio = 0;
		int p25Zone2ActivatedRadio = 0;
		int p25Zone3ActivatedRadio = 0;
		int p25Zone1DeactivatedRadio = 0;
		int p25Zone2DeactivatedRadio = 0;
		int p25Zone3DeactivatedRadio = 0;
		int p25Zone1UnassignedRadio = 0;
		int p25Zone2UnassignedRadio = 0;
		int p25Zone3UnassignedRadio = 0;

		List<Integer> p25Zone1 = new ArrayList();
		List<Integer> p25Zone2 = new ArrayList();
		List<Integer> p25Zone3 = new ArrayList();

		for (RadioUsage radioUsage : p25RadioUsages) {
			switch (radioUsage.getZone_id()) {
			case 1:
				if (radioUsage.getUsed_flag().equals("Yes")) {
					p25Zone1ActivatedRadio += radioUsage.getUsed_radio();
				} else {
					if (radioUsage.getUsed_flag().equals("No")) {
						p25Zone1DeactivatedRadio += radioUsage.getUsed_radio();
					} else {
						p25Zone1UnassignedRadio += radioUsage.getUsed_radio();
					}
				}
				break;
			case 2:
				if (radioUsage.getUsed_flag().equals("Yes")) {
					p25Zone2ActivatedRadio += radioUsage.getUsed_radio();
				} else {
					if (radioUsage.getUsed_flag().equals("No")) {
						p25Zone2DeactivatedRadio += radioUsage.getUsed_radio();
					} else {
						p25Zone2UnassignedRadio += radioUsage.getUsed_radio();
					}
				}
				break;
			case 3:
				if (radioUsage.getUsed_flag().equals("Yes")) {
					p25Zone3ActivatedRadio += radioUsage.getUsed_radio();
				} else {
					if (radioUsage.getUsed_flag().equals("No")) {
						p25Zone3DeactivatedRadio += radioUsage.getUsed_radio();
					} else {
						p25Zone3UnassignedRadio += radioUsage.getUsed_radio();
					}
				}
				break;
			}
		}
		p25Zone1.add(p25Zone1ActivatedRadio);
		p25Zone1.add(p25Zone1DeactivatedRadio);
		p25Zone1.add(p25Zone1UnassignedRadio);
		p25Zone2.add(p25Zone2ActivatedRadio);
		p25Zone2.add(p25Zone2DeactivatedRadio);
		p25Zone2.add(p25Zone2UnassignedRadio);
		p25Zone3.add(p25Zone3ActivatedRadio);
		p25Zone3.add(p25Zone3DeactivatedRadio);
		p25Zone3.add(p25Zone3UnassignedRadio);

		return "{\"datasets\":{\"p25Zone1\":" + p25Zone1.toString()
				+ ",\"p25Zone2\":" + p25Zone2.toString() + ",\"p25Zone3\":"
				+ p25Zone3.toString() + "}}";
	}

	public String getJSONAllUsage() {
		HashMap entityHashMap = new HashMap();
		EntityForm entityForm = new EntityForm();
		entityForm.getListEntityForm();
		String lable = "[";
		String analogRadio = "[";
		String digitalRadio = "[";
		String p25Radio = "[";
		int count=0;
		for (Entity entity : entityForm.getEntities()) {
			entityHashMap.put(entity.getEntity_name(), entity);
		}
		for (RadioUsage radioUsage : allRadioUsages) {
			// System.out.println(radioUsage.getEntity_name());
			if (entityHashMap.containsKey(radioUsage.getEntity_name())) {
				Entity entity = (Entity) entityHashMap.get(radioUsage
						.getEntity_name());
				switch (radioUsage.getRadio_modulation_type_id()) {
				case 1:
					entity.setAnalogRadioNo(entity.getAnalogRadioNo()
							+ radioUsage.getUsed_radio());
					break;
				case 2:
					entity.setDigitalRadioNo(entity.getDigitalRadioNo()
							+ radioUsage.getUsed_radio());
					break;
				case 3:
					entity.setP25RadioNo(entity.getP25RadioNo()
							+ radioUsage.getUsed_radio());
					break;
				}
				entityHashMap.put(entity.getEntity_name(), entity);
			}
		}

		for (Object value : entityHashMap.values()) {
			Entity entity = (Entity) value;
			// System.out.println(entity.getAnalogRadioNo()+" "+entity.getDigitalRadioNo()+" "+entity.getP25RadioNo());
			lable += "\"" + entity.getEntity_name() + "\",";
			analogRadio += entity.getAnalogRadioNo() + ",";
			digitalRadio += entity.getDigitalRadioNo() + ",";
			p25Radio += entity.getP25RadioNo() + ",";
			//count++;
			//if(count>5) break;
		}
		
		lable = lable.substring(0, lable.length() - 1) + "]";
		analogRadio = analogRadio.substring(0, analogRadio.length() - 1) + "]";
		digitalRadio = digitalRadio.substring(0, digitalRadio.length() - 1)
				+ "]";
		p25Radio = p25Radio.substring(0, p25Radio.length() - 1) + "]";
		return "{\"datasets\":{\"lable\":" + lable + ",\"analogRadios\":"
				+ analogRadio + ",\"digitalRadios\":" + digitalRadio
				+ ",\"p25Radios\":" + p25Radio + "}}";
	}
}
