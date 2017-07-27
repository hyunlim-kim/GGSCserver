package com.test.web.dao;

import java.util.List;

import com.test.web.bean.BoardBean;



public interface BoardDao {

	public BoardBean selectBoard(BoardBean bBean);

	public List<BoardBean> selectBoardList();

	//회원가입 
	public int insertBoard(BoardBean bBean);


	//회원수정 
	public int updateBoard(BoardBean bBean);


	//회원삭제 
	public int deleteBoard(BoardBean bean);

}//end BoardDao
