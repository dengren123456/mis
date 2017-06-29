package dao;

import java.util.HashMap;
import model.Professor;
import model.Section;
import model.User;

/**
* <p>Title: SectionDao</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月28日
*/
public interface SectionDao {
	//查询所有可选课程
	public HashMap<String, Section> findAll();
	//根据学期查询可选课程
	public HashMap<String,Section> findBySemester(String semester);
	//添加可选课程
	void addSection(Section section,Professor professor,String semester);
	//删除可选课程
	void deleteSection(String FullSectionNo);
	//更新可选课程
	void updateSection(Section section);
	//查询教师教的课程
	public HashMap<String, Section> findByProfessor(User user);
	
	 
}
