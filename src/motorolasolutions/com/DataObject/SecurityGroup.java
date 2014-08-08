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
public class SecurityGroup {
    private int security_group_id;
    private String security_group;
    private String notes;
    private int talkgroup_id;
    
    //getter & setter
	public int getSecurity_group_id() {
		return security_group_id;
	}
	public void setSecurity_group_id(int security_group_id) {
		this.security_group_id = security_group_id;
	}
	public String getSecurity_group() {
		return security_group;
	}
	public void setSecurity_group(String security_group) {
		this.security_group = security_group;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getTalkgroup_id() {
		return talkgroup_id;
	}
	public void setTalkgroup_id(int talkgroup_id) {
		this.talkgroup_id = talkgroup_id;
	}
    
}
