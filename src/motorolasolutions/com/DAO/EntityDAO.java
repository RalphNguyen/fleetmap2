/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

import motorolasolutions.com.DataObject.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djfp43
 */
public class EntityDAO implements DBManipulationDAO{
    
	private Connection connection;
	private Statement statement;

    public EntityDAO(){
    }

    @Override
    public boolean findObject(Object obj) {
        Entity entity = (Entity)obj;
        System.out.println("test entity id: "+entity.getEntity_id());
        String query = "SELECT * FROM entity where entity_id="+entity.getEntity_id();
        ResultSet rs = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                entity = new Entity();
                entity.setEntity_id(rs.getInt("entity_id"));
                entity.setEntity_name(rs.getString("entity_name"));
                entity.setDescription(rs.getString("description"));
                entity.setSecurity_group_id(rs.getInt("security_group_id"));
                entity.setAgency_id(rs.getInt("agency_id"));
                System.out.println("entity name: "+entity.getEntity_name());
        }
        } catch (SQLException ex) {
        Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally{
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }
    return false;
        
    }

    @Override
    public Collection selectObjectList() {
        List<Entity> entities = new ArrayList<Entity>();
        String query = "SELECT * FROM entity";
        ResultSet rs = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
            	Entity entity= new Entity();
                entity.setEntity_id(rs.getInt("entity_id"));
                entity.setEntity_name(rs.getString("entity_name"));
                entity.setDescription(rs.getString("description"));
                entity.setSecurity_group_id(rs.getInt("security_group_id"));
                entity.setAgency_id(rs.getInt("agency_id"));
                entities.add(entity);
        }
        } catch (SQLException ex) {
        Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }
        return entities;
    }

    @Override
    public int insertObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object selectObject(Object obj) {
        Entity entity = (Entity) obj;
        String query = "SELECT * FROM entity where entity_name=\""+entity.getEntity_name()+"\"";
        ResultSet rs = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next()){
                entity.setEntity_id(rs.getInt("entity_id"));
                entity.setEntity_name(rs.getString("entity_name"));
                entity.setDescription(rs.getString("description"));
                entity.setSecurity_group_id(rs.getInt("security_group_id"));
                entity.setAgency_id(rs.getInt("agency_id"));
        }
        } catch (SQLException ex) {
        Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }
        return entity;
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
