package org.myhome.ADMS.persistence;

import org.myhome.ADMS.domain.AdminVO;

public interface AdminDAO {
	public AdminVO readPwd(String pwd);
	
	public void updatePwd(String newPwd);
	
	public AdminVO read();
	
	public void updateInfo(AdminVO vo);
}
