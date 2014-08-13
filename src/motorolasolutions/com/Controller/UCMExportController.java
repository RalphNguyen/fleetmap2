package motorolasolutions.com.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motorolasolutions.com.BusinessLogic.UCMExportLogic;
import motorolasolutions.com.DataObject.EntityForm;
import motorolasolutions.com.DataObject.ExportData;
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
	
	// get UCMExport Home
	@RequestMapping("/UCMExport")
	public String getUCMExport(Model model) {
		EntityForm entityForm = new EntityForm();
		entityForm.getListEntityForm();

		ExportData exportData = new ExportData();
		exportData.setEntityForm(entityForm);

		model.addAttribute("UCMExport", exportData);
		model.addAttribute("message",
				"Input any one of following fields to search for UCM to export");
		return "UCMExport";
	}

	// get input object, search for a list of UCM
	@RequestMapping(value = "/UCMExport", method = RequestMethod.POST)
	public String searchUCMExport(@ModelAttribute("UCMExport") ExportData exportData,
			Model model) {
		System.out.println(exportData.getExportSearchInput());
		UCMExportForm ucmExportForm = new UCMExportForm();
		ucmExportForm.getListUCMExportForm(exportData.getExportSearchInput());
		
		// if there is no return result
		if (ucmExportForm.getUcmExports().isEmpty()) {
			model.addAttribute("message",
					"No UCM found, please check your inputs");
			return "UCMExport";
		} else {
			//this.ucmExportForm1 = ucmExportForm;
			exportData.setUcmExportForm(ucmExportForm);
			model.addAttribute("UCMExport", exportData);
			return "UCMExportSearchResult";
		}
	}

	//if the user choose back to UCM export
	@RequestMapping(value = "/UCMExportResult", method = RequestMethod.POST, params = { "deny" })
	public String returnUCMExport(
			@ModelAttribute("UCMExport") ExportData exportData, Model model) {
		return getUCMExport(model);
	}

	// if the user choose to export the search result
	@RequestMapping(value = "/UCMExportResult", method = RequestMethod.POST, params = { "approve" })
	public void sendUCMExport(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("UCMExport") ExportData exportData, Model model) throws IOException {

		File downloadFile = UCMExportLogic.ucmListFileWriter("ucmList", exportData.getUcmExportForm());
		UCMExportLogic.generateResponseFile(request, response, downloadFile);
	}

}
