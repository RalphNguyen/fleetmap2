/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorolasolutions.com.DAO;


import motorolasolutions.com.DataObject.Agency;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author djfp43
 */
public class AgencyDAO {
    private Connection connection;
    private Statement statement;
    
    public AgencyDAO(){}
    public ArrayList<Agency> getAgencies() throws SQLException{
        String query = "SELECT * FROM agency;";
        ResultSet rs = null;
        ArrayList <Agency> agList = new ArrayList();
        Agency ag = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                ag = new Agency();
                ag = new Agency();
                ag.setAgency_id(rs.getInt("agency_id"));
                ag.setAgency_name(rs.getString("agency_name"));
                ag.setAgency_description(rs.getString("description"));
                agList.add(ag);
        }
        } finally{
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }
        return agList;
    }
    public Agency getAgency(int agencyId) throws SQLException {
        String query = "SELECT * FROM agency WHERE agency_id=" + agencyId;
        ResultSet rs = null;
        Agency ag = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next()){
                ag = new Agency();
                ag.setAgency_id(rs.getInt("agency_id"));
                ag.setAgency_name(rs.getString("agency_name"));
                ag.setAgency_description(rs.getString("description"));
            }
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return ag;
    }
}
