package motorolasolutions.com.DataObject;

import java.util.List;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;

public class ZoneForm {
	private List<Zone> zones;

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}

	public void getListEntityForm() {
		DAOFactory zoneDAOFactory = DAOFactory.getDAOFactory(DAOFactory.ZONE);
		DBManipulationDAO dBManipulationDAO = zoneDAOFactory
				.getDBManipulationDAO();
		this.zones = (List<Zone>) dBManipulationDAO.selectObjectList();
	}
}
