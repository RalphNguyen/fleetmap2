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
class RemedyExportDAOFactory extends DAOFactory {

    public RemedyExportDAOFactory() {
    }

    @Override
    public DBManipulationDAO getDBManipulationDAO() {
        return new RemedyExportDAO();
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
