/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorolasolutions.com.DAO;

import java.util.Collection;

/**
 *
 * @author djfp43
 */
public interface DBManipulationDAO {
  public int insertObject(Object obj);
  public int deleteObject(Object obj);
  public boolean findObject(Object obj);
  public int updateObject(Object obj);
  public Object selectObject(Object obj);
  public Collection selectObjectList();  
}
