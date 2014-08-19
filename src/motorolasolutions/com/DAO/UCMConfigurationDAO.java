/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.UCMUpdateSearchInput;

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
public class UCMConfigurationDAO implements DBManipulationDAO {
	private Connection connection;
	private Statement statement;

	@Override
	public boolean findObject(Object obj) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Collection selectObjectList() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int insertObject(Object obj) {
		int ucm_id = 0;
		UCMConfiguration ucm_conf = (UCMConfiguration) obj;
		// get the ucm_id to insert to the databse
		String query = "SELECT max(ucm_id) as ucm_id FROM ucm_configuration";
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				ucm_id = rs.getInt("ucm_id") + 1;
			} else {
				ucm_id = 1;
			}
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}

		ucm_conf.setUcm_id(ucm_id);
		// insert new record to ucm_configuration
		query = "INSERT INTO ucm_configuration VALUES " + ucm_conf;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("insert one record to UCM_Configuration table");
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		// return ucm_id
		return ucm_id;
	}

	// search for an object of UCM configuration, return null if there is no
	// return
	@Override
	public Object selectObject(Object obj) {
		UCMConfiguration ucm_conf = (UCMConfiguration) obj;
		// get the ucm_id to insert to the databse
		String query = "SELECT * FROM ucm_configuration AS t1 INNER JOIN radio AS t2 "
				+ "ON t1.radio_id=t2.radio_id WHERE t1.radio_serial_number='"
				+ ucm_conf.getRadio_serial_number()
				+ "' OR t1.radio_user_alias='"
				+ ucm_conf.getRadio_user_alias()
				+ "' OR t1.radio_id="
				+ ucm_conf.getRadio_id()
				+ " ORDER BY t1.id_issued_date,t1.ucm_id DESC";
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				ucm_conf.setUcm_id(rs.getInt("ucm_id"));
				ucm_conf.setRadio_user_data_type(rs
						.getString("radio_user_data_type"));
				ucm_conf.setActivation_status(rs.getString("activation_status"));
				ucm_conf.setRadio_id(rs.getInt("radio_id"));
				ucm_conf.setRadio_serial_number(rs
						.getString("radio_serial_number"));
				ucm_conf.setRadio_user_alias(rs.getString("radio_user_alias"));
				ucm_conf.setVoice_enabled(rs.getString("voice_enabled"));
				ucm_conf.setInterconnect_enabled(rs
						.getString("interconnect_enabled"));
				ucm_conf.setEmergency_alarm_comments(rs
						.getString("emergency_alarm_comments"));
				ucm_conf.setSecure_comms_mode(rs.getString("secure_comms_mode"));
				ucm_conf.setData_capabilities(rs.getString("data_capabilities"));
				ucm_conf.setDirect_dial_number(rs
						.getString("direct_dial_number"));
				ucm_conf.setSecure_land_to_mobile_start_mode(rs
						.getString("secure_land_to_mobile_start_mode"));
				ucm_conf.setInterconnect_secure_key_reference(rs
						.getString("interconnect_secure_key_reference"));
				ucm_conf.setIp_address_assignment(rs
						.getString("ip_address_assignment"));
				ucm_conf.setIp_address(rs.getString("ip_address"));
				ucm_conf.setGenerate_icmp_message(rs
						.getString("generate_icmp_message"));
				ucm_conf.setSource_address_checking(rs
						.getString("source_address_checking"));
				ucm_conf.setReady_timer(rs.getInt("ready_timer"));
				ucm_conf.setData_agency_group(rs.getString("data_agency_group"));
				ucm_conf.setNotes(rs.getString("notes"));
				ucm_conf.setId_issued_date(rs.getString("id_issued_date"));
				ucm_conf.setDate_modified(rs.getString("date_modified"));
				ucm_conf.setUcp(rs.getString("ucp"));
				ucm_conf.setSoft_id(rs.getString("soft_id"));
				ucm_conf.setRadio_type(rs.getString("radio_type"));
				ucm_conf.setSecurity_group_id(rs.getInt("security_group_id"));
				ucm_conf.setRadio_site_access_profile_id(rs
						.getInt("radio_site_access_profile_id"));
				ucm_conf.setRemedy_id(rs.getString("remedy_id"));
				ucm_conf.setRadio_user_interconnect_profile_id(rs
						.getInt("radio_user_interconnect_profile_id"));
				ucm_conf.setBackup_core_access_point_name_id(rs
						.getInt("backup_core_access_point_name_id"));
				ucm_conf.setPrimary_core_access_point_name_id(rs
						.getInt("primary_core_access_point_name_id"));
				ucm_conf.setRadio_modulation_type_id(rs
						.getInt("radio_modulation_type_id"));
				ucm_conf.setZone_id(rs.getInt("zone_id"));
			} else {
				// ucm_conf = null;
			}
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return ucm_conf;
	}

	// update UCM to the database
	@Override
	public int updateObject(Object obj) {
		int flag = 0;
		UCMConfiguration ucm_conf = (UCMConfiguration) obj;
		String query = "UPDATE ucm_configuration SET activation_status='"
				+ ucm_conf.getActivation_status() + "',radio_serial_number='"
				+ ucm_conf.getRadio_serial_number() + "',radio_user_alias='"
				+ ucm_conf.getRadio_user_alias() + "',ucp='"
				+ ucm_conf.getUcp() + "',date_modified='"
				+ ucm_conf.getDate_modified() + "',security_group_id="
				+ ucm_conf.getSecurity_group_id() + ",radio_type='"
				+ ucm_conf.getRadio_type() + "' " + " WHERE ucm_id="
				+ ucm_conf.getUcm_id();
		// System.out.println(query);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			flag = statement.executeUpdate(query);
			System.out.println("Update UCM with id = " + ucm_conf.getUcm_id()
					+ " to the Database");
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return flag;
	}

	@Override
	public int deleteObject(Object obj) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	// get a list of ucm_configuration from an input object
	@Override
	public Collection searchObjectList(String type, Object obj) {
		List<UCMConfiguration> ucmConfList = new ArrayList<UCMConfiguration>();
		String query = "SELECT * FROM ucm_configuration AS t1 INNER JOIN "
				+ "entity as t2 ON t1.security_group_id=t2.security_group_id INNER JOIN "
				+ "radio as t3 ON t1.radio_id = t3.radio_id WHERE";

		switch (type) {
		// search UCM to update
		case "searchToUpdate":
			UCMUpdateSearchInput ucmUpdateSearchInput = (UCMUpdateSearchInput) obj;
			if (ucmUpdateSearchInput.isSearchByRadioID()) {
				query += " t1.radio_id=" + ucmUpdateSearchInput.getRadio_id();
			} else {
				query += " t1.radio_id!=0";
			}

			if (ucmUpdateSearchInput.isSearchByRadioSerialNumber()) {
				query += " AND t1.radio_serial_number='"
						+ ucmUpdateSearchInput.getRadio_serial_number() + "'";
			}

			if (ucmUpdateSearchInput.isSearchByRadioUserAlias()) {
				query += " AND t1.radio_user_alias='"
						+ ucmUpdateSearchInput.getRadio_user_alias() + "'";
			}

			query += " ORDER BY t1.id_issued_date,t1.ucm_id DESC";
			break;
		default:
			break;
		}

		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				UCMConfiguration ucm_conf = new UCMConfiguration();
				ucm_conf.setUcm_id(rs.getInt("ucm_id"));
				ucm_conf.setRadio_user_data_type(rs
						.getString("radio_user_data_type"));
				ucm_conf.setActivation_status(rs.getString("activation_status"));
				ucm_conf.setRadio_id(rs.getInt("radio_id"));
				ucm_conf.setRadio_serial_number(rs
						.getString("radio_serial_number"));
				ucm_conf.setRadio_user_alias(rs.getString("radio_user_alias"));
				ucm_conf.setVoice_enabled(rs.getString("voice_enabled"));
				ucm_conf.setInterconnect_enabled(rs
						.getString("interconnect_enabled"));
				ucm_conf.setEmergency_alarm_comments(rs
						.getString("emergency_alarm_comments"));
				ucm_conf.setSecure_comms_mode(rs.getString("secure_comms_mode"));
				ucm_conf.setData_capabilities(rs.getString("data_capabilities"));
				ucm_conf.setDirect_dial_number(rs
						.getString("direct_dial_number"));
				ucm_conf.setSecure_land_to_mobile_start_mode(rs
						.getString("secure_land_to_mobile_start_mode"));
				ucm_conf.setInterconnect_secure_key_reference(rs
						.getString("interconnect_secure_key_reference"));
				ucm_conf.setIp_address_assignment(rs
						.getString("ip_address_assignment"));
				ucm_conf.setIp_address(rs.getString("ip_address"));
				ucm_conf.setGenerate_icmp_message(rs
						.getString("generate_icmp_message"));
				ucm_conf.setSource_address_checking(rs
						.getString("source_address_checking"));
				ucm_conf.setReady_timer(rs.getInt("ready_timer"));
				ucm_conf.setData_agency_group(rs.getString("data_agency_group"));
				ucm_conf.setNotes(rs.getString("notes"));
				ucm_conf.setId_issued_date(rs.getString("id_issued_date"));
				ucm_conf.setDate_modified(rs.getString("date_modified"));
				ucm_conf.setUcp(rs.getString("ucp"));
				ucm_conf.setSoft_id(rs.getString("soft_id"));
				ucm_conf.setRadio_type(rs.getString("radio_type"));
				ucm_conf.setSecurity_group_id(rs.getInt("security_group_id"));
				ucm_conf.setRadio_site_access_profile_id(rs
						.getInt("radio_site_access_profile_id"));
				ucm_conf.setRemedy_id(rs.getString("remedy_id"));
				ucm_conf.setRadio_user_interconnect_profile_id(rs
						.getInt("radio_user_interconnect_profile_id"));
				ucm_conf.setBackup_core_access_point_name_id(rs
						.getInt("backup_core_access_point_name_id"));
				ucm_conf.setPrimary_core_access_point_name_id(rs
						.getInt("primary_core_access_point_name_id"));
				ucm_conf.setZone_id(rs.getInt("zone_id"));
				ucmConfList.add(ucm_conf);
			}
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return ucmConfList;
	}

}
