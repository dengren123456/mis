package dao;

import java.util.List;

import model.Course;
import model.Student;

/**
* <p>Title: PlanOfStudyDao</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public interface PlanOfStudyDao {
	
	//通过查询所有的planOfStudy
	List<Course> findByStudent(Student student);
	

}
