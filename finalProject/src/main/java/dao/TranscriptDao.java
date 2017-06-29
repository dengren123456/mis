package dao;

import java.util.HashMap;

import model.Section;
import model.TranscriptEntry;
import model.User;

/**
* <p>Title: TranscriptDao</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public interface TranscriptDao {
	//查询所有选课
	public HashMap<String, TranscriptEntry> findAll();
	//查询所有学生选课
	public HashMap<String, TranscriptEntry> findTranscriptByStudent(User user);
	//选课
	public void addTranscript(TranscriptEntry transcriptentry);
	//删除已选课程
	public void deleteTranscript(String fullSectionNo);
	//输入已选课程
	public void updateTranscript(String fullSectionNo, String ssn , String grade);
	//根据学号查询已选课程
	HashMap<String, TranscriptEntry> getTranscriptBySsn(User user);
	//根据课程号查询
	HashMap<String, TranscriptEntry> getBysection(Section se);
}
