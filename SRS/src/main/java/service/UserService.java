package service;

import java.util.List;

import dao.DaoFactory;
import dao.UserDao;
import model.User;

/**
* <p>Title: UserService</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public class UserService {

	private UserDao dao = DaoFactory.createUserDao();
	public boolean getUser(User user) {
		List<User> users = dao.findAllUser();
		for(User u:users){
			if(u.validatePassword(user.getPassword(),user.getType())){
				return true;
			}
		}
		return false;
		
	}
}
