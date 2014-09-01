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
	private ZoneForm zoneForm;

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

	public List<RadioUsage> getSmartZoneRadioUsages() {
		return smartZoneRadioUsages;
	}

	public void setSmartZoneRadioUsages(List<RadioUsage> smartZoneRadioUsages) {
		this.smartZoneRadioUsages = smartZoneRadioUsages;
	}

	public ZoneForm getZoneForm() {
		return zoneForm;
	}

	public void setZoneForm(ZoneForm zoneForm) {
		this.zoneForm = zoneForm;
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

	// get the radio usage of smartZone & p25
	public ZoneForm getSmartZoneP25RadioUsage() throws SQLException {
		getSmartZoneRadioUsageList();
		getP25RadioUsageList();
		ZoneForm zoneForm = new ZoneForm();
		List<Zone> zones = new ArrayList();
		
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
		
		Zone zone = new Zone();
		zone.setZone_name("SmartZone 1");
		zone.setActivatedRadios(smartZone1ActivatedRadio);
		zone.setDeactivatedRadios(smartZone1DeactivatedRadio);
		zone.setUnassignedRadios(smartZone1UnassignedRadio);
		zones.add(zone);
		
		Zone zone1 = new Zone();
		zone1.setZone_name("SmartZone 2");
		zone1.setActivatedRadios(smartZone2ActivatedRadio);
		zone1.setDeactivatedRadios(smartZone2DeactivatedRadio);
		zone1.setUnassignedRadios(smartZone2UnassignedRadio);
		zones.add(zone1);
		
		Zone zone2 = new Zone();
		zone2.setZone_name("SmartZone 3");
		zone2.setActivatedRadios(smartZone3ActivatedRadio);
		zone2.setDeactivatedRadios(smartZone3DeactivatedRadio);
		zone2.setUnassignedRadios(smartZone3UnassignedRadio);
		zones.add(zone2);
		
		Zone zone3 = new Zone();
		zone3.setZone_name("SmartZone 1/ Analog");
		zone3.setActivatedRadios(smartZoneYes.get(0));
		zone3.setDeactivatedRadios(smartZoneNo.get(0));
		zone3.setUnassignedRadios(smartZoneNever.get(0));
		zones.add(zone3);
		
		Zone zone4 = new Zone();
		zone4.setZone_name("SmartZone 2/ Analog");
		zone4.setActivatedRadios(smartZoneYes.get(1));
		zone4.setDeactivatedRadios(smartZoneNo.get(1));
		zone4.setUnassignedRadios(smartZoneNever.get(1));
		zones.add(zone4);
		
		Zone zone5 = new Zone();
		zone5.setZone_name("SmartZone 3/ Analog");
		zone5.setActivatedRadios(smartZoneYes.get(2));
		zone5.setDeactivatedRadios(smartZoneNo.get(2));
		zone5.setUnassignedRadios(smartZoneNever.get(2));
		zones.add(zone5);
		
		Zone zone6 = new Zone();
		zone6.setZone_name("SmartZone 1/ Digital");
		zone6.setActivatedRadios(smartZoneYes.get(3));
		zone6.setDeactivatedRadios(smartZoneNo.get(3));
		zone6.setUnassignedRadios(smartZoneNever.get(3));
		zones.add(zone6);
		
		Zone zone7 = new Zone();
		zone7.setZone_name("SmartZone 2/ Digital");
		zone7.setActivatedRadios(smartZoneYes.get(4));
		zone7.setDeactivatedRadios(smartZoneNo.get(4));
		zone7.setUnassignedRadios(smartZoneNever.get(4));
		zones.add(zone7);
		
		Zone zone8 = new Zone();
		zone8.setZone_name("SmartZone 3/ Digital");
		zone8.setActivatedRadios(smartZoneYes.get(5));
		zone8.setDeactivatedRadios(smartZoneNo.get(5));
		zone8.setUnassignedRadios(smartZoneNever.get(5));
		zones.add(zone8);
		
		
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
		
		Zone zone9 = new Zone();
		zone9.setZone_name("P25 Zone 1");
		zone9.setActivatedRadios(p25Zone1ActivatedRadio);
		zone9.setDeactivatedRadios(p25Zone1DeactivatedRadio);
		zone9.setUnassignedRadios(p25Zone1UnassignedRadio);
		zones.add(zone9);
		
		Zone zone10 = new Zone();
		zone10.setZone_name("P25 Zone 2");
		zone10.setActivatedRadios(p25Zone2ActivatedRadio);
		zone10.setDeactivatedRadios(p25Zone2DeactivatedRadio);
		zone10.setUnassignedRadios(p25Zone2UnassignedRadio);
		zones.add(zone10);
		
		Zone zone11 = new Zone();
		zone11.setZone_name("P25 Zone 3");
		zone11.setActivatedRadios(p25Zone3ActivatedRadio);
		zone11.setDeactivatedRadios(p25Zone3DeactivatedRadio);
		zone11.setUnassignedRadios(p25Zone3UnassignedRadio);
		zones.add(zone11);;
		
		zoneForm.setZones(zones);
		this.zoneForm = zoneForm;
		return zoneForm;
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

	// get the summary of Entity Radio Usage
	public EntityForm getEntityRadioUsage() {
		List<Entity> entities = new ArrayList<Entity>();
		HashMap<String, Entity> entityHashMap = new HashMap<String, Entity>();
		EntityForm entityForm = new EntityForm();
		entityForm.getListEntityForm();
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
			entities.add(entity);
		}
		entityForm.setEntities(entities);
		return entityForm;
	}

	// get a JSON string to draw a chart of Entity Radio Usage Summary
	public String getJSONAllUsage() {
		EntityForm entityForm = getEntityRadioUsage();
		String lable = "[";
		String analogRadio = "[";
		String digitalRadio = "[";
		String p25Radio = "[";

		for (Entity entity : entityForm.getEntities()) {
			lable += "\"" + entity.getEntity_name() + "\",";
			analogRadio += entity.getAnalogRadioNo() + ",";
			digitalRadio += entity.getDigitalRadioNo() + ",";
			p25Radio += entity.getP25RadioNo() + ",";
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
