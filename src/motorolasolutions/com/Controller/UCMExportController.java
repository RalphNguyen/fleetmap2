package motorolasolutions.com.Controller;

import java.io.File;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motorolasolutions.com.BusinessLogic.UCMExportLogic;
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
	public void sendUCMClientApprove(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		File downloadFile = UCMExportLogic.ucmListFileWriter("ucmList", ucmExportForm1);
		UCMExportLogic.generateResponseFile(request, response, downloadFile);
	}

}
