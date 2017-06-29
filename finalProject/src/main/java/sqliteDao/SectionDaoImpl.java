package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import dao.SectionDao;
import model.Course;
import model.Professor;
import model.ScheduleOfClasses;
import model.Section;
import model.User;
import util.DBUtil;

/**
* <p>Title: SectionDaoImpl</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月28日
*/
public class SectionDaoImpl implements SectionDao {

	/**
	 * 查询所有可选课程
	 */
	@Override
	public HashMap<String, Section> findAll() {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> sections = new HashMap<String, Section>();
		HashMap<String, Course> courses = new CourseDaoImpl().findAll();
		String sql = "select * from Section";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Course course = courses.get(rs.getString("course"));
				Section section = new Section(rs.getInt("sectionNo"), rs.getString("dayOfWeek").charAt(0),
				rs.getString("timeOfDay"), course, rs.getString("room"), rs.getInt("seatingCapacity"));
				ScheduleOfClasses sc = new ScheduleOfClasses(rs.getString("semester"));
				section.setOfferedIn(sc);
				sql = "select * from Person where ssn=?";
				pstmt = Conn.prepareStatement(sql);
				pstmt.setString(1, rs.getString("professor"));
				ResultSet per = pstmt.executeQuery();
				Professor pro = new Professor(per.getString("name"), per.getString("ssn"), per.getString("title"),
				per.getString("department"));
				section.setInstructor(pro);
				sections.put(Integer.toString(section.getSectionNo()), section);
			}
			if (rs != null) {
				rs.close();
				pstmt.close();
			}
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sections;
	}

	/**
	 * 添加可选课程
	 */
	@Override
	public void addSection(Section section, Professor professor, String semester) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "INSERT INTO Section(sectionNo,dayOfWeek,timeOfDay,room,seatingCapacity,professor,course,semester) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = Conn.prepareStatement(sql);
			String courseNO = section.getRepresentedCourse().getCourseNo();
			pstmt.setInt(1, section.getSectionNo());
			pstmt.setString(2, String.valueOf(section.getDayOfWeek()));
			pstmt.setString(3, section.getTimeOfDay());
			pstmt.setString(4, section.getRoom());
			pstmt.setInt(5, section.getSeatingCapacity());
			pstmt.setString(6, professor.getSsn());
			pstmt.setString(7, courseNO);
			pstmt.setString(8, semester);
			pstmt.executeUpdate();
			pstmt.close();
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据学期查询课程
	 */
	@Override
	public HashMap<String, Section> findBySemester(String semester) {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> sections = new HashMap<String, Section>();
		HashMap<String, Course> allCourses = new CourseDaoImpl().findAll();
		String sql = "select * from Section ,ScheduleOfClasses where  semester=? and FullSectionNo=sectionID";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, semester);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Set<HashMap.Entry<String, Course>> set = allCourses.entrySet();
				for (Iterator<Entry<String, Course>> iterator = set.iterator(); iterator.hasNext();) {
					HashMap.Entry<String, Course> entry = (HashMap.Entry<String, Course>) iterator.next();
					String key = entry.getKey();
					Course value = entry.getValue();
					if (rs.getString("representedCourse").equals(key)) {
						Section sec;
						sec = new Section(rs.getInt("sectionNo"), rs.getString("dayOfWeek").charAt(0),
								rs.getString("timeOfDay"), value, rs.getString("room"), rs.getInt("seatingCapacity"));
						sections.put(value.getCourseNo() + "-" + sec.getSectionNo(), sec);
					}
				}
			}
			if (rs != null) {
				rs.close();
				pstmt.close();
				Conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sections;
	}

	/**
	 * 更新可选课程
	 */
	@Override
	public void updateSection(Section section) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "update Section set seatingCapacity=? where sectionNo=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = Conn.prepareStatement(sql);
			pstmt.setInt(1, section.getSectionNo());
			pstmt.setInt(2, section.getSeatingCapacity()-1);
			pstmt.executeUpdate();
			pstmt.close();
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 删除可选课程
	 */
	@Override
	public void deleteSection(String FullSectionNo) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "DELETE FROM Section WHERE FullSectionNo=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, FullSectionNo);
			pstmt.executeUpdate();
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 查询教师教的课程
	 */
	@Override
	public HashMap<String, Section> findByProfessor(User user) {
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String, Section> sections = new HashMap<String, Section>();
		HashMap<String, Course> courses = new CourseDaoImpl().findAll();
		String sql = "select * from Section where professor=?";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, user.getSsn());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Course course = courses.get(rs.getString("course"));
				Section section = new Section(rs.getInt("sectionNo"), rs.getString("dayOfWeek").charAt(0),
				rs.getString("timeOfDay"), course, rs.getString("room"), rs.getInt("seatingCapacity"));
				ScheduleOfClasses sc = new ScheduleOfClasses(rs.getString("semester"));
				section.setOfferedIn(sc);
				sql = "select * from Person where ssn=?";
				pstmt = Conn.prepareStatement(sql);
				pstmt.setString(1, rs.getString("professor"));
				ResultSet per = pstmt.executeQuery();
				Professor pro = new Professor(per.getString("name"), per.getString("ssn"), per.getString("title"),
				per.getString("department"));
				section.setInstructor(pro);
				sections.put(Integer.toString(section.getSectionNo()), section);
			}
			if (rs != null) {
				rs.close();
				pstmt.close();
			}
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sections;
	}

	

}
