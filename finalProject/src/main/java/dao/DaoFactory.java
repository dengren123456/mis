package dao;

import model.WaitList;

/**
* <p>Title: DaoFactory</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月28日
*/
public class DaoFactory {
	private static String daoName = "sqliteDao";
//	private static String daoName = "mock";
	

	
	public static CourseDao createCourseDao() {
		CourseDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "CourseDaoImpl").newInstance();
			result = (CourseDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static SectionDao createSectionDao() {
		SectionDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "SectionDaoImpl").newInstance();
			result = (SectionDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	public static UserDao createUserDao() {
		UserDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "UserDaoImpl").newInstance();
			result = (UserDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static PersonDao createPersonDao() {
		PersonDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "PersonDaoImpl").newInstance();
			result = (PersonDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static TranscriptDao createTranscriptDao() {
		TranscriptDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "TranscriptDaoImpl").newInstance();
			result = (TranscriptDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static PlanOfStudyDao createPlanOfStudyDao() {
		PlanOfStudyDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "PlanOfStudyDaoImpl").newInstance();
			result = (PlanOfStudyDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static WaitListDao createWaitListDao() {
		WaitListDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "WaitListDaoImpl").newInstance();
			result = (WaitListDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}
