package org.myhome.ADMS.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.myhome.ADMS.domain.LogVO;
import org.myhome.ADMS.util.LogSearchCriteria;
import org.springframework.stereotype.Repository;

@Repository
public class LogDAOImpl implements LogDAO {

	@Inject
	private SqlSession session;
	
	public static final String namespace = "org.myhome.ADMS.mapper.LogMapper";
	
	@Override
	public void create(LogVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}

	@Override
	public LogVO read(Integer lno) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", lno);
	}

	@Override
	public List<LogVO> list(LogSearchCriteria cri) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", cri);
	}

	@Override
	public List<Map<String, Integer>> monthlyHistForUser(Integer uno) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".monthlyHistForUser", uno);
	}

	@Override
	public List<Map<String, Integer>> monthlyHistForDoorlock(String mac) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".monthlyHistForDoorlock", mac);
	}

	@Override
	public List<LogVO> rcntHistOnUser(Integer uno) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".rcntHistOnUser", uno);
	}

	@Override
	public List<LogVO> rcntHistOnDoorlock(String mac) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".rcntHistOnDoorlock", mac);
	}

}
