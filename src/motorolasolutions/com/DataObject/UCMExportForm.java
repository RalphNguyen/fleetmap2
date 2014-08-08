package motorolasolutions.com.DataObject;

import java.util.List;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBSearchDAO;

public class UCMExportForm {
	private List<UCMExport> ucmExports;
	
	public List<UCMExport> getUcmExports() {
		return ucmExports;
	}

	public void setUcmExports(List<UCMExport> ucmExports) {
		this.ucmExports = ucmExports;
	}
	
	public void getListUCMExportForm(ExportSearchInput exportSearchInput) {
		DAOFactory ucmExportDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.UCMEXPORT);
		DBSearchDAO dBSearchDAO = ucmExportDAOFactory
				.getDBSearchDAO();
		this.ucmExports=(List<UCMExport>)dBSearchDAO.selectObjectList(exportSearchInput);
	}
}
