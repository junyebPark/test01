package com.mycompany.myapp01.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp01.model.vo.Member;

@Repository
public class MemberDao {
	@Autowired
	@Qualifier("sqlSessionTemplate") // 반드시 이 이름을 써주겠다. 꼭 쓰지않아도 됨
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int signUp(Member vo) throws Exception { 
		System.out.println("dao arg: "+ vo);
		int result = sqlSessionTemplate.insert("Member.signUp", vo);
		System.out.println("result arg:"+ result);
		return result;
	}
	
}
