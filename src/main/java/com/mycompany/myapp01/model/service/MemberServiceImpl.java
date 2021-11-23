package com.mycompany.myapp01.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp01.model.dao.MemberDao;
import com.mycompany.myapp01.model.vo.Member;

@Service("mService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao mDao;
	
	public int insertMember(Member vo) {
		int result=0;
	      try {
	         result = mDao.insertMember(vo);
	         System.out.println(result);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return result;

	}
}
