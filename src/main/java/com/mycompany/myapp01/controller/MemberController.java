package com.mycompany.myapp01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp01.model.service.MemberService;
import com.mycompany.myapp01.model.vo.Member;

@Controller
@SessionAttributes("msg") // session 처럼 동작을 한다. httpSession 만큼 scope가 넓지 않음. model 즉 request의 scope만큼임
// f5 중복실행되지 않음 한번 전달되고 다시 읽기가 되지 않음

public class MemberController {
	@Autowired
	private MemberService mService;
	
//	@RequestMapping(value = "index", method = RequestMethod.GET)
//	public ModelAndView memberInsert(ModelAndView mv) {
//		mv.setViewName("index");
//		return mv;
//	}
//	@RequestMapping(value = "signUp", method = RequestMethod.POST)
//	public ModelAndView memberInsert(Member vo, HttpServletRequest request, RedirectAttributes rttr, ModelAndView mv) {
//		System.out.println("ctrl arg: "+ vo);
//		int result = 0;
//		try {
//			String id = request.getParameter("memberId");
//			String pwd = request.getParameter("memberPwd");
//			String name = request.getParameter("memberName");
//			vo.setMemberId(id);
//			vo.setMemberPwd(pwd);
//			vo.setMemberNm(name);
//			result = mService.insertMember(vo);
//			if(result == 1) {
//				System.out.println("회원가입 정보 -> "+vo);
//				String msg = "회원가입이 완료되었습니다.";
//				rttr.addFlashAttribute("msg", msg);
//				mv.setViewName("redirect:/index");
//			} else {
//				System.out.println("회원가입 정보 -> "+vo);
//				String msg = "회원가입이 실패하였습니다..";
//				rttr.addFlashAttribute("msg", msg);
//				mv.setViewName("redirect:/index");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return mv;
//	}
	// forward 방식 url의 변화가 없다.
	// redirect 방식 url의 변화가 있다.(또 다른 url을 불러주고 바뀐다.기록에 남지 않는다.)
//	@RequestMapping("/")
//	public String testRedirect(Model model, @RequestParam("msg") String msg) {
//		model.addAttribute("msg", msg);
//		return "index";
//	}
	
	@RequestMapping(value = "signUp", method = RequestMethod.POST)
	public String signUp(Model model
			, Member vo
			, @RequestParam("memberId") String mId
			, @RequestParam("memberPwd") String mPwd
			, @RequestParam("memberName") String mName) {
		System.out.println("ctrl arg: "+ vo);
		int result = 0;
		String msg = "";
		try {
			result = mService.signUp(vo);
			if(result>0) {
				msg = "회원가입성공";
			} else {
				msg = "회원가입실패";
			}
		}catch (Exception e) {
			e.printStackTrace();
			msg = "회원가입과정에서 오류";
		}
		model.addAttribute("msg", msg);
		return "redirect:/";
	}
}
