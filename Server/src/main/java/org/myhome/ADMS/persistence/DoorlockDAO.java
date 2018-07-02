package org.myhome.ADMS.persistence;

import java.util.List;

import org.myhome.ADMS.domain.DoorlockVO;
import org.myhome.ADMS.util.DoorlockSearchCriteria;

public interface DoorlockDAO {
	public void create(DoorlockVO vo);
	
	public DoorlockVO read(String mac);
	
	public void update(DoorlockVO vo);
	
	public void delete(String mac);
	
	public List<DoorlockVO> list(DoorlockSearchCriteria cri);
	
	public void updateConnectionState(String mac, boolean isConn);
	
	public void updateLastConTime(String mac);
}
