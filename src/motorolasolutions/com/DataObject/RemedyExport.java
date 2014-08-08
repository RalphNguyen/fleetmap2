/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DataObject;

import motorolasolutions.com.DAO.DAOFactory;
import motorolasolutions.com.DAO.DBManipulationDAO;

/**
 *
 * @author djfp43
 */
public class RemedyExport implements UpdateData{
    private String ci_id;
    private String ci_name;
    private String ci_company;
    private String ci_description;
    private String product_categorization_tier_1;
    private String product_categorization_tier_2;
    private String product_categorization_tier_3;
    private String allocated_company;
    private String additional_information;
    private String warning_message;
    private String status;
    private String logical_id;
    private String data_updated_note;
    private int ucm_id;
    
    // create a remedyExport
    public RemedyExport(int radio_id,String radio_type,int ucm_id){
        ci_company = "SA GRN";
        ci_id = "SAGRN.VRID"+radio_id;
        ci_name = ci_id;
        if(radio_type.equals("Radio")){
            ci_description = "SAGRN Radio ID";
            product_categorization_tier_3 = "Radio ID";
        }
        else{
            ci_description = "SAGRN Centracom ID";
            product_categorization_tier_3 = "Centracom ID";
        }
        product_categorization_tier_1 = "Terminal ID";
        product_categorization_tier_2 = "Radio";
        allocated_company = "SA GRN";
        additional_information = "";
        warning_message = "";
        logical_id = "";
        data_updated_note = "";
        status = "Deployed";
        this.ucm_id = ucm_id;
    } 
           
    @Override
    public String toString(){
        String s;
        s="('"+ci_id+"','"+ci_name+"','"+ci_company+"','"+ci_description+"','"+product_categorization_tier_1+"','"
                +product_categorization_tier_2+"','"+product_categorization_tier_3+"','"+allocated_company+"','"+
                additional_information+"','"+warning_message+"','"+status+"','"+logical_id+"','"+data_updated_note+"',"+ucm_id+")";
        return s;
    }

    @Override
    public int insertToDatabase() {
        DAOFactory remedyExportDAOFactory = DAOFactory.getDAOFactory(DAOFactory.REMEDYEXPORT);
        DBManipulationDAO dBManipulationDAO = remedyExportDAOFactory.getDBManipulationDAO();
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
}
