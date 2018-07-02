package org.myhome.ADMS.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.myhome.ADMS.domain.DoorlockVO;
import org.myhome.ADMS.util.DoorlockSearchCriteria;
import org.springframework.stereotype.Repository;

@Repository
public class DoorlockDAOImpl implements DoorlockDAO {

	@Inject
	private SqlSession session;
	
	public static final String namespace = "org.myhome.ADMS.mapper.DoorlockMapper";
	
	@Override
	public void create(DoorlockVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}

	@Override
	public DoorlockVO read(String mac) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", mac);
	}

	@Override
	public void update(DoorlockVO vo) {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(String mac) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", mac);
	}

	@Override
	public List<DoorlockVO> list(DoorlockSearchCriteria cri) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", cri);
	}

	@Override
	public void updateConnectionState(String mac, boolean isConn) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("mac", mac);
		paramMap.put("isConn", isConn);
		session.update(namespace + ".updateConnectionState", paramMap);
	}
	
	@Override
	public void updateLastConTime(String mac) {
		session.update(namespace + ".updateLastConTime", mac);
	}

}
