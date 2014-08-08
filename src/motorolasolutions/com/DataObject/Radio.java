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
public class Radio implements UpdateData{
    int radio_id;
    String used_flag;
    int radio_modulation_type;
    int zone_id;

    public int getRadio_id() {
        return radio_id;
    }

    public String getUsed_flag() {
        return used_flag;
    }

    public int getRadio_modulation_type() {
        return radio_modulation_type;
    }

    public int getZone_id() {
        return zone_id;
    }
    
    public Radio(int radio_id){
        this.radio_id = radio_id;
    }
    
    public Radio(int radio_id, String used_flag, int radio_modulation_type, int zone_id){
        this.radio_id = radio_id;
        this.used_flag = used_flag;
        this.radio_modulation_type = radio_modulation_type;
        this.zone_id = zone_id;
    }
    
    @Override
    public String toString(){
        String s;
        s = "("+radio_id+",'"+used_flag+"',"+radio_modulation_type+","+zone_id+")";
        return s;
    }

    @Override
    public int insertToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateToDatabase() {
        DAOFactory radioDAOFactory = DAOFactory.getDAOFactory(DAOFactory.RADIO);
        DBManipulationDAO dBManipulationDAO = radioDAOFactory.getDBManipulationDAO();
        return(dBManipulationDAO.updateObject(this));
    }

    @Override
    public int removeFromDatabase() {
        DAOFactory radioDAOFactory = DAOFactory.getDAOFactory(DAOFactory.RADIO);
        DBManipulationDAO dBManipulationDAO = radioDAOFactory.getDBManipulationDAO();
        return(dBManipulationDAO.deleteObject(this));
    }
}
