/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

import motorolasolutions.com.DataObject.SecurityGroup;

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
public class SecurityGroupDAO implements DBManipulationDAO {

	private Connection connection;
	private Statement statement;

	public SecurityGroupDAO() {
	}

	@Override
	public boolean findObject(Object obj) {
		return false;

	}

	@Override
	public Collection selectObjectList() {
		List<SecurityGroup> securityGroups = new ArrayList<SecurityGroup>();
		String query = "SELECT * FROM security_group";
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				SecurityGroup securityGroup = new SecurityGroup();
				securityGroup.setSecurity_group_id(rs
						.getInt("security_group_id"));
				securityGroup.setSecurity_group(rs.getString("security_group"));
				securityGroup.setNotes(rs.getString("notes"));
				securityGroup.setTalkgroup_id(rs.getInt("talkgroup_id"));
				securityGroups.add(securityGroup);
			}
		} catch (SQLException ex) {
			Logger.getLogger(SecurityGroupDAO.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return securityGroups;
	}

	@Override
	public int insertObject(Object obj) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Object selectObject(Object obj) {
		return null;
	}

	@Override
	public int updateObject(Object obj) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public int deleteObject(Object obj) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

}
