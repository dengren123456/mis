package cn.guitar.service;

import cn.guitar.entity.Guitar;
import net.sf.json.JSONArray;

public interface GuitarService extends BaseService<Guitar> {
	public JSONArray getByGuitarSpecSn(String guitarSpecSn);
}
