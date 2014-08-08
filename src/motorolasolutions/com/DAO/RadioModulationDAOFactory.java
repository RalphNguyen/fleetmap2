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
class RadioModulationDAOFactory extends DAOFactory {

    public RadioModulationDAOFactory() {
    }

    @Override
    public DBManipulationDAO getDBManipulationDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DBValidationDAO getDBValidationDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public DBSearchDAO getDBSearchDAO() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
