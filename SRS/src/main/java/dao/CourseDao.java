package dao;

import java.util.HashMap;

import model.Course;
/**
* <p>Title: CourseDao</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月28日
*/
public interface CourseDao {
	
	public Course getByCourseNo(String CourseNo);
	//查询所有课程
	public HashMap<String, Course> findAll();
	//添加课程
	void addCourse(Course course);
	//修改课程
	void updateCourse(Course course);
	//删除课程
	void deleteCourse(Course course);
}
