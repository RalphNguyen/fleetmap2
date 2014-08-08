/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DataObject;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;
import motorolasolutions.com.DAO.DBValidationDAO;

/**
 *
 * @author djfp43
 */
public class Remedy implements UpdateData {
    private String remedy_id;
    private String request_no;
    private String sub_entity;

    public String getSub_entity() {
        return sub_entity;
    }

    public String getRemedy_id() {
        return remedy_id;
    }

    public String getRequest_no() {
        return request_no;
    }

    
    public Remedy(){        
    }
    
    public Remedy(String remedy_id, String request_no, String sub_entity){
        this.remedy_id = remedy_id;
        this.request_no = request_no;
        this.sub_entity = sub_entity;
    }

    public int checkRemedyDuplicate() {
        // Create a DAO
        DAOFactory remedyDAOFactory = DAOFactory.getDAOFactory(DAOFactory.REMEDY);
        DBValidationDAO dbvalidationDAO = remedyDAOFactory.getDBValidationDAO();
        return (dbvalidationDAO.checkDuplicate(this));
    }

    @Override
    public int insertToDatabase() {
        DAOFactory remedyDAOFactory = DAOFactory.getDAOFactory(DAOFactory.REMEDY);
        DBManipulationDAO dBManipulationDAO = remedyDAOFactory.getDBManipulationDAO();
        return(dBManipulationDAO.insertObject(this));
    }

    @Override
    public int updateToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeFromDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        String s;
        s= "('"+remedy_id+"','"+request_no+"','"+sub_entity+"')";
        return s;
    }
    
}
