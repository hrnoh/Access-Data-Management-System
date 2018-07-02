package org.myhome.ADMS.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.myhome.ADMS.domain.UserVO;
import org.myhome.ADMS.util.UserSearchCriteria;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;
	
	public static final String namespace="org.myhome.ADMS.mapper.UserMapper";
	
	@Override
	public void create(UserVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}

	@Override
	public UserVO read(Integer uno) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", uno);
	}

	@Override
	public void update(UserVO vo) {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer uno) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", uno);
	}

	@Override
	public List<UserVO> list(UserSearchCriteria cri) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", cri);
	}

	@Override
	public UserVO readForAccess(String accessKey) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".readForAccess", accessKey);
	}

	@Override
	public void updateFaceEnc(Integer uno, String encoding) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uno", uno);
		paramMap.put("encoding", encoding);
		session.update(namespace + ".updateFaceEnc", paramMap);
	}

}
