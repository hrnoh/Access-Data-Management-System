package org.myhome.ADMS;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myhome.ADMS.domain.UserVO;
import org.myhome.ADMS.persistence.UserDAO;
import org.myhome.ADMS.util.UserSearchCriteria;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class UserDAOTest {
	@Inject
	private UserDAO userDAO;
	
	//@Test
	public void createTest() throws Exception {
		UserVO vo = new UserVO();
		vo.setName("빠삐코");
		vo.setSex("남");
		vo.setAge(25);
		vo.setEmail("hello@hello.com");
		vo.setPhoneNum("010-1325-4552");
		vo.setOriginalFileName("빠삐코.jpg");
		vo.setStoredFolderName("20180702");
		vo.setStoredFileName("201807022245321543.jpg");
		
		userDAO.create(vo);
	}
	
	//@Test
	public void readTest() throws Exception {
		System.out.println(userDAO.read(4));
	}
	
	//@Test
	public void updateTest() throws Exception {
		UserVO vo = userDAO.read(4);
		vo.setName("수정된빠삐코");
		userDAO.update(vo);
	}
	
	//@Test
	public void deleteTest() throws Exception {
		userDAO.delete(1);
	}
	
	//@Test
	public void listTest() throws Exception {
		UserSearchCriteria cri = new UserSearchCriteria();
		cri.setType("p");
		cri.setKeyword("22");
		System.out.println(userDAO.list(cri));
	}
	
	//@Test
	public void readForAccessTest() throws Exception {
		System.out.println(userDAO.readForAccess("9343ade3a2d779cfb0f79f2c9553640292041daf"));
	}
	
	@Test
	public void updateFaceEncTest() throws Exception {
		String encoding = "1532829591024023520937509275901";
		userDAO.updateFaceEnc(3, encoding);
	}
}
