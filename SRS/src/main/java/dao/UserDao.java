package dao;

import java.util.List;

import model.User;

/**
* <p>Title: UserDao</p>
* <p>Description: </p>
* @author 邓忍
* @date 2017年6月29日
*/
public interface UserDao {
	
	public List<User> findAllUser();
	
	
	
}
