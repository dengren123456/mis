package service;

import java.sql.SQLException;
import dao.GuitarDao;
import dao.dataAccess;
import model.Guitar;
import model.Inventory;

public class GuitarService {
	 private GuitarDao dao = dataAccess.createGuitarDao();
	 
	 public Inventory getInventory() throws SQLException{ 
		 Inventory inventory = new Inventory();
		 inventory = dao.getInventorys();
		 return inventory;
	 }
	 public void addGuitar(Guitar guitar) throws SQLException{
		 dao.addGuitar(guitar);
	 }
	 
	 public void deleteGuitar(Guitar guitar) throws SQLException{
		 dao.deleteGuitar(guitar);
	 }
}
