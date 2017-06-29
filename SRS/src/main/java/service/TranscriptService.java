package service;

import java.util.HashMap;

import dao.DaoFactory;
import dao.TranscriptDao;
import model.TranscriptEntry;
import model.User;

/**
* <p>Title: TranscriptService</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月28日
*/
public class TranscriptService {
	private TranscriptDao dao = DaoFactory.createTranscriptDao();
	
	public HashMap<String, TranscriptEntry> findTranscriptByStudent(User user){
		HashMap<String,TranscriptEntry> transcripts = dao.findTranscriptByStudent(user);
		return transcripts;
	}
}
