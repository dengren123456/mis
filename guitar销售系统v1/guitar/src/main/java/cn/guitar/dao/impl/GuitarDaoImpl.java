package cn.guitar.dao.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.guitar.dao.GuitarDao;
import cn.guitar.entity.Guitar;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Repository("guitarDao")
public class GuitarDaoImpl extends BaseDaoImpl<Guitar> implements GuitarDao {
	@SuppressWarnings("unchecked")
	@Override
	public JSONArray search(double price,String builder,String model,String type,String backWood,String topWood){
		JSONArray array=new JSONArray();
		String hql="select g from Guitar g Where g.price=:price or g.builder=:builder or g.model=:model or g.type=:type or g.backWood=:backWood or g.topWood=:topWood";
		List<Guitar> list = new ArrayList<Guitar>();
		list=getSession().createQuery(hql)
				.setDouble("price", price)
				.setString("builder", builder.trim())
				.setString("model", model.trim())
				.setString("type", type.trim())
				.setString("backWood", backWood.trim())
				.setString("topWood", topWood.trim())
				.list();
		for(Guitar guitar:list){
			JSONObject dajo=new JSONObject();
			dajo.put("serialNumber", guitar.getSerialNumber());
			dajo.put("price", guitar.getPrice());
			dajo.put("builder", guitar.getBuilder());
			dajo.put("model", guitar.getModel());
			dajo.put("type", guitar.getType());
			dajo.put("backWood", guitar.getBackWood());
			dajo.put("topWood", guitar.getTopWood());
			array.add(dajo);
		}
		return array;
	}


}
