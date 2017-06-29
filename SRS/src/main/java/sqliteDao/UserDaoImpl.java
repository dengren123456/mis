package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import model.Student;
import model.User;
import util.DBUtil;


/**
* <p>Title: UserDaoImpl</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class UserDaoImpl implements UserDao {

	public List<User> findAllUser() {
		Connection Conn = DBUtil.getSqliteConnection();
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setSsn(rs.getString("ssn"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
				users.add(user);
			}
			if (rs != null) {
				rs.close();
			}
			pstmt.close();
			Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
