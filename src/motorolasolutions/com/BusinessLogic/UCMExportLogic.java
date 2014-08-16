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

import motorolasolutions.com.DataObject.RemedyExport;
import motorolasolutions.com.DataObject.RemedyExportForm;
import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.UCMConfigurationForm;
import motorolasolutions.com.DataObject.UCMExport;
import motorolasolutions.com.DataObject.UCMExportForm;

public class UCMExportLogic {
	private static final int BUFFER_SIZE = 4096;

	// to create a file of a list of UCM to send back to client
	public static File ucmListFileWriter(String type,
			Object obj) throws IOException {
		File f;
		FileWriter fstream;
		BufferedWriter out;
		String fileName;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd.hhmmss");// dd/MM/yyyy
		Date now = new Date();

		switch (type) {
		case "ucmList":
			UCMExportForm ucmExportForm = (UCMExportForm) obj;
			fileName = "UCM." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
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
			for (UCMConfiguration ucm_conf : ucmConfigurationForm.getUcmConfigurations()) {
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
			out.write(ucm_conf.getCSV());
			out.close();
			break;
		case "remedyList":
			RemedyExportForm remedyExportForm = (RemedyExportForm)obj;
			fileName = "Remedy." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			for(RemedyExport remedyExport:remedyExportForm.getRemedyExports()){
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
			out.write(remedyExport.getCSV());
			out.close();
			f = new File(fileName);
			break;
		default:
			fileName = "Error." + sdfDate.format(now) + ".csv";
			f = new File(fileName);
			break;
		}
		return f;
	}

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
