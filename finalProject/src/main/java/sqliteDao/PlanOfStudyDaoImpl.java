package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dao.PlanOfStudyDao;
import model.Course;
import model.Student;
import util.DBUtil;

public class PlanOfStudyDaoImpl implements PlanOfStudyDao {

	/* (non-Javadoc)
	 * @see dao.PlanOfStudyDao#findByStudent(model.Student)
	 */
	@Override
	public List<Course> findByStudent(Student student) {
		Connection Conn = DBUtil.getSqliteConnection();
		List<Course> courses = new ArrayList<Course>();
		String sql = "select * from PlanOfStudy where ssn=?";
		try{
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, student.getSsn());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
				Course course = courseDaoImpl.getByCourseNo(rs.getString("CourseNo")); 
				courses.add(course);
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

}
