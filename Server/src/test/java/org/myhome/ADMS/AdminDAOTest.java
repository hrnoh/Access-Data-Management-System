package org.myhome.ADMS;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myhome.ADMS.domain.AdminVO;
import org.myhome.ADMS.persistence.AdminDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class AdminDAOTest {
	@Inject
	AdminDAO adminDAO;
	
	//@Test
	public void readPwdTest() throws Exception {
		System.out.println(adminDAO.readPwd("11111111"));
	}
	
	//@Test
	public void updatePwd() throws Exception {
		adminDAO.updatePwd("00000000");
	}
	
	@Test
	public void read() throws Exception {
		System.out.println(adminDAO.read());
	}
	
	//@Test
	public void updateInfo() throws Exception {
		AdminVO vo = adminDAO.read();
		vo.setName("뽀로리");
		adminDAO.updateInfo(vo);
	}
}
