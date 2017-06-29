package service;

import java.util.Map;

import dao.DaoFactory;
import dao.SectionDao;
import model.ScheduleOfClasses;
import model.Section;

/**
* <p>Title: ScheduleOfClassesService</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class ScheduleOfClassesService {
	
    private static ScheduleOfClasses sc;

    private static SectionDao dao;
    public ScheduleOfClasses getScheduleOfClasses() {
		return sc;
	}    
   
    
    public ScheduleOfClassesService(String semester, SectionDao dao){
    	sc = new ScheduleOfClasses(semester, dao.findBySemester(semester));
    }
  



}
