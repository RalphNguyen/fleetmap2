/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.BusinessLogic;

import motorolasolutions.com.DataObject.Entity;
import motorolasolutions.com.DataObject.Radio;
import motorolasolutions.com.DataObject.Remedy;
import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.Zone;

/**
 *
 * @author djfp43
 */
public class UCMGeneratorAuto {
    public static void start(){
        System.out.println("UCM generator start...\n-----");
        //Remedy remedy = new Remedy("INC508612","DEWNR_TR01","DEH");
        Remedy remedy = new Remedy("INC508617","DEWNR_TR02","DEH");
        insertRemedy(remedy);
        
        // create entity from user input
        Entity entity = new Entity("Adelaide Convention Centre");
        System.out.println("entity: "+entity);
        
        // create zone from user input
        Zone zone = new Zone(2);
        
        //UCMConfiguration ucm_conf = new UCMConfiguration("INC508612","407TNY0828","Radio", "DEWNR-711759","","Registered and Activated");
        int radio_modulation_type_id = 1;
        UCMConfiguration ucm_conf = new UCMConfiguration(remedy.getRemedy_id(),"518TPX0015","Console", "00000USERNAME31","ucp00000","Registered and Activated",zone.getZone_id(),
                entity.getEntity_id(),entity.getAgency_id(),radio_modulation_type_id,"IVD","Yes","No");
        insertUCMConfiguration(ucm_conf, entity, zone);
        
        System.out.println("-----\nUCM generator end.");
    }
    
    // check & insert new Remedy
    private static void insertRemedy(Remedy remedy){
        System.out.println("Remedy: "+remedy);
        System.out.println("check duplicate remedy...");
        if(remedy.checkRemedyDuplicate()==1){
            System.out.println("remedy already exists, no need to insert to our Database");
        }
        else{
            System.out.println("insert new Remedy with ID = "+remedy.getRemedy_id()+" to our Database");
            remedy.insertToDatabase();
        }        
    }
    
    // check & insert new UCM
    private static void insertUCMConfiguration(UCMConfiguration ucm_conf, Entity entity, Zone zone){
        System.out.println(ucm_conf);
        //remedy.insertToDatabase();
        System.out.println("check duplicate radio serial number");
        
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
                // get an available Radio ID from the database
                 // then create a Radio
                int temp_radio_id = ucm_conf.checkRadioIDAvailability();
                if(temp_radio_id==0){
                    System.out.println("There is no available Radio ID, please check the database");
                }
                else{
                    Radio radio = new Radio(temp_radio_id,"Yes",ucm_conf.getRadio_modulation_type_id(),ucm_conf.getZone_id());
                    System.out.println(radio);
                    // update used_flag of the radio to the database
                    radio.updateToDatabase();
                    // get softID
                    ucm_conf.setRadio_id(radio.getRadio_id());
                    ucm_conf.setSecurity_group_id(entity.getSecurity_group_id());
                    ucm_conf.generateFields();
                    System.out.println(ucm_conf);
                    // insert to UCM_configuration table
                    ucm_conf.setUcm_id(ucm_conf.insertToDatabase());
                    System.out.println(ucm_conf);
                    // create then insert remedy_export
                    ucm_conf.insertRemedyExport();
                }       
            }
        }        
    }
}
