package model;

import java.util.ArrayList;

/**
* <p>Title: PlanOfStudy</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class PlanOfStudy {

	private Student student;
	private ArrayList<Course> courses;
	
	
	
	
	public PlanOfStudy(Student student) {
		this.setStudent(student);
		
		courses = new ArrayList<Course>();
	}
	
	
	public ArrayList<Course> addPlanOfStudy(Course cou) {
		courses.add(cou);
		return courses;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	
	//判断是否是PlanOfStudy中的课程
	public boolean VerifyPlan(Section s1){
		boolean ss = false;
		
		Course c1 = s1.getRepresentedCourse();
		
		for(Course c2 : courses){
			if(c1.getCourseNo().equals(c2.getCourseNo())){
				ss = true;
				break;
			}
		}
		return ss;
	}

}
