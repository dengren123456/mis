package Test;


import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

import dao.DaoFactory;
import dao.TranscriptDao;
import model.Course;
import model.TranscriptEntry;
import model.User;

public class SectionTest {

	@Test
	public void test() {
		TranscriptDao transcriptDao = DaoFactory.createTranscriptDao();
		HashMap<String, TranscriptEntry> transcripts = transcriptDao.findAll();
		for(Entry<String,TranscriptEntry> t : transcripts.entrySet()){
			System.out.println(t.getValue().getStudent().getName());
			System.out.println(t.getValue().getSection().getSectionNo());
			System.out.println(t.getValue().getGrade());
		}
	}
	@Test
	public void find(){
		String ssn = "111-11-1111";
		User user = new User();
		user.setSsn(ssn);
		TranscriptDao transcriptDao = DaoFactory.createTranscriptDao();
		HashMap<String, TranscriptEntry>  transcripts= transcriptDao.findTranscriptByStudent(user);
		for(Entry<String,TranscriptEntry> t : transcripts.entrySet()){
			System.out.println(t.getValue().getStudent().getName());
			System.out.println(t.getValue().getSection().getSectionNo());
			System.out.println(t.getValue().getGrade());
		}
	}

}
