/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DataObject;

/**
 *
 * @author djfp43
 */
public class Agency {   
    private int agency_id;
    private String agency_name;
    private String agency_description;

    public void setAgency_id(int agency_id) {
        this.agency_id = agency_id;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
    }

    public void setAgency_description(String agency_description) {
        this.agency_description = agency_description;
    }

    public int getAgency_id() {
        return agency_id;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public String getAgency_description() {
        return agency_description;
    }
}