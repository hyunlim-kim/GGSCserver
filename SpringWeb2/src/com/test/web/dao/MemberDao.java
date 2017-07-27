package com.test.web.dao;

import java.util.List;

import com.test.web.bean.MemberBean;

public interface MemberDao {

	//정보 하나 뽑아오기 
	public MemberBean selectMember(MemberBean bean);


	//정보 리스트로 뽑아오기 
	public List<MemberBean> selectMemberList();


	//회원가입 
	public int insertMember(MemberBean bean);


	//회원수정 
	public int updateMember(MemberBean bean);


	//회원삭제 
	public int deleteMember(MemberBean bean);

	//회원 로그인 정보 조회 
	public MemberBean loginProc(MemberBean bean);
}

