package com.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.BoardBean;

import com.test.web.dao.BoardDao;

@Controller
public class BoardController {

	@Autowired
	private BoardDao boardDao;

	//DB-->Bean-->JSON
	@RequestMapping("/rest/selectBoard")
	@ResponseBody
	public Map<String, Object> selectBoard(BoardBean mBean){

		Map<String,Object> resMap = new HashMap<String, Object>();

		try {
			BoardBean resBean  = boardDao.selectBoard(mBean);

			resMap.put("result", "OK");
			resMap.put("boardBean",resBean);

		}catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		return resMap;

	}//end selectBoard


	//DB -> Bean -> JSON
	@RequestMapping("/rest/selectBoardList")
	@ResponseBody
	public Map<String, Object> selectBoardList(){

		Map<String,Object> resMap = new HashMap<String, Object>();

		try {
			List<BoardBean> list = boardDao.selectBoardList();

			resMap.put("result", "OK");
			resMap.put("BoardBeanList",list);

		}catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		return resMap;

	}//end selectBoardList

	//DB-->Bean-->JSON
	@RequestMapping("/rest/insertBoard")
	@ResponseBody
	public Map<String, Object> insertBoard(BoardBean mBean){

		Map<String,Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			int resVal = boardDao.insertBoard(mBean);


			if(resVal > 0) {
				resMap.put("boardBean",mBean);
				resMap.put("result", "OK");
			}
		}
		catch(DuplicateKeyException dke) {
			resMap.put("resultMsg","이미 존재하는 USER_ID입니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg",e.getMessage());


		}
		return resMap;

	}//end insertMember

	//DB-->Bean-->JSON
	@RequestMapping("/rest/updateBoard")
	@ResponseBody
	public Map<String, Object> updateBoard(BoardBean mBean){

		Map<String,Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			int resVal = boardDao.updateBoard(mBean);


			if(resVal > 0) {
				resMap.put("result", "OK");
				resMap.put("resultMsg","업데이트에 성공하였습니다.");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다. ");
			}
		}

		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg",e.getMessage());


		}
		return resMap;
	}

	//DB-->Bean-->JSON
	@RequestMapping("/rest/deleteBoard")
	@ResponseBody
	public Map<String, Object> deleteBoard(BoardBean mBean){

		Map<String,Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			int resVal = boardDao.deleteBoard(mBean);


			if(resVal > 0) {
				resMap.put("result", "OK");
				resMap.put("resultMsg","삭제에 성공하였습니다.");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다. ");
			}
		}

		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg",e.getMessage());


		}
		return resMap;

	}//end deleteMember



}//end BoardController