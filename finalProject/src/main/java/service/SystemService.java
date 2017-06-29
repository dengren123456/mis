package service;


import dao.CourseDao;
import dao.DaoFactory;
import dao.PersonDao;
import dao.SectionDao;
import dao.TranscriptDao;

public class SystemService {
	
	SectionDao sectionDao =  DaoFactory.createSectionDao();
	CourseDao courseDao =  DaoFactory.createCourseDao();
	PersonDao personDao =  DaoFactory.createPersonDao();
	TranscriptDao transcriptDao = DaoFactory.createTranscriptDao();
	
}
