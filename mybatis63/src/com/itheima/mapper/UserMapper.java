package com.itheima.mapper;

import java.util.List;

import com.itheima.pojo.User;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年9月22日 上午11:50:12 
* 类说明 
*/
public interface UserMapper {

	/**
	 * 根据用户ID查询用户信息
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * 根据用户名称模糊查询用户列表
	 * @param username
	 * @return
	 */
	public List<User> findUserByUsername(String username);
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	
}
