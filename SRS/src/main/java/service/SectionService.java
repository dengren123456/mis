package service;

import java.util.HashMap;

import dao.DaoFactory;
import dao.SectionDao;
import model.Section;

/**
* <p>Title: SectionService</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class SectionService {

	private SectionDao dao = DaoFactory.createSectionDao();
	
	public HashMap<String, Section> findAll(){
		HashMap<String, Section> sections = dao.findAll();
		return sections;
	}
	
}
