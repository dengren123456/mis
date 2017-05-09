package cn.guitar.dao;

import cn.guitar.entity.Guitar;
import net.sf.json.JSONArray;

public interface GuitarDao extends BaseDao<Guitar> {
	
	public JSONArray search(double price,String builder,String model,String type,String backWood,String topWood);
}
