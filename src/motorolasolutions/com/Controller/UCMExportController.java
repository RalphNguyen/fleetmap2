package motorolasolutions.com.Controller;

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

import motorolasolutions.com.DataObject.EntityForm;
import motorolasolutions.com.DataObject.ExportData;
import motorolasolutions.com.DataObject.UCMExport;
import motorolasolutions.com.DataObject.UCMExportForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("UCMExport")
public class UCMExportController {

	private UCMExportForm ucmExportForm1;
	/**
	 * Size of a byte buffer to read/write file
	 */
	private static final int BUFFER_SIZE = 4096;

	@RequestMapping("/UCMExport")
	public String ucmExport(Model model) {
		EntityForm entityForm = new EntityForm();
		entityForm.getListEntityForm();

		ExportData exportData = new ExportData();
		exportData.setEntityForm(entityForm);

		model.addAttribute("UCMExport", exportData);
		model.addAttribute("search_not_found",
				"Input any one of following fields to search for UCM to export");
		return "UCMExportHome";
	}

	@RequestMapping(value = "/searchUCMExport", method = RequestMethod.POST)
	public String searchUCM(@ModelAttribute("UCMExport") ExportData exportData,
			Model model) {
		System.out.println(exportData.getExportSearchInput());
		UCMExportForm ucmExportForm = new UCMExportForm();
		// exportData.getUcmExportForm().getListUCMExportForm(exportData.getExportSearchInput());
		ucmExportForm.getListUCMExportForm(exportData.getExportSearchInput());
		if (ucmExportForm.getUcmExports().isEmpty()) {
			model.addAttribute("search_not_found",
					"No UCM found, please check your inputs");
			return "UCMExportHome";
		} else {
			for (UCMExport ucmExport : ucmExportForm.getUcmExports()) {
				System.out.println(ucmExport);
			}
			this.ucmExportForm1 = ucmExportForm;
			// model.addAttribute("UCMExport", exportSearchInput);
			exportData.setUcmExportForm(ucmExportForm);
			model.addAttribute("UCMExport", exportData);

			return "UCMExportSearchResult";
		}
	}

	/**
	 * Method for handling file download request from client
	 */
	@RequestMapping(value = "/sendUCMClient", method = RequestMethod.POST, params = { "deny" })
	public String sendUCMClientDeny(
			@ModelAttribute("UCMExport") ExportData exportData, Model model) {
		return "UCMExportHome";
	}

	@RequestMapping(value = "/sendUCMClient", method = RequestMethod.POST, params = { "approve" })
	public String sendUCMClientApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		// get absolute path of the application
		ServletContext context = request.getServletContext();
		String appPath = context.getRealPath("");
		System.out.println("appPath = " + appPath);

		// construct the complete absolute path of the file

		File downloadFile = ucmFileWriter("UCM", ucmExportForm1);
		String fullPath = appPath + downloadFile.getAbsolutePath();
		FileInputStream inputStream = new FileInputStream(downloadFile);

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

		inputStream.close();
		outStream.close();
		return "UCMExportHome";
	}

	private File ucmFileWriter(String type, UCMExportForm ucmExportForm) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd.hhmmss");// dd/MM/yyyy
		Date now = new Date();
		String fileName = "UCM." + sdfDate.format(now) + ".csv";
		File f = new File(fileName);
		try {
			// f.createNewFile();
			// System.out.println("Hello");
			// f.setWritable(true);
			FileWriter fstream = new FileWriter(f);
			BufferedWriter out = new BufferedWriter(fstream);
			for (UCMExport ucmExport : ucmExportForm.getUcmExports()) {
				out.write(ucmExport.getCSV());
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

	/*
	 * @RequestMapping("/UCMExport") public String ucmExport(Model model) {
	 * ExportSearchInput exportSearchInput = new ExportSearchInput();
	 * UCMExportForm ucmExportForm = new UCMExportForm();
	 * 
	 * EntityForm entityForm = new EntityForm(); entityForm.getListEntityForm();
	 * 
	 * model.addAttribute("UCMExport", ucmExportForm);
	 * model.addAttribute("UCMExport", exportSearchInput);
	 * model.addAttribute("search_not_found",
	 * "Input any one of following fields to search for UCM to export"); return
	 * "UCMExport"; }
	 * 
	 * 
	 * @RequestMapping(value = "/searchUCMExport", method = RequestMethod.POST)
	 * public String searchUCM(
	 * 
	 * @ModelAttribute("UCMExport") ExportSearchInput exportSearchInput,
	 * UCMExportForm ucmExportForm, Model model) {
	 * System.out.println("start date: " + exportSearchInput.getStartDate() +
	 * ", end date: " + exportSearchInput.getEndDate()); // UCMExportForm
	 * ucmExportForm = new UCMExportForm();
	 * ucmExportForm.getListUCMExportForm(exportSearchInput);
	 * if(ucmExportForm.getUcmExports().isEmpty()){
	 * model.addAttribute("search_not_found",
	 * "No UCM found, please check your inputs"); return "UCMExport"; } else{
	 * for (UCMExport ucmExport : ucmExportForm.getUcmExports()) {
	 * System.out.println("hahahaha: " + ucmExport.getUcm_id()); }
	 * this.ucmExportForm1 = ucmExportForm; // model.addAttribute("UCMExport",
	 * exportSearchInput); model.addAttribute("UCMExport", ucmExportForm);
	 * 
	 * return "UCMExport2"; } }
	 */

}
