package springmvc.test.myBatis;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springmvc.dao.UserDao;
import com.springmvc.entry.User;
//spring 整合 Junit
@RunWith(SpringJUnit4ClassRunner.class) // 使用Springtest框架
@ContextConfiguration("classpath:applicationContext.xml") // 加载 spring容器配置
public class SMTest {
	@Autowired // 注入
	private UserDao userDao;

	@Test
	public void save() {
		User user = new User();
		user.setId(4);
		user.setMuch("4");
		userDao.saveUser(user);
		System.out.println(user.getId());
	}

	/*@Test
	public void update() {
		User user = userDao.findById(2);
		user.setSalary(2000);
		userDao.update(user);
	}

	@Test
	public void delete() {
		userDao.delete(3);
	}*/

	@Test
	public void findById() {
		User user = userDao.getUserById(1);
		System.out.println("user================="+user);
	}

	/*@Test
	public void findAll() {
		List<User> users = userDao.findAll();
		System.out.println(users);
	}*/
}
