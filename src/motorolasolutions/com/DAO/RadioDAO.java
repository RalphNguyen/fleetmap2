/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

import motorolasolutions.com.DataObject.Radio;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djfp43
 */
public class RadioDAO implements DBManipulationDAO{
    private Connection connection;
    private Statement statement; 

    @Override
    public boolean findObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectObjectList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertObject(Object obj) { 
        return 0;
    }

    @Override
    public Object selectObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //update used_flag to the radio table
    @Override
    public int updateObject(Object obj) {
        int flag = 0;
        Radio radio =(Radio)obj;
        String query = "UPDATE radio SET used_flag='"+radio.getUsed_flag()+"', radio_modulation_type_id="+
                radio.getRadio_modulation_type()+", zone_id="+radio.getZone_id()+" where radio_id="+radio.getRadio_id();
        //System.out.println(query);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            flag = statement.executeUpdate(query);
            System.out.println("Update radio used_flag = Yes with id = "+radio.getRadio_id()+" to the Database");
        } catch (SQLException ex) {
            Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }
        return flag;
    }

    // mark radio used_flag as 'No' when the radio is deregistered
    @Override
    public int deleteObject(Object obj) {
        int flag = 0;
        Radio radio = (Radio)obj;
        String query = "UPDATE radio SET used_flag='No' WHERE radio_id="+radio.getRadio_id();
        //System.out.println(query);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            flag = statement.executeUpdate(query);
            System.out.println("Update radio used_flag = No with id = "+radio.getRadio_id()+" to the Database");
        } catch (SQLException ex) {
            Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }
        return flag;
    }

	@Override
	public Collection searchObjectList(String type, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
