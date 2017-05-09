package cn.guitar.service;

import cn.guitar.entity.Guitar;
import net.sf.json.JSONArray;

public interface GuitarService extends BaseService<Guitar> {
	public JSONArray search(double price,String builder,String model,String type,String backWood,String topWood);
}
