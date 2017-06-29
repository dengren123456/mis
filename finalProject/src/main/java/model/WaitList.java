package model;

import java.util.HashMap;

/**
* <p>Title: WaitList</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class WaitList {
	
	private String id;
	private Section section;
	private Student student;
	
	private HashMap<String, Student> enrolledStudents;
	
	
	
	public WaitList(String id) {
		
		enrolledStudents = new HashMap<String, Student>();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	

	private boolean confirmSeatAvailability() {
		if (enrolledStudents.size() < section.getSeatingCapacity()) return true;
		else return false;
	}

}
