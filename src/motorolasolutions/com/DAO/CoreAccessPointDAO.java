package motorolasolutions.com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import motorolasolutions.com.DataObject.CoreAccessPoint;

public class CoreAccessPointDAO implements DBManipulationDAO{
	private Connection connection;
	private Statement statement;
	
	@Override
	public int insertObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean findObject(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateObject(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object selectObject(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectObjectList() {
		List<CoreAccessPoint> coreAccessPoints = new ArrayList<CoreAccessPoint>();
        String query = "SELECT * FROM core_access_point";
        ResultSet rs = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
            	CoreAccessPoint coreAccessPoint= new CoreAccessPoint();
            	coreAccessPoint.setCore_access_point_id(rs.getInt("core_access_point_id"));
            	coreAccessPoint.setCore_access_point_name(rs.getString("core_access_point_name"));
            	coreAccessPoints.add(coreAccessPoint);
        }
        } catch (SQLException ex) {
        Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);            
        }
        return coreAccessPoints;
	}

}
