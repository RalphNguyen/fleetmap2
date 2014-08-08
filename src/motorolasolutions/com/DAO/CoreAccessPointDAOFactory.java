package motorolasolutions.com.DAO;


public class CoreAccessPointDAOFactory extends DAOFactory {

	@Override
	public DBManipulationDAO getDBManipulationDAO() {
		// TODO Auto-generated method stub
		return new CoreAccessPointDAO();
	}

	@Override
	public DBValidationDAO getDBValidationDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBSearchDAO getDBSearchDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
