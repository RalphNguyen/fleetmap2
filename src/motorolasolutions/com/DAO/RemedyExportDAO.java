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
            System.out.println("Insert one record to Remedy Export table: "+remedyExport);
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
    
}
