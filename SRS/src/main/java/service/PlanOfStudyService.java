package service;

import java.util.List;

import dao.DaoFactory;
import dao.PlanOfStudyDao;
import model.Course;
import model.Student;

/**
* <p>Title: PlanOfStudyService</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class PlanOfStudyService {
	
	private PlanOfStudyDao dao = DaoFactory.createPlanOfStudyDao();
	
	
	public List<Course> findByStudent(Student student){
		List<Course> courses = dao.findByStudent(student);
		return courses;
	}
}
