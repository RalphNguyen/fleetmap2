package motorolasolutions.com.DataObject;

import java.util.List;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;

public class SecurityGroupForm {
	private List<SecurityGroup> securityGroups;
	
	public void getListSecurityGroupForm() {
		DAOFactory securityGroupDAOFactory = DAOFactory
				.getDAOFactory(DAOFactory.SECURITYGROUP);
		DBManipulationDAO dBManipulationDAO = securityGroupDAOFactory
				.getDBManipulationDAO();
		this.securityGroups=(List<SecurityGroup>) dBManipulationDAO.selectObjectList();
	}

	public List<SecurityGroup> getSecurityGroups() {
		return securityGroups;
	}

	public void setSecurityGroups(List<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}

}
