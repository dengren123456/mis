package Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import dao.CourseDao;
import dao.DaoFactory;
import dao.PersonDao;
import dao.SectionDao;
import dao.TranscriptDao;
import model.EnrollmentStatus;
import model.Professor;
import model.Section;
import model.Student;
import model.TranscriptEntry;
import model.User;
import service.TranscriptService;
import sqliteDao.TranscriptDaoImpl;

public class TranscriptTest {

	@Test
	public void test() {

		SectionDao sectionDao =  DaoFactory.createSectionDao();
		CourseDao courseDao =  DaoFactory.createCourseDao();
		PersonDao personDao =  DaoFactory.createPersonDao();
		TranscriptDao transcriptDao = DaoFactory.createTranscriptDao();
		User user = new User();
		user.setSsn("111-11-1111");
		HashMap<String,Section> sections = sectionDao.findAll();
	    Section section = sections.get("7");
	    Student student = personDao.findAllStudents().get("111-11-1111");
	    EnrollmentStatus status = section.enroll(student);
	   
	   if(status.value().equals("Enrollment successful!")){
		   TranscriptEntry transcriptEntry = new TranscriptEntry(student, null, section);
		   transcriptDao.addTranscript(transcriptEntry);
		   System.out.println("选课成功了！");
	   }else{
		   System.out.println(status.value());
	   }
	}
	@Test
	public void find(){
		User user = new User();
		user.setSsn("111-11-1111");
		TranscriptService transcriptService = new TranscriptService();
		HashMap<String,TranscriptEntry> transcripts = transcriptService.findTranscriptByStudent(user);
		for(Entry<String,TranscriptEntry> transcript : transcripts.entrySet()){
			System.out.println(transcript.getValue().getGrade());
		}
	}

}
