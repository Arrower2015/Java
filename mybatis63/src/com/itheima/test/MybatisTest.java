package com.itheima.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.pojo.User;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年9月22日 上午9:50:10 
* 类说明 
*/
public class MybatisTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception{
		String resource = "SqlMapConfig.xml";
		//1、加载你核心配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//2、创建工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	} 
	
	/**
	 * 根据用户id查询一个用户
	 * @throws Exception 
	 */
	@Test
	public void test() throws Exception {
		
		//3、创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//4、执行   参数说明：1、指定的执行SQL语句；2、SQL语句中的参数！
		User user = sqlSession.selectOne("test.findUserById", 10);
		System.err.println(user);
		//5、释放资源
		sqlSession.close();
	}

	/**
	 * 根据用户名称模糊查询用户列表
	 * @throws Exception
	 */
	@Test
	public void testFindUserByUsername() throws Exception {
		String resource = "SqlMapConfig.xml";
		//1、加载你核心配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//2、创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//3、创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> list = sqlSession.selectList("test.findUserByUsername", "小");
		for (User user : list) {
			System.err.println(user);
		}
		//释放资源
		sqlSession.close();
		
	}
	
	/**
	 * 添加用户
	 * @throws Exception
	 */
	@Test
	public void testAddUser() throws Exception {
		String resource = "SqlMapConfig.xml";
		//1、加载你核心配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//2、创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//3、创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//
		User user = new User();
		user.setUsername("帅哥");
		user.setAddress("北京顺义白各庄");
		user.setBirthday(new Date());
		user.setSex("1");
		
		sqlSession.insert("test.addUser", user);
		
		//提交事务
		sqlSession.commit();
		
		//根据用户ID查询购物车或者订单
		System.err.println(user.getId());
		
		
		sqlSession.close();
	}
	
	/**
	 * 修改用户
	 * @throws Exception
	 */
	@Test
	public void testUpdateUserById() throws Exception {
		String resource = "SqlMapConfig.xml";
		//1、加载你核心配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//2、创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//3、创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建一个User
		User user = new User();
		user.setUsername("赵六");
		user.setId(29);
		sqlSession.update("test.updateUserById", user);
		
		//提交
		sqlSession.commit();
		sqlSession.close();
	}
	
	/**
	 * 删除用户
	 * @throws Exception
	 */
	@Test
	public void testDeleteUserById() throws Exception {
		
		String resource = "SqlMapConfig.xml";
		//1、加载你核心配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//2、创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//3、创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUserById", 29);
		
		//提交
		sqlSession.commit();
		
		sqlSession.close();
	}
}
