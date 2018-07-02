package org.myhome.ADMS.persistence;

import java.util.List;
import java.util.Map;

import org.myhome.ADMS.domain.LogVO;
import org.myhome.ADMS.util.LogSearchCriteria;

public interface LogDAO {
	public void create(LogVO vo);
	
	public LogVO read(Integer lno);
	
	public List<LogVO> list(LogSearchCriteria cri);
	
	public List<Map<String, Integer>> monthlyHistForUser(Integer uno);
	
	public List<Map<String, Integer>> monthlyHistForDoorlock(String mac);
	
	public List<LogVO> rcntHistOnUser(Integer uno);
	
	public List<LogVO> rcntHistOnDoorlock(String mac);
}
