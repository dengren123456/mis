package mock;

import java.util.HashMap;
import dao.CourseDao;
import model.Course;

public class CourseDaoImpl implements CourseDao {

	public HashMap<String,Course> findAll(){
		HashMap<String,Course> courses = new HashMap<String, Course>();
		Course c1,c2,c3,c4,c5;
		c1 = new Course("CMP101", "Beginning Computer Technology", 3.0);
		c2 = new Course("OBJ101", "Object Methods for Software Development", 3.0);
		c3 = new Course("CMP283", "Higher Level Languages (Java)", 3.0);
		c4 = new Course("CMP999", "Living Brain Computers", 3.0);
		c5 = new Course("ART101", "Beginning Basketweaving", 3.0);
		// Establish some prerequisites (c1 => c2 => c3 => c4).
		c2.addPrerequisite(c1);
		c3.addPrerequisite(c2);
		c4.addPrerequisite(c3);		
		courses.put(c1.getCourseNo(), c1);
		courses.put(c2.getCourseNo(), c2);
		courses.put(c3.getCourseNo(), c3);
		courses.put(c4.getCourseNo(), c4);
		courses.put(c5.getCourseNo(), c5);
		return courses;
	}


	@Override
	public Course getByCourseNo(String CourseNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	


}
