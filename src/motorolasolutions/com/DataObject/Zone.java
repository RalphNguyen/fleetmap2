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
	
	public Zone(){
		
	}
	public Zone(int zone_id){
		this.zone_id = zone_id;
	}

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

}
