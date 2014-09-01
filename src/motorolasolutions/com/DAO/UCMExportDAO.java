package motorolasolutions.com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import motorolasolutions.com.DataObject.UCMExport;

public class UCMExportDAO implements DBManipulationDAO {
	private Connection connection;
	private Statement statement;

	@Override
	public int insertObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean findObject(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	// get information to export as a csv file
	@Override
	public Object selectObject(Object obj) {
		return null;
	}

	@Override
	public Collection selectObjectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection searchObjectList(String type, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCSVObject(Object obj) {
		UCMExport ucmExport = (UCMExport) obj;
		String query = "SELECT * FROM ucm_configuration as t1 "
				+ "inner join radio as t2 on t1.radio_id=t2.radio_id "
				+ "inner join zone as t3 on t2.zone_id=t3.zone_id "
				+ "inner join security_group as t4 on t1.security_group_id=t4.security_group_id "
				+ "inner join talkgroup as t5 on t4.talkgroup_id=t5.talkgroup_id "
				+ "inner join radio_capabilities_mapping as t6 on t1.security_group_id=t6.security_group_id AND t1.radio_type=t6.radio_type "
				+ "where t1.ucm_id=" + ucmExport.getUcm_id();
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				ucmExport.setTalkgroup_alias(rs.getString("talkgroup_alias"));
				ucmExport.setInterconnect_subsystem(rs
						.getString("interconnect_subsystem"));
				ucmExport.setRadio_capabilities_profile_id(rs
						.getString("radio_capabilities_profile_id"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return obj;
	}

}
