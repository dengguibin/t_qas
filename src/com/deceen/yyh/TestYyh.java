package com.deceen.yyh;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deceen.mty.atom.action.TMtyAtomAction;
import com.deceen.mty.atom.mapper.TMtyAtomMapper;
import com.deceen.mty.atom.model.TMtyAtom;
import com.deceen.mty.atom.service.TMtyAtomService;

public class TestYyh {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void init(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	/*@Test
	public void test05() {
		QasTDiagnosticmenuinfoMapper bean = (QasTDiagnosticmenuinfoMapper) applicationContext.getBean("qasTDiagnosticmenuinfoMapper");
		//List<IMenu> list = bean.menuAnaly("1");
		List<IMenu> list=null;
		for (IMenu iMenu : list) {
			String menuName = iMenu.getMenuName();
			System.out.println(menuName);
		}
	}*/
	
	@Test
	public void testGetUserById() {
//		UserDao userDao = applicationContext.getBean(UserDao.class);
//		User user = userDao.getUserById(30);
//		System.out.println(user);
	}
	
	/*@Test
	public void test01() {
		String nowDate = DateUtil.getNowDate();
		System.out.println(nowDate);
	}*/

	@Test
	public void test02() {
		TMtyAtomAction taa = applicationContext.getBean(TMtyAtomAction.class);
		TMtyAtom tMtyAtom = new TMtyAtom();
		tMtyAtom.setId("1");
		taa.setBean(tMtyAtom);
//		taa.select();
		System.out.println(taa.getBean());
	}
	
	@Test
	public void test03() {
		TMtyAtomMapper taa = applicationContext.getBean(TMtyAtomMapper.class);
		TMtyAtom atom = taa.select("1");
		System.out.println(atom);
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@Test
	public void test04() {
		TMtyAtomService bean = (TMtyAtomService) applicationContext.getBean("tMtyAtomService");
		List listAll = bean.listAll("111");
		System.out.println("11111");
	}
	
}
