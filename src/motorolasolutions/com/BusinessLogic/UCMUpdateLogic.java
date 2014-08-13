/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.BusinessLogic;

import motorolasolutions.com.DataObject.Radio;
import motorolasolutions.com.DataObject.UCMConfiguration;

/**
 *
 * @author djfp43
 */
public class UCMUpdateLogic {
    public static void start(){
        System.out.println("UCM update start..\n-----");
        // input data
        
        // create a UCM object based on search keyword, might be one of: radio_serial_number, radio_user_name, radio_id
        UCMConfiguration ucm_conf = new UCMConfiguration("518TPX0005");
        // search for that UCM in the Database
        ucm_conf = getUCMData(ucm_conf);
        if(ucm_conf.getUcm_id()==0){
            System.out.println("No corresponding UCM in the Database, please check your input");
        }
        else{
            System.out.println("Search result: "+ucm_conf);
            //ucm_conf = getUCMData(ucm_conf);
            ucm_conf = setUCMData(ucm_conf);
            updateUCMData(ucm_conf);
        }
        System.out.println("-----\nUCM update finish..");
    }
    
    private static UCMConfiguration getUCMData(UCMConfiguration ucm_conf){
        System.out.println("Search/Get UCM data");
        UCMConfiguration ucm_conf_searchResult = (UCMConfiguration)ucm_conf.searchForUpdate();
        return ucm_conf_searchResult;
    }
    
    // update data to the ucm object that will be updated to the database
    private static UCMConfiguration setUCMData(UCMConfiguration ucm_conf){
        System.out.println("Set UCM data");
        ucm_conf.setActivation_status("Deregistered");
        ucm_conf.setRadio_serial_number("518TPX0019");
        ucm_conf.setRadio_user_alias("00000USERNAME35");
        ucm_conf.setUcp("ucp00001");        
        return ucm_conf;
    }
    
    private static void updateUCMData(UCMConfiguration ucm_conf){
        System.out.println("Update UCM data");
         // check radio serial duplicate
        if(ucm_conf.checkRadioSerialDuplicate()!=0){
            System.out.println("Radio serial number already exists, cannot add to Database, please change it");
        }
        else{
            System.out.println("Radio serial number - done, check duplicate radio user alias");
            // check radio name duplicate
            if(ucm_conf.checkRadioUserAliasDuplicate()==1){
                System.out.println("Radio user alias already exists, cannot add to Database, please change it");
            }
            else{
                // create a radio, then update its used_flag to 'No' if it was deregistered
                Radio radio = new Radio(ucm_conf.getRadio_id());
                radio.removeFromDatabase();
                System.out.println(ucm_conf);
                // update to UCM_configuration table
                ucm_conf.updateToDatabase();
            }
        }       
        
    }
}
