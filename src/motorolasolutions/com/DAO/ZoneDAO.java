package motorolasolutions.com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import motorolasolutions.com.DataObject.Entity;
import motorolasolutions.com.DataObject.Zone;

public class ZoneDAO implements DBManipulationDAO {
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

	@Override
	public Object selectObject(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectObjectList() {
		List<Zone> zones = new ArrayList<Zone>();
		String query = "SELECT * FROM zone";
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Zone zone = new Zone();
				zone.setZone_id(rs.getInt("zone_id"));
				zone.setZone_name(rs.getString("zone_name"));
				zone.setZone_description(rs.getString("zone_description"));
				zones.add(zone);
			}
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return zones;
	}

}
