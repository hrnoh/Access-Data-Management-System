package org.myhome.ADMS.persistence;

import java.util.List;

import org.myhome.ADMS.domain.UserVO;
import org.myhome.ADMS.util.UserSearchCriteria;

public interface UserDAO {
	public void create(UserVO vo);
	
	public UserVO read(Integer uno);
	
	public void update(UserVO vo);
	
	public void delete(Integer uno);
	
	public List<UserVO> list(UserSearchCriteria cri);
	
	public UserVO readForAccess(String accessKey);
	
	public void updateFaceEnc(Integer uno, String encoding);
}
