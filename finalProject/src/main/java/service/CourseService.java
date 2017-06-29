package service;

import model.Course;

import java.util.HashMap;

import dao.CourseDao;
import dao.DaoFactory;

/**
* <p>Title: CourseService</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class CourseService {
	
	private CourseDao dao = DaoFactory.createCourseDao();
	
	public HashMap<String,Course> findAll(){
		HashMap<String,Course> courses = dao.findAll();
		return courses;
	}

	
}
