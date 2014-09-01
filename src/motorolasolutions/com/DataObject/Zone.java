/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DataObject;

/**
 *
 * @author djfp43
 */
public class Zone {
	private int zone_id;
	private String zone_name;
	private String zone_description;
	private int activatedRadios;
	private int deactivatedRadios;
	private int unassignedRadios;

	public Zone() {
	}

	public Zone(int zone_id) {
		this.zone_id = zone_id;
	}

	// getters & setters
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

	public String getZone_description() {
		return zone_description;
	}

	public void setZone_description(String zone_description) {
		this.zone_description = zone_description;
	}

	public int getActivatedRadios() {
		return activatedRadios;
	}

	public void setActivatedRadios(int activatedRadios) {
		this.activatedRadios = activatedRadios;
	}

	public int getDeactivatedRadios() {
		return deactivatedRadios;
	}

	public void setDeactivatedRadios(int deactivatedRadios) {
		this.deactivatedRadios = deactivatedRadios;
	}

	public int getUnassignedRadios() {
		return unassignedRadios;
	}

	public void setUnassignedRadios(int unassignedRadios) {
		this.unassignedRadios = unassignedRadios;
	}

	// return a string to export from Dashboard
	public String getCSV() {
		return zone_name + "," + activatedRadios + "," + deactivatedRadios
				+ "," + unassignedRadios;
	}
}
