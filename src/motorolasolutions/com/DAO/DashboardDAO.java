package motorolasolutions.com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import motorolasolutions.com.DataObject.RadioUsage;

public class DashboardDAO {
	private Connection connection;
	private Statement statement;

	// get the usage of SmartZone Radio IDs
	public Collection getSmartZoneUsage() throws SQLException {
		List<RadioUsage> radioUsages = new ArrayList<RadioUsage>();
		String query = " select zone_id, radio_modulation_type_id,used_flag,count(radio_id) as used_radio from radio "
				+ "where radio_modulation_type_id!=3 group by zone_id,radio_modulation_type_id,used_flag";
		ResultSet rs = null;
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		rs = statement.executeQuery(query);
		try {
			while (rs.next()) {
				RadioUsage radioUsage = new RadioUsage();
				radioUsage.setZone_id(rs.getInt("zone_id"));
				radioUsage.setRadio_modulation_type_id(rs
						.getInt("radio_modulation_type_id"));
				radioUsage.setUsed_flag(rs.getString("used_flag"));
				radioUsage.setUsed_radio(rs.getInt("used_radio"));
				radioUsages.add(radioUsage);
			}
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return radioUsages;
	}

	// get the usage of P25 Radio IDs
	public Collection getP25Usage() throws SQLException {
		List<RadioUsage> radioUsages = new ArrayList<RadioUsage>();
		String query = "select zone_id, used_flag,count(radio_id) as used_radio from radio where radio_modulation_type_id=3 group by zone_id,used_flag;";
		ResultSet rs = null;
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		rs = statement.executeQuery(query);
		try {
			while (rs.next()) {
				RadioUsage radioUsage = new RadioUsage();
				radioUsage.setZone_id(rs.getInt("zone_id"));
				radioUsage.setRadio_modulation_type_id(3);
				radioUsage.setUsed_flag(rs.getString("used_flag"));
				radioUsage.setUsed_radio(rs.getInt("used_radio"));
				radioUsages.add(radioUsage);
			}
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return radioUsages;
	}

	// get the usage of All Radio IDs
	public Collection getAllUsage() throws SQLException {
		List<RadioUsage> radioUsages = new ArrayList<RadioUsage>();
		String query = "select t1.entity_name, t3.radio_modulation_type_id,count(t2.radio_id) as used_radio from entity as t1 "
				+ " inner join ucm_configuration as t2 on t1.security_group_id=t2.security_group_id"
				+ " inner join radio as t3 on t2.radio_id=t3.radio_id "
				+ "where t3.used_flag='Yes' group by t1.entity_name,t3.radio_modulation_type_id";
		ResultSet rs = null;
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		rs = statement.executeQuery(query);
		try {
			while (rs.next()) {
				RadioUsage radioUsage = new RadioUsage();
				radioUsage.setEntity_name(rs.getString("entity_name"));
				radioUsage.setRadio_modulation_type_id(rs.getInt("radio_modulation_type_id"));
				radioUsage.setUsed_radio(rs.getInt("used_radio"));
				radioUsages.add(radioUsage);
			}
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return radioUsages;
	}
}
