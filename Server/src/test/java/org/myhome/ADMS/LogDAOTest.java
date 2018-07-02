package org.myhome.ADMS;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myhome.ADMS.domain.LogVO;
import org.myhome.ADMS.persistence.LogDAO;
import org.myhome.ADMS.util.LogSearchCriteria;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class LogDAOTest {
	@Inject
	private LogDAO logDAO;
	
	//@Test
	public void createTest() throws Exception {
		//'콩콩이', '자료보관실1', now(), 1, '20180702141322', 'kaieweirqowes.jpg', 0.2142, 4, 'F8-63-3F-40-7B-5D');
		LogVO vo = new LogVO();
		vo.setName("콩콩이");
		vo.setLocation("자료보관실1");
		vo.setAccessTime(new Date());
		vo.setSuccess(true);
		vo.setStoredFolderName("20180702141322");
		vo.setStoredFileName("kaieweirqowes.jpg");
		vo.setDistance(0.2142);
		vo.setUno(4);
		vo.setMac("F8-63-3F-40-7B-5D");
		
		logDAO.create(vo);
	}
	
	//@Test
	public void readTest() throws Exception {
		System.out.println(logDAO.read(3));
	}
	
	//@Test
	public void listTest() throws Exception {
		LogSearchCriteria cri = new LogSearchCriteria();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		cri.setName("콩콩이");
		cri.setLocation("");
		cri.setStartDate("2018-06-01");
		cri.setEndDate("2018-07-03");
		logDAO.list(cri);
	}
	
	//@Test
	public void monthlyHistForUserTest() throws Exception {
		List<Map<String, Integer>> results = logDAO.monthlyHistForUser(4);
		for(Map<String, Integer> result : results) {
			System.out.println(result.get("location") + ", " + result.get("cnt"));
		}
	}
	
	//@Test
	public void monthlyHistForDoorlockTest() throws Exception {
		List<Map<String, Integer>> results = logDAO.monthlyHistForDoorlock("F8-63-3F-40-7B-5D");
		for(Map<String, Integer> result : results) {
			System.out.println(result.get("name") + ", " + result.get("cnt"));
		}
	}
	
	//@Test
	public void rcntHistOnUserTest() throws Exception {
		logDAO.rcntHistOnUser(4);
	}
	
	@Test
	public void rcntHistOnDoorlockTest() throws Exception {
		logDAO.rcntHistOnDoorlock("F8-63-3F-40-7B-5D");
	}
}
