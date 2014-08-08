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
class RadioDAOFactory extends DAOFactory {

    public RadioDAOFactory() {
    }

    @Override
    public DBManipulationDAO getDBManipulationDAO() {
        return new RadioDAO();
    }

    @Override
    public DBValidationDAO getDBValidationDAO() {
        return new RadioValidationDAO();
    }

	@Override
	public DBSearchDAO getDBSearchDAO() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
