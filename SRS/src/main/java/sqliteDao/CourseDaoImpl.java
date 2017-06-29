package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import dao.CourseDao;
import model.Course;
import util.DBUtil;


/**
* <p>Title: CourseDaoImpl</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月23日
*/
public class CourseDaoImpl implements CourseDao {
	
	
	/**
	 * 课程操作
	 */
	@Override
	public HashMap<String,Course> findAll(){
		Connection Conn = DBUtil.getSqliteConnection();
		HashMap<String,Course> courses = new HashMap<String, Course>();
		String sql = "select * from Course";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Course course = new Course(rs.getString(2), rs.getString(3), rs.getDouble(4));
				String prerequisite = rs.getString(5);
				//根据课程号查询课程
				if(prerequisite != null){
					Course cou = this.getByCourseNo(prerequisite);
					Course findcourse = new Course(cou.getCourseNo(), cou.getCourseName(), cou.getCredits());
					course.addPrerequisite(findcourse);
				}
				courses.put(course.getCourseNo(), course);
			}
			if(rs != null){
				rs.close();
				pstmt.close();
				Conn.close();
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return courses;
	}
	/**
	 * 添加课程
	 */
	@Override
	public void addCourse(Course course) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "INSERT INTO Course(courseNo,courseName,credits,prerequisite) VALUES(?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
		    pstmt.setString(1, course.getCourseNo());
	    	pstmt.setString(2, course.getCourseName());
	    	pstmt.setString(3, String.valueOf(course.getCredits()));
	    	for(Course p : course.getPrerequisites()){
	    		pstmt.setString(4,p.getCourseNo());
	    	}
			pstmt.executeUpdate();
			pstmt.close();
			Conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	/**
	 * 更新课程
	 */
	@Override
	public void updateCourse(Course course) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "update Course set courseNo=?,courseName=?,credits=? where  courseNo=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
	    	pstmt.setString(1, course.getCourseNo());
	    	pstmt.setString(2, course.getCourseName());
	    	pstmt.setString(3, String.valueOf(course.getCredits()));
	    	pstmt.setString(4, course.getCourseNo());
			pstmt.executeUpdate();
			pstmt.close();
			Conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	/**
	 * 删除课程
	 */
	@Override
	public void deleteCourse(Course course) {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "DELETE FROM Course WHERE courseNo=?";
		PreparedStatement pstmt=null;
		try {
			pstmt = Conn.prepareStatement(sql);
	    	pstmt.setString(1, course.getCourseNo());
			pstmt.executeUpdate();
			pstmt.close();
			Conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	@Override
	public Course getByCourseNo(String CourseNo) {
		Connection Conn = DBUtil.getSqliteConnection();
		Course course = new Course(null, null, 0);
		String sql = "select * from Course where courseNo=?";
		try{
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, CourseNo);
			ResultSet cou = pstmt.executeQuery();
			course = new Course(cou.getString("CourseNo"), cou.getString("CourseName"), cou.getDouble("credits"));
			pstmt.close();
			Conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}


}