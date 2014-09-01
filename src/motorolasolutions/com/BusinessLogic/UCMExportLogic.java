package motorolasolutions.com.BusinessLogic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motorolasolutions.com.DataObject.Entity;
import motorolasolutions.com.DataObject.EntityForm;
import motorolasolutions.com.DataObject.RemedyExport;
import motorolasolutions.com.DataObject.RemedyExportForm;
import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.UCMConfigurationForm;
import motorolasolutions.com.DataObject.UCMExport;
import motorolasolutions.com.DataObject.UCMExportForm;
import motorolasolutions.com.DataObject.Zone;
import motorolasolutions.com.DataObject.ZoneForm;

public class UCMExportLogic {
	private static final int BUFFER_SIZE = 64096;

	// to create a file of a list of UCM to send back to client
	public static File ucmListFileWriter(String type, Object obj)
			throws IOException {
		File f;
		FileWriter fstream;
		BufferedWriter out;
		String fileName;
		String header;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd.hhmmss");// dd/MM/yyyy
		Date now = new Date();

		switch (type) {
		case "ucmList":
			UCMExportForm ucmExportForm = (UCMExportForm) obj;
			fileName = "UCM." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			header = "radio_id,radio_serial_number,radio_user_alias,security_group_id,radio_capabilities_profile_id,"
					+ "radio_site_access_profile_id,talkgroup_alias,voice_enabled,interconnect_enabled,"
					+ "emergency_alarm_comments,secure_comms_mode,data_capabilities,direct_dial_number,"
					+ "secure_land_to_mobile_start_mode,interconnect_subsystem,radio_user_interconnect_profile_id,"
					+ "interconnect_secure_key_reference,ip_address_assignment,ip_address,generate_icmp_message,"
					+ "source_address_checking,ready_timer,data_agency_group,primary_core_access_point_name_id,"
					+ "backup_core_access_point_name_id,notes,date_modified";
			out.write(header);
			out.newLine();
			for (UCMExport ucmExport : ucmExportForm.getUcmExports()) {
				out.write(ucmExport.getCSV());
				out.newLine();
			}
			out.close();
			break;
		case "ucmListFlaw":
			UCMConfigurationForm ucmConfigurationForm = (UCMConfigurationForm) obj;
			fileName = "UCM." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			header = "radio_id,radio_serial_number,radio_user_alias,security_group_id,radio_capabilities_profile_id,"
					+ "radio_site_access_profile_id,talkgroup_alias,voice_enabled,interconnect_enabled,"
					+ "emergency_alarm_comments,secure_comms_mode,data_capabilities,direct_dial_number,"
					+ "secure_land_to_mobile_start_mode,interconnect_subsystem,radio_user_interconnect_profile_id,"
					+ "interconnect_secure_key_reference,ip_address_assignment,ip_address,generate_icmp_message,"
					+ "source_address_checking,ready_timer,data_agency_group,primary_core_access_point_name_id,"
					+ "backup_core_access_point_name_id,notes,date_modified";
			out.write(header);
			out.newLine();
			for (UCMConfiguration ucm_conf : ucmConfigurationForm
					.getUcmConfigurations()) {
				out.write(ucm_conf.getCSV());
				out.newLine();
			}
			out.close();
			break;
		case "ucm":
			UCMConfiguration ucm_conf = (UCMConfiguration) obj;
			fileName = "UCM." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			header = "radio_id,radio_serial_number,radio_user_alias,security_group_id,radio_capabilities_profile_id,"
					+ "radio_site_access_profile_id,talkgroup_alias,voice_enabled,interconnect_enabled,"
					+ "emergency_alarm_comments,secure_comms_mode,data_capabilities,direct_dial_number,"
					+ "secure_land_to_mobile_start_mode,interconnect_subsystem,radio_user_interconnect_profile_id,"
					+ "interconnect_secure_key_reference,ip_address_assignment,ip_address,generate_icmp_message,"
					+ "source_address_checking,ready_timer,data_agency_group,primary_core_access_point_name_id,"
					+ "backup_core_access_point_name_id,notes,date_modified";
			out.write(header);
			out.newLine();
			out.write(ucm_conf.getCSV());
			out.close();
			break;
		case "remedyList":
			RemedyExportForm remedyExportForm = (RemedyExportForm) obj;
			fileName = "Remedy." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			header = "CI Company,CI ID,CI Name,CI Description,Product Categorization Tier 1,"
					+ "Product Categorization Tier 2,Product Categorization Tier 3,"
					+ "Allocated Company,Allocated Org,Allocated Dept,Serial Number,"
					+ "Radio ID,Code Plug ID,UCS Alias,Additional Information,"
					+ "Warning Message,Status,Status Reason,Radio Type,UCM Security Group,"
					+ "Interconnect,Zone,Soft ID,Logical ID,Data Update Note";
			out.write(header);
			out.newLine();
			for (RemedyExport remedyExport : remedyExportForm
					.getRemedyExports()) {
				out.write(remedyExport.getCSV());
				out.newLine();
			}
			out.close();
			break;
		case "remedy":
			RemedyExport remedyExport = (RemedyExport) obj;
			fileName = "Remedy." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			header = "CI Company,CI ID,CI Name,CI Description,Product Categorization Tier 1,"
					+ "Product Categorization Tier 2,Product Categorization Tier 3,"
					+ "Allocated Company,Allocated Org,Allocated Dept,Serial Number,"
					+ "Radio ID,Code Plug ID,UCS Alias,Additional Information,"
					+ "Warning Message,Status,Status Reason,Radio Type,UCM Security Group,"
					+ "Interconnect,Zone,Soft ID,Logical ID,Data Update Note";
			out.write(header);
			out.newLine();
			out.write(remedyExport.getCSV());
			out.close();
			break;
		case "dashboardEntity":
			EntityForm entityForm = (EntityForm) obj;
			fileName = "dashboardEntity." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			header = "Entity ID,Entity Name,Analog Radios,Digital Radios,P25 Radios";
			out.write(header);
			out.newLine();
			for (Entity entity : entityForm.getEntities()) {
				out.write(entity.getCSV());
				out.newLine();
			}
			out.close();
			break;
		case "dashboardZone":
			ZoneForm zoneForm = (ZoneForm) obj;
			fileName = "dashboardZone." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			header = "Zone type,Activated Radios,Deactivated Radios,Unassigned Radios";
			out.write(header);
			out.newLine();
			for (Zone zone : zoneForm.getZones()) {
				out.write(zone.getCSV());
				out.newLine();
			}
			out.close();
			break;
		default:
			fileName = "Error." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			break;
		}
		return f;
	}

	// generate an export file to send back to the client based on the http
	// request
	public static void generateResponseFile(HttpServletRequest request,
			HttpServletResponse response, File downloadFile) throws IOException {
		FileInputStream inputStream = new FileInputStream(downloadFile);

		ServletContext context = request.getServletContext();
		String appPath = context.getRealPath("");
		System.out.println("appPath = " + appPath);
		String fullPath = appPath + downloadFile.getAbsolutePath();
		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		response.flushBuffer();
		inputStream.close();
		outStream.close();
	}
}
