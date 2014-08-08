package motorolasolutions.com.DataObject;

import java.util.List;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;

public class CoreAccessPointForm {
	private List<CoreAccessPoint> coreAccessPoints;
	
	public void getListCoreAccessPointForm() {
		DAOFactory coreAccessPointDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.CORE_ACCESS_POINT);
		DBManipulationDAO dBManipulationDAO = coreAccessPointDAOFactory
				.getDBManipulationDAO();
		this.coreAccessPoints=(List<CoreAccessPoint>) dBManipulationDAO.selectObjectList();
	}

	public List<CoreAccessPoint> getCoreAccessPoints() {
		return coreAccessPoints;
	}

	public void setCoreAccessPoints(List<CoreAccessPoint> coreAccessPoints) {
		this.coreAccessPoints = coreAccessPoints;
	}

}
