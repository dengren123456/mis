package cn.guitar.dao;


import cn.guitar.entity.GuitarSpec;
import net.sf.json.JSONArray;

public interface GuitarSpecDao extends BaseDao<GuitarSpec> {
	JSONArray searchGuitarSpec(GuitarSpec guitarSpec);
}
