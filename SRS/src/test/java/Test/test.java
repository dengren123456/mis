package Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import dao.CourseDao;
import dao.DaoFactory;
import dao.SectionDao;
import model.Course;
import model.Professor;
import model.Section;
import model.Student;
import service.PlanOfStudyService;
import sqliteDao.CourseDaoImpl;
import sqliteDao.PersonDaoImpl;

public class test {

	@Test
	public void test() {
		CourseDao courseDao =  DaoFactory.createCourseDao();
		HashMap<String,Course> courses = new HashMap<String, Course>();
		courses= courseDao.findAll();
		for(Entry<String,Course> course : courses.entrySet()){
			System.out.println(course.getKey());
            System.out.println(course.getValue().getCourseName());
		}
	}
	@Test
	public void sectionTest(){
		SectionDao sectionDao =  DaoFactory.createSectionDao();
		HashMap<String,Section> sections = new HashMap<String, Section>();
		sections= sectionDao.findAll();
		for(Entry<String,Section> section : sections.entrySet()){
			System.out.println(section.getKey());
            System.out.println(section.getValue().getInstructor().getName());
		}
	}
	@Test
	public void add(){
		HashMap<String, Course> courses = new CourseDaoImpl().findAll();
		String courseNo = "001";
		String courseName = "002";
		String credits = "3.0";
		String prerequisite = "CMP283";
		Course course =new Course(courseNo, courseName, Double.valueOf(credits));
		course.addPrerequisite(courses.get(prerequisite));
		CourseDao courseDao =  DaoFactory.createCourseDao();
		courseDao.addCourse(course);
		System.out.println("123");
	}
	@Test
	public void delete(){
		String courseNo="001";
		HashMap<String, Course> courses = new CourseDaoImpl().findAll();
		Course course = courses.get(courseNo);
		CourseDao courseDao =  DaoFactory.createCourseDao();
		courseDao.deleteCourse(course);
		System.out.println("删除成功了！");
	}
	@Test
	public void add2(){
		int sectionNo=20;
		String dayOfWeek="1231";
		String timeOfDay="1231";
		String room="1231";
		int seatingCapacity=20;
		String courseNo = "ART101";
		String semester = "2123";
		String professorSsn = "123-45-6789";
		HashMap<String, Professor> professors = new PersonDaoImpl().findAllProfessors();
		Professor professor = professors.get(professorSsn);
		HashMap<String, Course> courses = new CourseDaoImpl().findAll();
		Course course = courses.get(courseNo);
		Section section =new Section(sectionNo, dayOfWeek.charAt(0), timeOfDay , course ,room ,seatingCapacity);
		SectionDao sectionDao =  DaoFactory.createSectionDao();
		sectionDao.addSection(section,professor,semester);
		System.out.println("添加成功了！");
	}
	@Test
	public void findPlan(){
		Student student = new Student("Joe Blow", "111-11-1111", "Math", "M.S.");
		PlanOfStudyService planOfStudyService = new PlanOfStudyService();
		List<Course> courses = planOfStudyService.findByStudent(student);
		for(Course c:courses){
			System.out.println(c.getCourseName());
		}
		
	}

}
