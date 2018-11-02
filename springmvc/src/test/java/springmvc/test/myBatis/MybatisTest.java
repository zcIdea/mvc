package springmvc.test.myBatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.springmvc.dao.UserDao;
import com.springmvc.entry.User;

public class MybatisTest {

	@Test
	public void test(){
		
		String resource = "mybatis-conf.xml";
		//加载 mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//构建 sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中 sql 的 sqlSession
		SqlSession session = sessionFactory.openSession();
		//映射 sql 的标识字符串
		String statement = "com.springmvc.dao.UserDao"+".getUserById";
		//执行查询返回一个唯一 user 对象的 sql
		User user = session.selectOne(statement, 1);
		System.out.println(user);
		
	}
	@Test
	public void testDao(){
		
		String resource = "mybatis-conf.xml";
		//加载 mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//构建 sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中 sql 的 sqlSession
		SqlSession session = sessionFactory.openSession();
		//执行查询返回一个唯一 user 对象的 sql
		UserDao userDao = session.getMapper(UserDao.class);
		
		System.out.println(userDao.getUserById(1));
		
	}
}
