package com.test.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.bean.BoardBean;
import com.test.web.bean.MemberBean;
import com.test.web.bean.TestBean;
import com.test.web.dao.BoardDao;
import com.test.web.dao.MemberDao;

//어노테이션? 
//위치할 수 있는 곳? 클래스나 변수,메소드의 위

@Controller
public class test01 {
	
	//사용하고자 하는것을 선언 
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("hello")
	public String test1(String id, String pw) { //받는 데이타가 많지 않을때에는 바로 넣어줌! 
		
		System.out.println("id: "+id +", pw: "+pw);
		
		BoardBean bBean = boardDao.selectBoard(null);
		System.out.println("Title : " + bBean.getTitle());
		System.out.println("Content:" + bBean.getContent());
		
		
		return "test01"; //return값은 내가만든 jsp파일 이름임!! 
	}//end test1
	
	
	@RequestMapping("/test/test02")
	public String test2(TestBean tbean) {
		
		System.out.println( "id:" + tbean.getId() + ", pw:" + tbean.getPw() + " ,addr:" + tbean.getAddr() );
		
		MemberBean memberBean = memberDao.selectMember(null);
		System.out.println("USER_ID : "+ memberBean.getUserId());
		System.out.println("USER_PW : "+ memberBean.getUserpw());
		System.out.println("NAME : "+ memberBean.getName());
		
		return "test01";
	}
	
}


