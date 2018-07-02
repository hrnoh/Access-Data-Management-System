package org.myhome.ADMS;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myhome.ADMS.domain.DoorlockVO;
import org.myhome.ADMS.persistence.DoorlockDAO;
import org.myhome.ADMS.util.DoorlockSearchCriteria;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class DoorlockDAOTest {
	@Inject
	private DoorlockDAO doorlockDAO;
	
	//@Test
	public void createTest() throws Exception {
		DoorlockVO vo = new DoorlockVO();
		vo.setLocation("자료창고2");
		vo.setMac("B8-12-11-D1-F9-A1");
		doorlockDAO.create(vo);
	}
	
	//@Test
	public void readTest() throws Exception {
		doorlockDAO.read("B8-12-11-D1-F9-A1");
	}
	
	//@Test
	public void updateTest() throws Exception {
		DoorlockVO vo = doorlockDAO.read("B8-12-11-D1-F9-A1");
		vo.setLocation("자료창고3");
		doorlockDAO.update(vo);
	}
	
	@Test
	public void deleteTest() throws Exception {
		doorlockDAO.delete("B8-12-11-D1-F9-A1");
	}
	
	//@Test
	public void listTest() throws Exception {
		DoorlockSearchCriteria cri = new DoorlockSearchCriteria();
		cri.setLocation("보관");
		doorlockDAO.list(cri);
	}
	
	//@Test
	public void updateConnectionStateTest() throws Exception {
		doorlockDAO.updateConnectionState("B8-12-11-D1-F9-A1", false);
	}
	
	//@Test
	public void updateLastConTimeTest() throws Exception {
		doorlockDAO.updateLastConTime("B8-12-11-D1-F9-A1");
	}
}
