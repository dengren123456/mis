package cn.guitar.service;

import cn.guitar.entity.GuitarSpec;
import net.sf.json.JSONArray;

public interface GuitarSpecService extends BaseService<GuitarSpec> {
	JSONArray searchGuitarSpec(GuitarSpec guitarSpec);
}
