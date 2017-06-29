package service;

import java.util.HashMap;

import dao.DaoFactory;
import dao.PersonDao;
import model.Professor;
import model.Student;

/**
* <p>Title: PersonService</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class PersonService {

	private PersonDao dao = DaoFactory.createPersonDao();
	
	public HashMap<String, Student> findAllStudents(){
		HashMap<String, Student> students = dao.findAllStudents();
		return students;
	}
	public HashMap<String, Professor> findAllProfessors(){
		HashMap<String, Professor> professors = dao.findAllProfessors();
		return professors;
	}
	
	
}
