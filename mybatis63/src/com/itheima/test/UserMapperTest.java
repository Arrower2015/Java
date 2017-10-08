package com.itheima.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年9月22日 上午11:54:57 
* 类说明 
*/
public class UserMapperTest {

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
		//获取SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//根据SqlSession获取代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(10);
		System.err.println(user);
		
	}

	@Test
	public void testFindUserByUsername() {
		//获取SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//根据SqlSession获取代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = mapper.findUserByUsername("小");
		for (User user : list) {
			System.err.println(user);
		}
		
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

}
