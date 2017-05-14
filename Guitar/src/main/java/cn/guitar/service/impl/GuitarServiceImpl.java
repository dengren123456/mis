package cn.guitar.service.impl;


import org.springframework.stereotype.Service;

import cn.guitar.entity.Guitar;
import cn.guitar.service.GuitarService;
import net.sf.json.JSONArray;

@Service("guitarService")
public class GuitarServiceImpl extends BaseServiceImpl<Guitar> implements GuitarService {

	@Override
	public JSONArray getByGuitarSpecSn(String guitarSpecSn) {
		return guitarDao.getByGuitarSpecSn(guitarSpecSn);
	}
}
