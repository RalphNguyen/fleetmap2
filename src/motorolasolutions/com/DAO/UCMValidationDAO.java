/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

import motorolasolutions.com.DataObject.UCMConfiguration;
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
public class UCMValidationDAO implements DBValidationDAO {
	private Connection connection;
	private Statement statement;

	// check radio serial number duplicate, return 0 if both radio serial number
	// and activation status is duplicate
	@Override
	public int checkDuplicate(Object obj) {
		int flag = 0;
		UCMConfiguration ucm_conf = (UCMConfiguration) obj;
		// System.out.println(remedy.getRemedy_id()+remedy.getRequest_no());
		String query = "SELECT radio_id,activation_status FROM ucm_configuration "
				+ "WHERE ucm_id!="
				+ ucm_conf.getUcm_id()
				+ " AND radio_serial_number='"
				+ ucm_conf.getRadio_serial_number()
				+ "'"
				+ " ORDER BY id_issued_date,ucm_id DESC";
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				flag = rs.getInt("radio_id");
				String status = rs.getString("activation_status");
				if (status.equals("Deregistered")) {
					flag = 0;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return flag;
	}

	// check radio user alias duplicate
	@Override
	public int checkDuplicate2(Object obj) {
		int flag = 0;
		UCMConfiguration ucm_conf = (UCMConfiguration) obj;
		// System.out.println(remedy.getRemedy_id()+remedy.getRequest_no());
		String query = "SELECT * FROM ucm_configuration WHERE ucm_id!="
				+ ucm_conf.getUcm_id() + " AND radio_user_alias='"
				+ ucm_conf.getRadio_user_alias() + "'";
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				flag = 1;
			}
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return flag;
	}

	// to get an available radio id, return 0 if there is no radio ID
	@Override
	public int checkDuplicate3(Object obj) {
		int flag = 0;
		int start_id = 0;
		int end_id = 0;
		ResultSet rs;
		String query = "";
		UCMConfiguration ucm_conf = (UCMConfiguration) obj;
		// System.out.println(remedy.getRemedy_id()+remedy.getRequest_no());

		// get start and end id of the possible range according to radio
		// modulation type: digital, analog or P25
		switch (ucm_conf.getRadio_modulation_type_id()) {
		case 3:
			// get a P25 radio ID
			query = "SELECT t2.entity_id AS entity_id,t2.entity_name AS entity_name,\n"
					+ "t3.agency_name AS agency_name, t4.start_id AS start_id, t4.end_id AS end_id, t4.zone_id AS zone_id\n"
					+ "FROM (security_group AS t1 INNER JOIN entity AS t2 ON t1.security_group_id = t2.security_group_id) \n"
					+ "INNER JOIN agency AS t3 ON t2.agency_id=t3.agency_id INNER JOIN p25_id_constraint AS t4 ON t3.agency_id=t4.agency_id\n"
					+ "WHERE entity_id="
					+ ucm_conf.getEntity_id()
					+ " AND zone_id=" + ucm_conf.getZone_id();
			rs = null;
			// System.out.println(query);
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				rs = statement.executeQuery(query);
				if (rs.next()) {
					start_id = rs.getInt("start_id");
					end_id = rs.getInt("end_id");
					flag = start_id;
				} else {
					flag = 0;
				}
			} catch (SQLException ex) {
				Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			} finally {
				DbUtil.close(rs);
				DbUtil.close(statement);
				DbUtil.close(connection);
			}

			// get available id
			query = "SELECT MIN(radio_id) AS radio_id FROM radio WHERE radio_id>="
					+ start_id
					+ " AND radio_id<="
					+ end_id
					+ " AND used_flag!='Yes' AND used_flag!='No'";
			rs = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				rs = statement.executeQuery(query);
				if (rs.next()) {
					flag = rs.getInt("radio_id");
				} else {
					flag = 0;
				}
			} catch (SQLException ex) {
				Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			} finally {
				DbUtil.close(rs);
				DbUtil.close(statement);
				DbUtil.close(connection);
			}
			break;
		default:
			// get a SmartZone radio ID
			query = "SELECT MIN(radio_id) AS radio_id FROM radio WHERE radio_modulation_type_id ="
					+ ucm_conf.getRadio_modulation_type_id()
					+ " AND zone_id ="
					+ ucm_conf.getZone_id()
					+ " AND used_flag!='Yes' AND used_flag!='No'";
			rs = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				rs = statement.executeQuery(query);
				if (rs.next()) {
					flag = rs.getInt("radio_id");
				} else {
					flag = 0;
				}
			} catch (SQLException ex) {
				Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			} finally {
				DbUtil.close(rs);
				DbUtil.close(statement);
				DbUtil.close(connection);
			}
			break;
		}
		return flag;
	}
}
