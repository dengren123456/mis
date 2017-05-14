package cn.guitar.service.impl;


import org.springframework.stereotype.Service;

import cn.guitar.entity.GuitarSpec;
import cn.guitar.service.GuitarSpecService;
import net.sf.json.JSONArray;

@Service("guitarSpecService")
public class GuitarSpecServiceImpl extends BaseServiceImpl<GuitarSpec> implements GuitarSpecService {
	
	@Override
	public JSONArray searchGuitarSpec(GuitarSpec guitarSpec){
		return guitarSpecDao.searchGuitarSpec(guitarSpec);
	}
	

}
