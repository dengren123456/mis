package cn.guitar.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.guitar.dao.GuitarSpecDao;
import cn.guitar.entity.GuitarSpec;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
 
@Repository("guitarSpecDao")
public class GuitarSpecDaoImpl extends BaseDaoImpl<GuitarSpec> implements GuitarSpecDao {
	
	@Override
	public JSONArray searchGuitarSpec(GuitarSpec guitarSpec){
		JSONArray array=new JSONArray();
		String hql="select s from GuitarSpec s where s.builder = '"+ guitarSpec.getBuilder() 
		+ "' or s.model= '"+ guitarSpec.getModel()
		+ "' or s.type= '"+ guitarSpec.getType()
		+ "' or s.backWood= '" + guitarSpec.getBackWood()
		+ "' or s.topWood= '"+ guitarSpec.getTopWood()
		+ "' or s.numStrings= '" + guitarSpec.getNumStrings() + "'";
		List<GuitarSpec> list = new ArrayList<GuitarSpec>();
		list=getSession().createQuery(hql).list();
		for(GuitarSpec g:list){
			JSONObject jo = new JSONObject();
			jo.put("guitarSpecSn", g.getGuitarSpecSn());
			array.add(jo);
		}
		return array;
	}
}
