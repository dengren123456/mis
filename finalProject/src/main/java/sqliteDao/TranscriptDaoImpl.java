package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import dao.TranscriptDao;
import model.Course;
import model.Section;
import model.Student;
import model.Transcript;
import model.TranscriptEntry;
import model.User;
import util.DBUtil;


/**
* <p>Title: TranscriptDaoImpl</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月27日
*/
public class TranscriptDaoImpl implements TranscriptDao {

	/**
	 * 查询所有选课
	 */
	
	@Override
	public HashMap<String, TranscriptEntry> findAll() {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Student> students = new PersonDaoImpl().findAllStudents();
		HashMap<String, Section> sections = new SectionDaoImpl().findAll();
		HashMap<String, TranscriptEntry> transcripts = new HashMap<String, TranscriptEntry>();
		String sql = "select * from Transcript";
		try{
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String str = rs.getString(2);
				Student student = students.get(rs.getString(1));
				Section section = sections.get(str.substring(str.indexOf("-")+2,str.length()));
				TranscriptEntry transcriptEntry = new TranscriptEntry(student, rs.getString(3), section);
				transcripts.put(section.getFullSectionNo(), transcriptEntry);
			}
			if(rs != null){
				rs.close();
				pstmt.close();
				Conn.close();
			} 
		}catch (SQLException e) {
				
			e.printStackTrace();
		}		
		return transcripts;
	}
	
	/**
	 * 查询个人选课
	 */
	@Override
	public HashMap<String, TranscriptEntry> getTranscriptBySsn(User user) {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Student> students = new PersonDaoImpl().findAllStudents();
		HashMap<String, Section> sections = new SectionDaoImpl().findAll();
		HashMap<String, TranscriptEntry> transcripts = new HashMap<String, TranscriptEntry>();
		String sql = "select * from Transcript where StudentSsn=?";
		try{
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, user.getSsn());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String str = rs.getString(2);
				Student student = students.get(rs.getString(1));
				Section section = sections.get(str.substring(str.indexOf("-")+2,str.length()));
				TranscriptEntry transcriptEntry = new TranscriptEntry(student, rs.getString(3), section);
				transcripts.put(section.getFullSectionNo(), transcriptEntry);
			}
			if(rs != null){
				rs.close();
				pstmt.close();
				Conn.close();
			} 
		}catch (SQLException e) {
			
		e.printStackTrace();
	}		
	return transcripts;
	}
	
	/**
	 * 查询学生已选课程
	 */
	@Override
	public HashMap<String, TranscriptEntry> findTranscriptByStudent(User user) {
		HashMap<String, TranscriptEntry> studentTranscripts = new HashMap<String, TranscriptEntry>();
		HashMap<String, TranscriptEntry> transcripts = new TranscriptDaoImpl().findAll();
		for (Entry<String,TranscriptEntry> t : transcripts.entrySet()) {
			String str = t.getKey();
			String sectionNo = str.substring(str.indexOf("-")+2,str.length());
			Section section = new SectionDaoImpl().findAll().get(sectionNo);
			TranscriptEntry transcriptEntry = t.getValue();
			Student student = transcriptEntry.getStudent();
			student.addSection(section);
			if (user.getSsn().equals(student.getSsn())) {
				studentTranscripts.put(transcriptEntry.getSection().getFullSectionNo(), transcriptEntry);
			}
		}
		return studentTranscripts;
	}

	/**
	 * 选课
	 */
	@Override
	public void addTranscript(TranscriptEntry transcriptentry) {
		Connection Conn = DBUtil.getSqliteConnection();
		Student student = transcriptentry.getStudent();
		Section section = transcriptentry.getSection();
		String sql = "INSERT INTO Transcript(studentSsn,fullSectionNo,grade) VALUES(?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = Conn.prepareStatement(sql);
			stmt.setString(1, student.getSsn());
			stmt.setString(3, transcriptentry.getGrade());
			stmt.setString(2, section.getFullSectionNo());
			stmt.executeUpdate();
			stmt.close();
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据课程查询
	 */
	@Override
	public HashMap<String, TranscriptEntry> getBysection(Section se) {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> sections = new SectionDaoImpl().findAll();
		HashMap<String, Student> students = new PersonDaoImpl().findAllStudents();
		HashMap<String, TranscriptEntry> transcripts = new HashMap<String, TranscriptEntry>();
		String sql = "select * from Transcript where fullSectionNo=?";
		try{
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, se.getFullSectionNo());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String str = rs.getString(2);
				Student student = students.get(rs.getString(1));
				Section section = sections.get(str.substring(str.indexOf("-")+2,str.length()));
				TranscriptEntry transcriptEntry = new TranscriptEntry(student, rs.getString(3), section);
				transcripts.put(section.getFullSectionNo(), transcriptEntry);
			}
			if(rs != null){
				rs.close();
				pstmt.close();
				Conn.close();
			} 
		}catch (SQLException e) {
			
		e.printStackTrace();
	}		
	return transcripts;
	}
	/**
	 * 删除选课
	 */
	@Override
	public void deleteTranscript(String fullSectionNo) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "DELETE FROM Transcript WHERE fullSectionNo=?  ";
		PreparedStatement stmt = null;
		try {
			stmt = Conn.prepareStatement(sql);
			stmt.setString(1, fullSectionNo);
			stmt.executeUpdate();
			stmt.close();
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 输入成绩
	 */
	@Override
	public void updateTranscript(String fullSectionNo, String ssn ,String grade) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "update Transcript set grade=? where  fullSectionNo=? and StudentSsn=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, ssn);
			pstmt.setString(2, fullSectionNo);
			pstmt.setString(3, grade);
			pstmt.executeUpdate();
			pstmt.close();
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

}
