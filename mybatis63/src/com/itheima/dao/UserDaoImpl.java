package com.itheima.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.pojo.User;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年9月22日 上午11:39:04 
* 类说明 
*/
public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(Integer id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		//执行，返回
		User user = sqlSession.selectOne("test.findUserById", id);
		
		//释放资源
		sqlSession.close();
		
		return user;
	}

	@Override
	public List<User> findUserByUsername(String username) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		//
		List<User> list = sqlSession.selectList("test.findUserByUsername", username);
		
		return list;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

}
