/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

/**
 *
 * @author djfp43
 */
class RemedyDAOFactory extends DAOFactory {

    public RemedyDAOFactory() {
    }

    @Override
    public DBManipulationDAO getDBManipulationDAO() {
        return new RemedyDAO();
    }

    @Override
    public DBValidationDAO getDBValidationDAO() {
        return new RemedyValidationDAO();
    }

	@Override
	public DBSearchDAO getDBSearchDAO() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
