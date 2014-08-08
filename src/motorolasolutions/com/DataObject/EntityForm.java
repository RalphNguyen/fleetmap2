package motorolasolutions.com.DataObject;

import java.util.List;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;

public class EntityForm {
	private List<Entity> entities;
	
	public void getListEntityForm() {
		DAOFactory entityDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.ENTITY);
		DBManipulationDAO dBManipulationDAO = entityDAOFactory
				.getDBManipulationDAO();
		this.entities=(List<Entity>) dBManipulationDAO.selectObjectList();
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
}
