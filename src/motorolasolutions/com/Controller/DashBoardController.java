package motorolasolutions.com.Controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import motorolasolutions.com.BusinessLogic.UCMExportLogic;
import motorolasolutions.com.DataObject.RadioUsageForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("DashBoard")
public class DashBoardController {

	@RequestMapping("/home")
	public String homeGenerator(Model model) {
		return "homepage";
	}

	@RequestMapping("/drawSmartZone")
	public @ResponseBody String drawSmartZoneGraphs() throws SQLException {
		// String str = "{\"item1\": \"" + 100 + "\",\"item2\": \"" + 350 +
		// "\"}";
		RadioUsageForm radioUsageForm = new RadioUsageForm();
		radioUsageForm.getSmartZoneRadioUsageList();
		/*
		 * for(RadioUsage radioUsage:radioUsageForm.getRadioUsages()){
		 * System.out.println(radioUsage); }
		 */
		String str = radioUsageForm.getJSONSmartZoneUsage();
		//System.out.println(radioUsageForm.getJSONSmartZoneUsage());
		return str;
	}

	@RequestMapping("/drawP25")
	public @ResponseBody String drawP25Graphs() throws SQLException {
		RadioUsageForm radioUsageForm = new RadioUsageForm();
		radioUsageForm.getP25RadioUsageList();
		/*
		 * for(RadioUsage radioUsage:radioUsageForm.getRadioUsages()){
		 * System.out.println(radioUsage); }
		 */
		String str = radioUsageForm.getJSONP25Usage();
		//System.out.println(radioUsageForm.getJSONP25Usage());
		return str;
	}

	@RequestMapping("/drawSummaryAll")
	public @ResponseBody String drawSummaryGraphs() throws SQLException {
		RadioUsageForm radioUsageForm = new RadioUsageForm();
		radioUsageForm.getAllRadioUsageList();
		/*
		 * for(RadioUsage radioUsage:radioUsageForm.getRadioUsages()){
		 * System.out.println(radioUsage); }
		 */
		String str = radioUsageForm.getJSONAllUsage();
		//System.out.println(radioUsageForm.getJSONAllUsage());
		return str;
	}

	// if the user choose to export the search result
	@RequestMapping(value = "/exportdashboard", method = RequestMethod.POST, params = { "entity" })
	public void sendDashboardEntityExport(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		RadioUsageForm radioUsageForm = new RadioUsageForm();
		radioUsageForm.getAllRadioUsageList();
		File downloadFile = UCMExportLogic.ucmListFileWriter("dashboardEntity",
				radioUsageForm.getEntityRadioUsage());
		UCMExportLogic.generateResponseFile(request, response, downloadFile);
	}
	
	// if the user choose to export the search result
	@RequestMapping(value = "/exportdashboard", method = RequestMethod.POST, params = { "zone" })
	public void sendDashboardZoneExport(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		RadioUsageForm radioUsageForm = new RadioUsageForm();
		File downloadFile = UCMExportLogic.ucmListFileWriter("dashboardZone",
				radioUsageForm.getSmartZoneP25RadioUsage());
		UCMExportLogic.generateResponseFile(request, response, downloadFile);
	}
}
