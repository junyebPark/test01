package com.mycompany.myapp01.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Member {
	// view page name 기준으로 작성
	private String memberId;
	private String memberPwd;
	private String memberNm;
	private Date memberEnrollDt;
	
	
	
	public Member() {
		super();
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberNm() {
		return memberNm;
	}
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}
	public Date getMemberEnrollDt() {
		return memberEnrollDt;
	}
	public void setMemberEnrollDt(Date memberEnrollDt) {
		this.memberEnrollDt = memberEnrollDt;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberNm=" + memberNm
				+ ", memberEnrollDt=" + memberEnrollDt + "]";
	}
	
	
}
