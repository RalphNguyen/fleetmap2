package motorolasolutions.com.DAO;

public class UCMExportDAOFactory extends DAOFactory {

	@Override
	public DBManipulationDAO getDBManipulationDAO() {
		// TODO Auto-generated method stub
		return new UCMExportDAO();
	}

	@Override
	public DBValidationDAO getDBValidationDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBSearchDAO getDBSearchDAO() {
		// TODO Auto-generated method stub
		return new UCMExportDAOSearch();
	}

}
