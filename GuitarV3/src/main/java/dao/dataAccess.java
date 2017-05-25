package dao;


public class dataAccess {
	public static String dataName = "mysqlDao";
	
	public static GuitarDao createGuitarDao() {
		GuitarDao result = null;
		try {
			Object o = Class.forName(dataName + "." + "GuitarDaoImpl").newInstance();
			result = (GuitarDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
