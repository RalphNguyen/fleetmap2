/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

import motorolasolutions.com.DataObject.Entity;
import motorolasolutions.com.DataObject.Remedy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djfp43
 */
public class RemedyValidationDAO implements DBValidationDAO{
    private Connection connection;
    private Statement statement;  
    
    @Override
    public int checkDuplicate(Object obj) {
        int flag = 0;
        Remedy remedy = (Remedy)obj;
        //System.out.println(remedy.getRemedy_id()+remedy.getRequest_no());
        String query = "SELECT * FROM remedy where remedy_id='"+remedy.getRemedy_id()+"'";
        ResultSet rs = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next()){
                flag = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }
        return flag;
    }

    @Override
    public int checkDuplicate2(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int checkDuplicate3(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public int checkDuplicate4(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
}
