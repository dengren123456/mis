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
	
	@Override
	public JSONArray getByGuitarSpecSn(String guitarSpecSn){
		JSONArray array=new JSONArray();
		String hql="select g from Guitar g where g.spec.guitarSpecSn=:guitarSpecSn";
		List<Guitar> list = new ArrayList<Guitar>();
		list=getSession().createQuery(hql)
				.setString("guitarSpecSn", guitarSpecSn)
				.list();
		for(Guitar g:list){
			JSONObject jo = new JSONObject();
			jo.put("serialNumber", g.getSerialNumber());
			jo.put("price", g.getPrice());
			jo.put("builder", g.getSpec().getBuilder());
			jo.put("model", g.getSpec().getModel());
			jo.put("type", g.getSpec().getType());
			jo.put("backWood", g.getSpec().getBackWood());
			jo.put("topWood", g.getSpec().getTopWood());
			jo.put("numStrings", g.getSpec().getNumStrings());
			array.add(jo);
		}
		return array;
	}
}
