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
class UCMConfigurationDAOFactory extends DAOFactory {

    public UCMConfigurationDAOFactory() {
    }

    @Override
    public DBManipulationDAO getDBManipulationDAO() {
        return new UCMConfigurationDAO();
    }

    @Override
    public DBValidationDAO getDBValidationDAO() {
        return new UCMValidationDAO();
    }

	@Override
	public DBSearchDAO getDBSearchDAO() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
