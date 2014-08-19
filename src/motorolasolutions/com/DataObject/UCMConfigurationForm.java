package motorolasolutions.com.DataObject;

import java.util.List;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;

public class UCMConfigurationForm {
	List<UCMConfiguration> ucmConfigurations;

	//getter & setter
	public List<UCMConfiguration> getUcmConfigurations() {
		return ucmConfigurations;
	}

	public void setUcmConfigurations(List<UCMConfiguration> ucmConfigurations) {
		this.ucmConfigurations = ucmConfigurations;
	}
	
	public void getListUCMConfigurationForm(UCMUpdateSearchInput ucmUpdateSearchInput){
		DAOFactory ucmDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.UCMCONFIGURATION);
		DBManipulationDAO dBManipulationDAO = ucmDAOFactory
				.getDBManipulationDAO();
		this.ucmConfigurations=(List<UCMConfiguration>) dBManipulationDAO.searchObjectList("searchToUpdate", ucmUpdateSearchInput);
	}
}
