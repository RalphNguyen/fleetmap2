/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

import motorolasolutions.com.DataObject.RemedyExport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djfp43
 */
public class RemedyExportDAO implements DBManipulationDAO {
    private Connection connection;
    private Statement statement; 

    // insert a new object to remedy Export table
    @Override
    public int insertObject(Object obj) {
        int flag=0;
        RemedyExport remedyExport = (RemedyExport)obj;
        ResultSet rs = null;
        
        // insert new record to remedyExport
        String query = "INSERT INTO remedy_export VALUES "+remedyExport;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            flag = statement.executeUpdate(query);
            //System.out.println("Insert one record to Remedy Export table: "+remedyExport);
        } catch (SQLException ex) {
            Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }       
        return flag; 
    }

    @Override
    public boolean findObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object selectObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectObjectList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public Collection searchObjectList(String type, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCSVObject(Object obj) {
		RemedyExport remedyExport = (RemedyExport)obj;
        ResultSet rs = null;
        String query = "SELECT * FROM ucm_configuration AS t1 "
        		+ "INNER JOIN remedy_export AS t2 ON t1.ucm_id=t2.ucm_id "
        		+ "INNER JOIN radio AS t3 ON t1.radio_id=t3.radio_id "
        		+ "INNER JOIN security_group as t4 on t4.security_group_id=t1.security_group_id "
        		+ "INNER JOIN entity AS t5 on t5.security_group_id=t4.security_group_id "
        		+ "WHERE t2.ci_id=\""+remedyExport.getCi_id()+"\"";
        //System.out.println(query);
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
			rs = statement.executeQuery(query);
            if(rs.next()){
            	remedyExport.setEntity_name(rs.getString("entity_name"));
            	remedyExport.setRadio_serial_number(rs.getString("radio_serial_number"));
            	remedyExport.setRadio_id(rs.getInt("radio_id"));
            	remedyExport.setRadio_user_alias(rs.getString("radio_user_alias"));
            	remedyExport.setUcp(rs.getString("ucp"));
            	remedyExport.setActivation_status(rs.getString("activation_status"));
            	remedyExport.setRadio_type(rs.getString("radio_type"));
            	remedyExport.setSecurity_group(rs.getString("security_group"));
            	remedyExport.setInterconnect_enabled(rs.getString("interconnect_enabled"));
            	remedyExport.setZone_id(rs.getInt("zone_id"));
            	remedyExport.setSoft_id(rs.getString("soft_id"));    
            	remedyExport.setRemedy_id(rs.getString("remedy_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.close(statement);
            DbUtil.close(connection);            
        } 
        //System.out.println("test: "+ remedyExport.toString());
        return remedyExport;
	}
    
}
