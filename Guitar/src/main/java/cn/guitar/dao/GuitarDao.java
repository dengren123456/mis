package cn.guitar.dao;

import cn.guitar.entity.Guitar;
import net.sf.json.JSONArray;

public interface GuitarDao extends BaseDao<Guitar> {
	public JSONArray getByGuitarSpecSn(String guitarSpecSn);
}
