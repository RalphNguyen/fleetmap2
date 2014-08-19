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

import motorolasolutions.com.DataObject.ExportSearchInput;
import motorolasolutions.com.DataObject.UCMExport;

public class UCMExportDAOSearch implements DBSearchDAO {
	private Connection connection;
	private Statement statement;

	public UCMExportDAOSearch() {

	}

	// return a list of UCMExport according to a input search object
	@Override
	public Collection selectObjectList(Object obj) {
		List<UCMExport> ucmExports = new ArrayList<UCMExport>();
		ExportSearchInput exportSearchInput = (ExportSearchInput) obj;
		String startDate = exportSearchInput.getStartDate() + " 00:00:00";
		String endDate = exportSearchInput.getEndDate() + " 23:59:59";
		String query = "SELECT * FROM ucm_configuration AS t1 INNER JOIN "
				+ "entity as t2 ON t1.security_group_id=t2.security_group_id INNER JOIN "
				+ "radio as t3 ON t1.radio_id = t3.radio_id WHERE ";
		if (exportSearchInput.isSearchByIdIssuedDate()) {
			query+="t1.id_issued_date>='"+startDate+"' AND t1.id_issued_date<='"+endDate+"' ";
		}
		else{
			query+="t1.id_issued_date>='1900/01/01'";
		}
		if(exportSearchInput.isSearchByEntity()){
			query+="AND t2.entity_name=\""+exportSearchInput.getEntity_name()+"\" ";
		}
		if(exportSearchInput.isSearchByRadioId()){
			query+="AND t1.radio_id="+exportSearchInput.getRadio_id()+" ";
		}
		if(exportSearchInput.isSearchByRadioSerialNumber()){
			query+="AND t1.radio_serial_number='"+exportSearchInput.getRadio_serial_number()+"' ";
		}
		if(exportSearchInput.isSearchByStatus()){
			query+="AND t1.activation_status='"+exportSearchInput.getActivation_status()+"' ";
		}
		if(exportSearchInput.isSearchByZoneId()){
			query+="AND t3.zone_id="+exportSearchInput.getZone_id()+" ";
		}
		// String query =
		// "SELECT * FROM ucm_configuration WHERE id_issued_date>='"+startDate+"' AND id_issued_date<='"+endDate+"'";
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				UCMExport ucmExport = new UCMExport();
				ucmExport.setUcm_id(rs.getInt("ucm_id"));
				ucmExport.setRadio_user_data_type(rs
						.getString("radio_user_data_type"));
				ucmExport.setActivation_status(rs
						.getString("activation_status"));
				ucmExport.setRadio_id(rs.getInt("radio_id"));
				ucmExport.setRadio_serial_number(rs
						.getString("radio_serial_number"));
				ucmExport.setRadio_user_alias(rs.getString("radio_user_alias"));
				ucmExport.setVoice_enabled(rs.getString("voice_enabled"));
				ucmExport.setInterconnect_enabled(rs
						.getString("interconnect_enabled"));
				ucmExport.setEmergency_alarm_comments(rs
						.getString("emergency_alarm_comments"));
				ucmExport.setSecure_comms_mode(rs
						.getString("secure_comms_mode"));
				ucmExport.setData_capabilities(rs
						.getString("data_capabilities"));
				ucmExport.setDirect_dial_number(rs
						.getString("direct_dial_number"));
				ucmExport.setSecure_land_to_mobile_start_mode(rs
						.getString("secure_land_to_mobile_start_mode"));
				ucmExport.setInterconnect_secure_key_reference(rs
						.getString("interconnect_secure_key_reference"));
				ucmExport.setIp_address_assignment(rs
						.getString("ip_address_assignment"));
				ucmExport.setIp_address(rs.getString("ip_address"));
				ucmExport.setGenerate_icmp_message(rs
						.getString("generate_icmp_message"));
				ucmExport.setSource_address_checking(rs
						.getString("source_address_checking"));
				ucmExport.setReady_timer(rs.getInt("ready_timer"));
				ucmExport.setData_agency_group(rs
						.getString("data_agency_group"));
				ucmExport.setNotes(rs.getString("notes"));
				ucmExport.setId_issued_date(rs.getString("id_issued_date"));
				ucmExport.setDate_modified(rs.getString("date_modified"));
				ucmExport.setUcp(rs.getString("ucp"));
				ucmExport.setSoft_id(rs.getString("soft_id"));
				ucmExport.setRadio_type(rs.getString("radio_type"));
				ucmExport.setSecurity_group_id(rs.getInt("security_group_id"));
				ucmExport.setRadio_site_access_profile_id(rs
						.getInt("radio_site_access_profile_id"));
				ucmExport.setRemedy_id(rs.getString("remedy_id"));
				ucmExport.setRadio_user_interconnect_profile_id(rs
						.getInt("radio_user_interconnect_profile_id"));
				ucmExport.setBackup_core_access_point_name_id(rs
						.getInt("backup_core_access_point_name_id"));
				ucmExport.setPrimary_core_access_point_name_id(rs
						.getInt("primary_core_access_point_name_id"));
				ucmExports.add(ucmExport);
			}
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			DbUtil.close(rs);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return ucmExports;
	}

}
