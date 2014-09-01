/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DataObject;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;

/**
 *
 * @author djfp43
 */
public class Entity {
    private int entity_id;
    private String entity_name;
    private String description;
    private int security_group_id;
    private int agency_id;
    private int analogRadioNo;
    private int digitalRadioNo;
    private int p25RadioNo;
    
    public int getAnalogRadioNo() {
		return analogRadioNo;
	}

	public void setAnalogRadioNo(int analogRadioNo) {
		this.analogRadioNo = analogRadioNo;
	}

	public int getDigitalRadioNo() {
		return digitalRadioNo;
	}

	public void setDigitalRadioNo(int digitalRadioNo) {
		this.digitalRadioNo = digitalRadioNo;
	}

	public int getP25RadioNo() {
		return p25RadioNo;
	}

	public void setP25RadioNo(int p25RadioNo) {
		this.p25RadioNo = p25RadioNo;
	}

	public Entity(){
    }
    
    public Entity(String entity_name){
        this.entity_name = entity_name;
        getEntity();
    }
    public int getEntity_id() {
        return entity_id;
    }

    public String getEntity_name() {
        return entity_name;
    }

    public String getDescription() {
        return description;
    }

    public int getSecurity_group_id() {
        return security_group_id;
    }

    public int getAgency_id() {
        return agency_id;
    }

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSecurity_group_id(int security_group_id) {
        this.security_group_id = security_group_id;
    }

    public void setAgency_id(int agency_id) {
        this.agency_id = agency_id;
    }
    
    // to get entity information from database by entity name
    private void getEntity(){
        DAOFactory entityDAOFactory = DAOFactory.getDAOFactory(DAOFactory.ENTITY);
        DBManipulationDAO dBManipulationDAO = entityDAOFactory.getDBManipulationDAO();
        Entity temp = (Entity) dBManipulationDAO.selectObject(this);
        this.entity_id = temp.getEntity_id();
        this.entity_name = temp.getEntity_name();
        this.agency_id = temp.agency_id;
        this.description = temp.getDescription();
        this.security_group_id = temp.getSecurity_group_id();
    }
    
    @Override
    public String toString(){
        String s;
        s= "("+entity_id+",'"+entity_name+"','"+description+"',"+security_group_id+","+agency_id+")";
        return s;
    }
    
    // return a string of entity export
    public String getCSV(){
    	return entity_id + ","+entity_name +"," +analogRadioNo+"," + digitalRadioNo+"," + p25RadioNo;
    }
    
}
