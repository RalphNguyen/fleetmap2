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

// Abstract class DAO Factory
public abstract class DAOFactory {

  // List of DAO types supported by the factory
  public static final int UCMCONFIGURATION = 1;
  public static final int RADIO = 2;
  public static final int REMEDY = 3;
  public static final int REMEDYEXPORT = 4;
  public static final int ENTITY = 5;
  public static final int AGENCY = 6;
  public static final int SECURITYGROUP = 7;
  public static final int USER = 8;
  public static final int RADIOMODULATION = 9;
  public static final int ZONE = 10;
  public static final int RADIOUSERCAPABILITIES = 11;
  public static final int P25IDCONSTRAINT = 12;
  public static final int CORE_ACCESS_POINT = 13;
  public static final int UCMEXPORT = 14;
  
  // There will be a method for each DAO that can be 
  // created. The concrete factories will have to 
  // implement these methods.
  public abstract DBManipulationDAO getDBManipulationDAO();
  public abstract DBValidationDAO getDBValidationDAO();
  public abstract DBSearchDAO getDBSearchDAO();

  public static DAOFactory getDAOFactory(
      int whichFactory) {
  
    switch (whichFactory) {
      case AGENCY: 
          return new AgencyDAOFactory();      
      case SECURITYGROUP    : 
          return new SecurityGroupDAOFactory();      
      case ENTITY    : 
          return new EntityDAOFactory();
      case UCMCONFIGURATION: 
          return new UCMConfigurationDAOFactory();      
      case RADIO    : 
          return new RadioDAOFactory();      
      case ZONE    : 
          return new ZoneDAOFactory();
      case RADIOMODULATION: 
          return new RadioModulationDAOFactory();      
      case USER   : 
          return new UserDAOFactory();      
      case RADIOUSERCAPABILITIES    : 
          return new RadioUserCapabilitiesDAOFactory();
      case REMEDY: 
          return new RemedyDAOFactory();      
      case REMEDYEXPORT   : 
          return new RemedyExportDAOFactory();      
      case P25IDCONSTRAINT    : 
          return new P25IdConstraintDAOFactory();  
      case CORE_ACCESS_POINT  : 
          return new CoreAccessPointDAOFactory(); 
      case UCMEXPORT  : 
          return new UCMExportDAOFactory();
      default           : 
          return null;
    }
  }
}
