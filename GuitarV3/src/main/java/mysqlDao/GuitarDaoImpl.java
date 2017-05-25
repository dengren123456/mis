package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.GuitarDao;
import model.Builder;
import model.Guitar;
import model.GuitarSpec;
import model.Inventory;
import model.Type;
import model.Wood;
import util.DBUtil;

public class GuitarDaoImpl implements GuitarDao {

	private static final Object model = null;
	@Override
	public Inventory getInventorys() throws SQLException {
		// TODO Auto-generated method stub
		Connection Conn = DBUtil.getSqliteConnection();
		//Connection Conn = DBUtil.getMysqlConnection();
		String sql = "select * from guitar";
		Inventory inventory = new Inventory();
		
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Builder	builder1=Builder.fromString(rs.getString("builder"));
				Type type1=Type.fromString(rs.getString("type"));
				Wood backwood1=Wood.fromString(rs.getString("backWood"));
				Wood topwood1=Wood.fromString(rs.getString("topWood"));
				inventory.addGuitar(rs.getString("serialNumber"),rs.getDouble("price"), 
					      new GuitarSpec(builder1,
					    		  rs.getString("model"),
					    		  type1,
					    		  rs.getInt("numStrings"),
					    		  backwood1,
					    		  topwood1));
						
			}			
			if(rs != null){
				rs.close();
			}
			
			pstmt.close();
			Conn.close();
		return inventory;
	}
	@Override
	public void addGuitar(Guitar guitar) throws SQLException {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "INSERT INTO guitar (serialNumber,price,builder,model,type,numStrings,backWood,topWood) VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = Conn.prepareStatement(sql);
		GuitarSpec spec = guitar.getSpec();
	    stmt.setString(1, guitar.getSerialNumber());
		stmt.setDouble(2,guitar.getPrice());
		stmt.setString(3, spec.getBuilder().toString());
		stmt.setString(4, spec.getModel().toString());
		stmt.setString(5, spec.getType().toString());
		stmt.setString(6, String.valueOf(spec.getNumStrings()));
		stmt.setString(7, spec.getBackWood().toString()); 
		stmt.setString(8, spec.getTopWood().toString());
		stmt.executeUpdate();	
		
		stmt.close();
		Conn.close();
		
	}
	@Override
	public void deleteGuitar(Guitar guitar) throws SQLException {
		Connection Conn = DBUtil.getSqliteConnection();	
		String sql = "DELETE FROM guitar WHERE serialNumber=?";
		PreparedStatement stmt = Conn.prepareStatement(sql);	
	    stmt.setString(1, guitar.getSerialNumber());
		stmt.executeUpdate();	
		stmt.close();
		Conn.close();
		
	}

	



}
