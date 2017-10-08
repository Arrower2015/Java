package com.itheima.test;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserDaoImpl;
import com.itheima.pojo.User;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年9月22日 上午11:42:50 
* 类说明 
*/
public class UserDaoTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception{
		String resource = "SqlMapConfig.xml";
		//1、加载你核心配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//2、创建工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	} 
	
	@Test
	public void testFindUserById() {
		UserDao daoImpl = new UserDaoImpl(sqlSessionFactory);
		User user = daoImpl.findUserById(10);
		System.err.println(user);
	}

	@Test
	public void testFindUserByUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

}
