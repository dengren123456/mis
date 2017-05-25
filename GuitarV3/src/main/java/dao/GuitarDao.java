package dao;

import java.sql.SQLException;
import model.Guitar;
import model.Inventory;

public interface GuitarDao {
	public Inventory getInventorys() throws SQLException;
	public void addGuitar(Guitar guitar) throws SQLException;
	public void deleteGuitar(Guitar guitar) throws SQLException;
}
