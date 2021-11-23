package com.mycompany.myapp01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp01.model.service.MemberService;
import com.mycompany.myapp01.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView memberInsert(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping(value = "signUp", method = RequestMethod.POST)
	public ModelAndView memberInsert(Member vo, HttpServletRequest request, RedirectAttributes rttr, ModelAndView mv) {
		int result = 0;
		try {
			String id = request.getParameter("memberId");
			String pwd = request.getParameter("memberPwd");
			String name = request.getParameter("memberName");
			vo.setMemberId(id);
			vo.setMemberPwd(pwd);
			vo.setMemberNm(name);
			result = mService.insertMember(vo);
			if(result == 1) {
				System.out.println("회원가입 정보 -> "+vo);
				String msg = "회원가입이 완료되었습니다.";
				rttr.addFlashAttribute("msg", msg);
				mv.setViewName("redirect:/index");
			} else {
				System.out.println("회원가입 정보 -> "+vo);
				String msg = "회원가입이 실패하였습니다..";
				rttr.addFlashAttribute("msg", msg);
				mv.setViewName("redirect:/index");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
}
