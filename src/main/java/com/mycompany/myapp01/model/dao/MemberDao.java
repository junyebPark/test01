package com.mycompany.myapp01.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp01.model.vo.Member;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertMember(Member vo) {
		return sqlSession.insert("Member.signUp", vo);
	}
	
}
