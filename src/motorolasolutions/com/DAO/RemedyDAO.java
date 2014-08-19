/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

import motorolasolutions.com.DataObject.Remedy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djfp43
 */
public class RemedyDAO implements DBManipulationDAO{
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

    // to insert new remedy to the database
    @Override
    public int insertObject(Object obj) {
        int flag = 0;
        Remedy remedy = (Remedy)obj;
        //String query = "INSERT INTO remedy (remedy_id,request_no,sub_entity) VALUES "+remedy;
        String query = "INSERT INTO remedy (remedy_id,request_no,sub_entity) VALUES (?,?,?);";
        //System.out.println(query);
        try{
            connection = ConnectionFactory.getConnection();
            //statement = connection.createStatement();
            //statement.executeUpdate(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,remedy.getRemedy_id());
            preparedStatement.setString(2, remedy.getRequest_no());
            preparedStatement.setString(3, remedy.getSub_entity());
            flag = preparedStatement.executeUpdate();
            System.out.println("insert one record to remedy table");
        } catch (SQLException ex) {
            Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }
        return flag;
    }

    @Override
    public Object selectObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateObject(Object obj) {
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
