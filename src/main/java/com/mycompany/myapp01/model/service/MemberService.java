package com.mycompany.myapp01.model.service;

import org.springframework.stereotype.Service;

import com.mycompany.myapp01.model.vo.Member;
public interface MemberService {
	
		int signUp(Member vo);
}
