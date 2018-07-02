package org.myhome.ADMS.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.myhome.ADMS.domain.AdminVO;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	private SqlSession session;
	
	public static final String namespace = "org.myhome.ADMS.mapper.AdminMapper";

	@Override
	public AdminVO readPwd(String pwd) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".readPwd", pwd);
	}

	@Override
	public void updatePwd(String newPwd) {
		// TODO Auto-generated method stub
		session.update(namespace + ".updatePwd", newPwd);
	}

	@Override
	public AdminVO read() {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read");
	}

	@Override
	public void updateInfo(AdminVO vo) {
		// TODO Auto-generated method stub
		session.update(namespace + ".updateInfo", vo);
	}

}
